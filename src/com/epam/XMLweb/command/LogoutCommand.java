package com.epam.XMLweb.command;

import com.epam.XMLweb.manager.PageManager;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request) {

        String page = PageManager.getPageAddress("path.page.login");

        request.getSession().invalidate();
        return page;
    }
}
