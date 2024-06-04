package org.example;

public class UnknownPropertyHandler {
    public void handleUnknownProperty(FilialInfo filial, String key, String value) {
        if (key.equals("name")) {
            filial.getCity().setName(value);
        } else if (key.equals("name_type")) {
            filial.getCity().setNameType(value);
        }
    }
}