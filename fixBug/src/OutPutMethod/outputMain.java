/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OutPutMethod;

import model.Hotel;
import java.util.ArrayList;

/**
 *
 * @author Ngoc Lan
 */
public interface outputMain {

    public Hotel inputHotel(String action,String x);

    public void addHotel();

    public void searchHotel();

    public void updateHotel();

    public void deleteHotel();

    public void searchHotelById();

    public void searchHotelByName();

    public void displayHotels();

}
