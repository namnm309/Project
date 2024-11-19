/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OutPutMethod;

import java.util.ArrayList;
import java.util.Scanner;
import controller.HotelController;
import model.Hotel;
import InputCheckMethod.InputCheck;

/**
 *
 * @author Ngoc Lan
 */
public class outputMethod implements outputMain {

    public static Scanner sc = new Scanner(System.in);
    private HotelController hotelController;

    public outputMethod() {
        this.hotelController = new HotelController();
    }

    public outputMethod(HotelController hotelController) {
        this.hotelController = hotelController;
    }

    @Override
    public Hotel inputHotel(String action, String x) {
        String hotel_id = "";
        if (action.equals("add")) {
            hotel_id = x;
        }

        String hotel_name = InputCheck.stringCheck("Hotel name", "^[a-zA-Z\\s]+$");
        int hotel_room_available = InputCheck.readInteger("Hotel room available", 1, 1000);
        String hotel_address = InputCheck.stringCheck("Hotel address", "^[a-zA-Z0-9 /,\\s]+$");
        String hotel_phone = InputCheck.phoneCheck("Hotel phone", "^[0-9]{10}$", "Please try again!");
        int hotel_rating = InputCheck.readInteger("Hotel rating", 1, 6);
        double hotel_price=InputCheck.readPrice("Hotel Price");
        Hotel hotel = new Hotel(hotel_id, hotel_name, hotel_room_available, hotel_address, hotel_phone, hotel_rating,hotel_price);
        return hotel;
    }

    @Override
    public void addHotel() {

        boolean agreed = true;
        do {
            String hotel_id = InputCheck.idCheck("Hotel id", "^[H][0-9]{2}$");
            Hotel hotel = hotelController.getHotelById(hotel_id);
            if (hotel != null) {
                System.err.println("Hotel Exist !Please try another id ");

                agreed = true;

            } else {

                Hotel hotels = inputHotel("add", hotel_id);

                boolean result = hotelController.addHotel(hotels);
                if (result) {
                    System.out.println("Success!");
                } else {
                    System.err.println("Fail!");
                }

                agreed = InputCheck.readBoolean("Continuously create a new hoetel or go back to menu ?\n Y:Continue || N:Go back");
            }

        } while (agreed);
    }

    @Override
    public void updateHotel() {
        String hotel_id = InputCheck.idCheck("Hotel id", "^[H][0-9]{2}$");
        Hotel hotel = hotelController.getHotelById(hotel_id);
        if (hotel != null) {

            hotel = inputHotel("update", "null");
            hotel.setHotel_id(hotel_id);
            boolean result = hotelController.updateHotel(hotel);
            if (result) {
                System.out.println("Success!");
            } else {
                System.err.println("Fail!");
            }
        } else {
            System.err.println("Hotel does not exist  !");
            System.out.println("Do you want to create new hotel or get back to the menu ?\nChoose : 1-Create new hotel || 2-Return to menu");
            int choice = InputCheck.readInteger("Your choice", 1, 2);

            switch (choice) {
                case 1:
                    Hotel hotels = inputHotel("add", hotel_id);
                    hotelController.addHotel(hotels);
                    break;
                case 2:
                    break;
            }
        }

    }

    @Override
    public void deleteHotel() {

        String hotel_id = InputCheck.idCheck("Hotel id", "^[H][0-9]{2}$");
        Hotel hotelidcheck = hotelController.getHotelById(hotel_id);
        if (hotelidcheck != null) {
            System.out.println("Do you ready want to delete this hotel ? \n 1-Continue || 2-Return to menu ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    boolean result = hotelController.deleteHotel(hotel_id);
                    if (result) {
                        System.out.println("Success!");
                    } else {
                        System.err.println("Fail!");
                    }
                    break;
                case 2:

                    break;
                default:
                    throw new AssertionError();
            }
        } else {
            System.out.println("No hotel found !");
        }

    }

    @Override
    public void searchHotelById() {
        boolean valid = false;
        do {
            String hotel_id = InputCheck.idCheck("Hotel id", "^[H][0-9]{2}$");
            Hotel hotel = hotelController.getHotelById(hotel_id);
            if (hotel != null) {
                System.out.println("Hotel Exist!");
            } else {
                System.err.println("Hotel not found !");

            }
            valid = InputCheck.readBoolean("Continuously searching hotel or go back to menu ?\n Y:Continue || N:Go back");
        } while (valid);
    }

    @Override
    public void searchHotelByName() {

        String hotel_name = InputCheck.stringCheck("Hotel name", "^[a-zA-Z\\s\\,]+$");
        ArrayList<Hotel> hotels = hotelController.getHotelByName(hotel_name);
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.printf("| %10s | %15s | %20s | %70s | %15s | %15s | %15s |\n", "Hotel Id", "Hotel Name",
                "Hotel Room available", "Hotel address", "Hotel phone", "Hotel Rating","Hotel Price");
        for (Hotel hotel : hotels) {
            System.out.printf("| %10s | %15s | %20s | %70s | %15s | %15s | %15s |\n", hotel.getHotel_id(),
                    hotel.getHotel_name(), hotel.getHotel_room_available(), hotel.getHotel_address(),
                    hotel.getHotel_phone(), hotel.getHotel_rating() + " star",hotel.getHotel_Price());
        }
    }

    @Override
    public void displayHotels() {
        ArrayList<Hotel> hotels = hotelController.getAllHotels();
        if (hotels.size() == 0 || hotels == null) {
            System.out.println("List is empty !");
        } else {
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.printf("| %10s | %15s | %20s | %70s | %15s | %15s | %15s | \n", "Hotel Id", "Hotel Name",
                    "Hotel Room available", "Hotel address", "Hotel phone", "Hotel Rating","Hotel Price");
            for (Hotel hotel : hotels) {
                System.out.printf("| %10s | %15s | %20s | %70s | %15s | %15s | %15s \n", hotel.getHotel_id(),
                        hotel.getHotel_name(), hotel.getHotel_room_available(), hotel.getHotel_address(),
                        hotel.getHotel_phone(), hotel.getHotel_rating() + " star",hotel.getHotel_Price());
            }
        }
    }

    @Override
    public void searchHotel() {
        String categorySearch = InputCheck.stringCheck("Search by (id/name)", "^(id)|(name)$");
        switch (categorySearch) {
            case "id":
                String hotel_id = InputCheck.idCheck("Hotel id", "^[H][0-9]{2}$");
                System.out.println(hotelController.getHotelById(hotel_id));
                break;
            case "name":
                searchHotelByName();

                break;
            default:
                System.out.println(categorySearch);
                System.err.println("No Hotel Found !");
                break;
        }
    }
}
