package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.text.Normalizer;


public class Contact implements ICallActions {
    private String name;
    private String surName;
    private String phoneNumber;
    private String code;

    public Contact(String name, String surName, String phoneNumber) {
        this.name = name;
        this.surName = surName;
        this.phoneNumber = phoneNumber;
        this.code = generateCode(name, surName);
    }

    public String getSurname() {
        return this.surName;
    }

    public String getSurnames() {
        return this.getSurname();
    }

    public String getPhone() {
        return this.phoneNumber;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void callMyNumber() {
        System.out.println("Llamándote a ti mismo: " + this.getName() + " " + this.getSurnames() + this.phoneNumber + "\n");
    }

    @Override
    public void callOtherNumber(String number) {
        System.out.println("Llamando al contacto: " + getName() + " " + getSurnames() + " al número: " + number + "\n");
    }

    @Override
    public void showContactDetails() {
        System.out.println(
                "Contacto:\n" +
                        "Nombre: " + getName() + "\n" +
                        "Apellido/s: " + getSurname() + "\n" +
                        "Número: " + getPhone() + "\n" +
                        "Código: " + getCode() + "\n"
        );
    }

    private String generateCode(String name, String surname) {
        String normalizedName = Normalizer.normalize(name, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase();
        String normalizedSurname = Normalizer.normalize(surname, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase();

        StringBuilder code = new StringBuilder();

        // Primer carácter del nombre
        code.append(normalizedName.charAt(0));

        // Si solo tiene 1 apoellido
        if (!normalizedSurname.contains(" ")) {
            return code.append(normalizedSurname).toString();
        } else {
            // Si tiene más
            String[] parts = normalizedSurname.split(" ");
            // Primera letra del primer apellido
            code.append(parts[0].charAt(0));

            // Resto del apellido (sin la primera inicial)
            for (int i = 1; i < parts.length; i++) {
                code.append(parts[i]);
            }

            return  code.toString();
        }
    }

}