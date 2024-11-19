/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Hotel;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import dao.HotelDAO;
import java.util.Collections;

/**
 *
 * @author Ngoc Lan
 */
public class HotelController {

    private HotelDAO hotelDAO;
    private File file;

    
    public HotelController() {
        this.hotelDAO = new HotelDAO();
        file = new File("src/filedata/hotels.dat");
    }

   
    public ArrayList<Hotel> getAllHotels() {

        Comparator<Hotel> hotelNameComparator = new Comparator<Hotel>() {
            @Override
            public int compare(Hotel o1, Hotel o2) {
                return -o1.getHotel_name().compareTo(o2.getHotel_name());
            }
        };
        ArrayList<Hotel> hotels = hotelDAO.getAllHotels(file);
        Collections.sort(hotels, hotelNameComparator);
        return hotels;
    }



    

   
    public boolean addHotel(Hotel hotel) {
        return hotelDAO.insertHotel(hotel, file);
    }

    
    public Hotel getHotelById(String hotel_id) {
        return hotelDAO.getHotel(hotel_id, file);
    }

    
    public ArrayList<Hotel> getHotelByName(String hotel_name) {
         Comparator nameComparator=Comparator.comparing(Hotel::getHotel_name);
         ArrayList<Hotel> hotels=hotelDAO.getHotelByName(hotel_name, file);
         Collections.sort(hotels,nameComparator);
         return hotels;
    }

   
    public boolean updateHotel(Hotel hotel) {
        return hotelDAO.updateHotel(hotel, file);
    }

    
    public boolean deleteHotel(String hotel_id) {
        return hotelDAO.deleteHotel(hotel_id, file);
    }

    
    public int getSize() {
        return hotelDAO.getAllHotels(file).size();
    }
}
