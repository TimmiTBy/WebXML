package com.epam.XMLweb.manager;

import java.util.ResourceBundle;

public class PageManager {

    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("/resources.page");

    private PageManager() {}

    public static String getPageAddress(String value) {
        return resourceBundle.getString(value);
    }

}
