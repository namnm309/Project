/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Ngoc Lan
 */
public class Hotel implements Serializable {

    private String hotel_id;
    private String hotel_name;
    private int hotel_room_available;
    private String hotel_address;
    private String hotel_phone;
    private int hotel_rating;
    private double hotel_price;

    public Hotel(String hotel_id, String hotel_name, int hotel_room_available, String hotel_address, String hotel_phone,
            int hotel_rating,double hotel_price) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.hotel_room_available = hotel_room_available;
        this.hotel_address = hotel_address;
        this.hotel_phone = hotel_phone;
        this.hotel_rating = hotel_rating;
        this.hotel_price=hotel_price;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public int getHotel_room_available() {
        return hotel_room_available;
    }

    public void setHotel_room_available(int hotel_room_available) {
        this.hotel_room_available = hotel_room_available;
    }

    public String getHotel_address() {
        return hotel_address;
    }

    public void setHotel_address(String hotel_address) {
        this.hotel_address = hotel_address;
    }

    public String getHotel_phone() {
        return hotel_phone;
    }

    public void setHotel_phone(String hotel_phone) {
        this.hotel_phone = hotel_phone;
    }

    public int getHotel_rating() {
        return hotel_rating;
    }

    public void setHotel_rating(int hotel_rating) {
        this.hotel_rating = hotel_rating;
    }
    
    public double getHotel_Price()
    {
        return hotel_price;
    }
    
    public void setHotel_Price(double hotel_price){
        this.hotel_price=hotel_price;
    }
  
    public static Hotel fromString(String line) {
        String[] fields = line.split("-");

        return new Hotel(fields[0], fields[1], Integer.parseInt(fields[2]), fields[3], fields[4],
                Integer.parseInt(fields[5]),Double.parseDouble(fields[6]));
    }

    @Override
    public String toString() {
        return hotel_id + "-" + hotel_name + "-" + hotel_room_available + "-" + hotel_address + "-" + hotel_phone + "-"
                + hotel_rating+"-"+hotel_price;
    }

    
}
