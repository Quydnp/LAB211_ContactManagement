/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Common.Validation;
import Model.Contact;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author HI
 */
public class ContactList implements IManageContact {

    private ArrayList<Contact> contactList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    Validation validation = new Validation();

    @Override
    public void addContact() {
        System.out.println("---------- Add Contact -----------");
        try {
            String name = validation.inputString("Enter Name: ", "[A-Za-z\\s]+");
            String group = validation.inputString("Enter Group: ", "[A-Za-z\\s]+");
            String address = validation.inputString("Enter Address: ", "^[a-zA-Z0-9\\s/\\-]*$");
            String phone = validation.inputPhoneNumber("Enter Phone: ");
            String firstName = name.substring(0, name.indexOf(" "));
            String lastName = name.substring(name.indexOf(" "));
            addContact(contactList, new Contact(name, group, address, phone, lastName, firstName));
            System.out.println("Successful!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            // Xử lý lỗi 
        }
    }
    
    private boolean addContact(List<Contact> list, Contact contact) {
        list.add(contact);
        return true;
    }

    @Override
    public void displayAll() {
        displayAll(contactList);
    }

    private void displayAll(List<Contact> list) {
        System.out.println("--------------------Contact List------------------");
        if (list.isEmpty()) {
            System.out.println("Not found any contact!");
        } else {     
            System.out.printf("%-10s %-30s %-20s %-20s %-12s %-12s %-20s%n", "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone");
            list.stream().forEach(contact -> contact.display());
            System.out.println("Total: " + list.size());
        }
    }
    @Override
    public void deleteContact() {
        int id = validation.inputInt("Enter ID: ", 0);
        int index = validation.checkIdExist(contactList, id);
        if (index == -1) {
            System.out.println("The list doesn't contain element with ID: " + id);
        } else {
            deleteContact(contactList, contactList.get(index));
        }
        
    }
    
    private boolean deleteContact(List<Contact> list, Contact contact) {
        list.remove(contact);
        return true;
    }

    
}
