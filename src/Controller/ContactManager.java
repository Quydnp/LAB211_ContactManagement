/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Repository.ContactList;
import view.Menu;

/**
 *
 * @author HI
 */
public class ContactManager extends Menu {
    private ContactList contactList;
    static String[] options = {
        "Add a Contact",
        "Display all Contact",
        "Delete a Contact",
        "Exit"
    };

    public ContactManager() {
        super("========= CONTACT PROGRAM =========", options);
        contactList = new ContactList();
    }
    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1: {
                contactList.addContact();
                break;
            }
            case 2: {
                contactList.displayAll();
                break;
            }
            case 3: {
                contactList.deleteContact();
                break;
            }
            case 4: {
                System.exit(0);
            }
        }
    }
}
