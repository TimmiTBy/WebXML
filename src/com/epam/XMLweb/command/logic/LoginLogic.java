package com.epam.XMLweb.command.logic;

public class LoginLogic {

    private final static String USER_LOGIN = "admin";
    private final static String USER_PASSWORD = "pass";
    
    public static boolean checkLogin(String enterLogin, String enterPass){

        return USER_LOGIN.equals(enterLogin) && USER_PASSWORD.equals(enterPass);
    }
}
