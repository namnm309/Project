/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Hotel;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ngoc Lan
 */
public class HotelDAO {

    public boolean insertHotel(Hotel hotel, File file) {
        try {
            FileWriter writer = new FileWriter(file, true);

            writer.write(hotel.toString() + "\n");
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Hotel getHotel(String hotel_id, File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("")) {
                    break;
                }

                Hotel hotel = Hotel.fromString(line);

                if (hotel.getHotel_id().equals(hotel_id)) {
                    reader.close();
                    return hotel;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateHotel(Hotel newHotel, File file) {
        try {
            File tempFile = new File("src/temp.dat");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            FileWriter writer = new FileWriter(tempFile);

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("")) {
                    break;
                }
                Hotel hotel = Hotel.fromString(line);

                if (hotel.getHotel_id().equals(newHotel.getHotel_id())) {
                    writer.write(newHotel.toString() + "\n");
                } else {
                    writer.write(line + "\n");
                }
            }
            reader.close();
            writer.close();

            file.delete();
            tempFile.renameTo(file);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteHotel(String hotel_id, File file) {
        try {
            File tempFile = new File("src/temp.dat");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            FileWriter writer = new FileWriter(tempFile);
            String line;
            boolean deleted = false;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("")) {
                    break;
                }
                Hotel hotel = Hotel.fromString(line);

                if (hotel.getHotel_id().equals(hotel_id)) {
                    deleted = true;
                    continue;
                }
                writer.write(line + "\n");
            }
            reader.close();
            writer.close();

            file.delete();
            tempFile.renameTo(file);
            return deleted;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Hotel> getHotelByName(String hotel_name, File file) {
        ArrayList<Hotel> hotels = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("")) {
                    break;
                }
                Hotel hotel = Hotel.fromString(line);

                if (hotel.getHotel_name().contains(hotel_name)) {
                    hotels.add(hotel);
                }

            }
            reader.close();
        } catch (IOException e) {
            System.out.println("No hotel found");
            e.printStackTrace();
        }
        return hotels;
    }

    public ArrayList<Hotel> getAllHotels(File file) {
        ArrayList<Hotel> hotels = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("")) {
                    break;
                }

                Hotel hotel = Hotel.fromString(line);
                hotels.add(hotel);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hotels;
    }
}
