/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InputCheckMethod;

import java.util.Scanner;

/**
 *
 * @author Ngoc Lan
 */
public class InputCheck {

    public static final Scanner sc = new Scanner(System.in);

    public static boolean parseBoolean(String input) {
        boolean valid = false;
        boolean messagePrinted = false;
        do {
            try {
                if (input.trim().equals("")) {
                    if (!messagePrinted) {
                        System.out.println("Please choose Y or N ");
                        messagePrinted = true;
                        input = sc.nextLine();
                    }
                    valid = true;
                    break;
                }
            } catch (Exception e) {
                valid = false;
            }
        } while (valid);
        input = input.trim().toUpperCase();
        char c = input.charAt(0);
        return c == 'T' || c == '1' || c == 'Y';

    }

    public static boolean readBoolean(String prompt) {
        System.out.println(prompt + ": ");
        return parseBoolean(sc.nextLine());
    }

    public static String stringCheck(String prompt, String pattern) {
        String input;
        boolean valid = false;
        do {
            System.out.println(prompt + ": ");
            input = sc.nextLine().trim();
            if(input.matches(pattern)){
                valid=true;
            }else {
                 System.err.println("Please try again !");
            }
        } while (!valid);
        return input;
    }

    public static String idCheck(String prompt, String pattern) {
        String input;
        boolean valid = false;
        do {
            System.out.println(prompt + ": ");
            input = sc.nextLine().toUpperCase();
            
            if (input.matches(pattern)) {
                valid = true;
            } else {
                System.err.println("Please try again !|The correct form is H-(0-9)-(0-9)");
                valid = false;
            }

        } while (!valid);
        return input;
    }

    public static String phoneCheck(String prompt, String pattern, String msgError) {
        String input;
        boolean valid = false;
        do {
            System.out.println(prompt + ": ");
            input = sc.nextLine();
            valid = input.matches(pattern);
            if (!valid) {
                System.err.println(msgError);
            }
        } while (!valid);
        return input;
    }

    public static int readInteger(String prompt, int min, int max) {
        int result = 0;
        boolean valid = false;
        do {
            System.out.print(prompt + ": ");
            try {
                result = Integer.parseInt(sc.nextLine());
                valid = result >= min && result <= max;
            } catch (Exception e) {
                valid = false;
            }
            if (!valid) {
                System.err.println("Please try again !");
            }
        } while (!valid);
        return result;
    }
    
    public static double readPrice(String prompt) {
    double price = 0.0;
    boolean valid = false;
    do {
        System.out.print(prompt + ": ");
        try {
            price = Double.parseDouble(sc.nextLine());
            valid = price >= 0; // Giả sử giá tiền không âm
        } catch (NumberFormatException e) {
            valid = false;
        }
        if (!valid) {
            System.err.println("Please enter a valid price!");
        }
    } while (!valid);
    return price;
}
    
 
    
    

}
