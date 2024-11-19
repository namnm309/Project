/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import OutPutMethod.outputMethod;
import InputCheckMethod.InputCheck;
import OutPutMethod.outputMain;
import java.util.Scanner;

/**
 *
 * @author Ngoc Lan
 */
public class Menu {

    Scanner sc = new Scanner(System.in);
    private outputMain hotelService;

    public Menu() {

        this.hotelService = new outputMethod();
    }

    public void run() {
        ArrayList<String> mainMenu = new ArrayList<>();
        mainMenu.add("Add new hotel");
        mainMenu.add("Check to exist by id");
        mainMenu.add("Update hotel");
        mainMenu.add("Delete hotel");
        mainMenu.add("Search hotels");
        mainMenu.add("Displaying a hotel list ");
        mainMenu.add("Exit");
        while (true) {
            System.out.println("=========== Menu ============");
            int choice = getIntChoice(mainMenu);
            switch (choice) {
                case 1:
                    hotelService.addHotel();
                    break;
                case 2:
                    hotelService.searchHotelById();
                    break;
                case 3:
                    hotelService.updateHotel();
                    break;
                case 4:
                    hotelService.deleteHotel();
                    break;
                case 5:
                    hotelService.searchHotel();
                    break;
                case 6:
                    hotelService.displayHotels();
                    ;
                    break;
                case 7:
                    System.out.println("Exit!");
                    System.exit(0);
                    break;
            }
        }
    }

    public int getIntChoice(ArrayList<String> list) {
        for (int i=0;i<list.size();i++){
            System.out.println((i+1)+" - "+list.get(i));
        }
        System.out.println("=============================");
        System.out.println("Please choose from 1 to 7 :");
        int choose=InputCheck.readInteger("Your choose ", 1, 7);
        
        return choose;
    }

    public static void main(String[] args) {
        Menu app = new Menu();
        app.run();
    }
}
