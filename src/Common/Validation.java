/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import Model.Contact;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HI
 */
public class Validation {
    private final static Scanner sc = new Scanner(System.in);
    private static final String PHONE_VALID = "(0[3|5|7|8|9])+([0-9]{8})";

    private static final String EMAIL_VALID
            = "[A-Za-z]\\w+@\\w+(\\.\\w+){1,3}$";

    public int inputInt(String mess, int min) {
        System.out.print(mess);
        while (true) {
            String input = sc.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < min) {
                    System.out.print("Please input over " + min + " : ");
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.print("Please input an integer number: ");
            }
        }
    }

    public double inputDouble(String mess, double min, double max) {
        System.out.print(mess);
        while (true) {
            String input = sc.nextLine();
            try {
                double number = Double.parseDouble(input);
                if (number < min || number > max) {
                    System.out.print("Please input between " + min + ", " + max + ": ");
                    continue;
                }
                return number;
            } catch (Exception e) {
                System.out.print("Please input an double number: ");
            }
        }
    }

    public String inputString(String mess, String regex) {
        System.out.print(mess);
        while (true) {
            String input = sc.nextLine();
            if (!input.matches(regex)) {
                System.out.println("Please input matched with regex:" + regex);
                continue;
            }
            if (input.equals("")) {
                System.out.print("Please input a non-empty string: ");
                continue;
            }
            return input;
        }
    }
    
    public boolean checkInputYN() {
        while (true) {
            String result = sc.nextLine();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    public String inputPhoneNumber(String mess) {
        System.out.print(mess);
        String regex = PHONE_VALID;
        while (true) {
            String input = sc.nextLine();
            if (!input.matches(regex)) {
                System.out.println("Please enter a valid phone number:" + regex);
                continue;
            }
            if (input.equals("")) {
                System.out.print("Please input a non-empty string: ");
                continue;
            }
            return input;
        }
    }
    
    public int checkIdExist(ArrayList<Contact> contactList, int id) {
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getID() == id) {
                return i;
            }
        }
        return -1;
    }
}
