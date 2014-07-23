package com.epam.XMLweb.manager;

import java.util.ResourceBundle;

public class MassageManager {

    private  final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.messages");

    private MassageManager () {}

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
