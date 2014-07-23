package com.epam.XMLweb.command;

import com.epam.XMLweb.command.logic.LoginLogic;
import com.epam.XMLweb.manager.MassageManager;
import com.epam.XMLweb.manager.PageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand implements ICommand {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {

        String page = null;
        HttpSession session = request.getSession(true);

        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);

        if (LoginLogic.checkLogin(login, password)){

            session.setAttribute("user", login);
            page = PageManager.getPageAddress("path.page.welcome");

        } else {
            request.setAttribute("errorLoginMessage", MassageManager.getProperty("message.loginerror"));
            page = PageManager.getPageAddress("path.page.login");
        }

        return page;
    }
}
