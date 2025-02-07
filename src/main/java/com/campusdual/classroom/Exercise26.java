package com.campusdual.classroom;


public class Exercise26 {
    public static void main(String[] args) {
        Contact juan = new Contact("juan", "gomez", "555666777");

        Phonebook phonebook = new Phonebook();
        phonebook.addContact(juan);
        phonebook.mainMenu();
    }
}
