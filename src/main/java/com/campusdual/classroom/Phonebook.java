package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    public Map<String, Contact> phoneBook;

    public Phonebook() {
        this.phoneBook = new HashMap<>();
    }

    public Map<String, Contact> getPhoneBook() {
        return this.phoneBook;
    }

    //Getter //Funcionalidad del Test
    public Map<String, Contact> getData() {
        return this.phoneBook;
    }

    //Añadir contacto
    public void addContact(String name, String surname, String phoneNumber) {
        Contact newContact = new Contact(name, surname, phoneNumber);

        if (phoneBook.containsKey(newContact.getCode())) {
            System.out.println("Este contacto ya existe en la agenda.\n");
        } else {
            phoneBook.put(newContact.getCode(), newContact);
            System.out.println("Contacto " + newContact.getName() + " añadido.\n\n");
        }
    }

    public void addContact(Contact contact) {
        phoneBook.put(contact.getCode(), contact);
        System.out.println("Añadido el contacto: \n");
        contact.showContactDetails();
    }


    //Eliminar contacto
    public void deleteContact(String code) {
        Contact contactToDelete = phoneBook.get(code);
        if (contactToDelete != null) {
            phoneBook.remove(code);
            System.out.println("Contacto " + contactToDelete.getName() + " borrado.\n\n");
        }
    }

    //Mostrar contacto
    public void showPhonebook() {
        if (phoneBook.isEmpty()) {
            System.out.println("No existen contactos todavía.\n");
        } else {
            for (Contact contacto : phoneBook.values()) {
                contacto.showContactDetails();
                System.out.println("\n");
            }
        }
    }

    //Seleccionar un contacto
    public void selectContact(String code) {
        Contact contact = phoneBook.get(code);
        if (contact != null) {
            contactMenu(contact);
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    //Menu de contacto
    public void contactMenu(Contact contact) {
        int choice;
        do {
            System.out.println("Menu de contacto:");
            System.out.println("1. Llama a tu propio número");
            System.out.println("2. Llama a otro número");
            System.out.println("3. Mostrar detalles de contacto");
            System.out.println("4. Volver a menú anterior");
            choice = Utils.integer("Selecciona una opción: ");

            switch (choice) {
                case 1:
                    contact.callMyNumber();
                    break;
                case 2:
                    contact.callOtherNumber(Utils.string("Introduce el número al que quieres llamar: "));
                    break;
                case 3:
                    contact.showContactDetails();
                    break;
                case 4:
                    System.out.println("Volviendo al menú anterior...");
                    break;
                default:
                    System.out.println("Opción no válida, introduce otra opción");
            }
        } while (choice != 4);
    }

    //Menu main
    public void mainMenu() {
        int choice;
        do {
            System.out.println("Menú principal");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Eliminar contacto");
            System.out.println("3. Mostrar contactos");
            System.out.println("4. Seleccionar y acceder a menú de contacto");
            System.out.println("5. Salir");
            choice = Utils.integer("Selecciona una opción: ");

            switch (choice) {
                case 1:
                    addContact(
                            Utils.string("Introduce el nombre:\n"),
                            Utils.string("Introduce el/los apellido/s:\n"),
                            Utils.string("Introduce el número de teléfono:\n")
                    );
                    break;
                case 2:
                    deleteContact(Utils.string("Introduce el código del contacto a eliminar:\n"));
                    break;
                case 3:
                    System.out.println("Mostrando contactos de la agenda:\n");
                    showPhonebook();
                    break;
                case 4:
                    selectContact(Utils.string("Introduce el código del contacto que deseas seleccionar:\n"));
                    break;
                case 5:
                    System.out.println("Cerrando agenda...\n");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, introduce otra opción.\n");
            }
        } while (choice != 5);
    }


}

