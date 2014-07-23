package com.epam.XMLweb.actionfactory;

import com.epam.XMLweb.command.CommandEnum;
import com.epam.XMLweb.command.EmptyCommand;
import com.epam.XMLweb.command.ICommand;
import com.epam.XMLweb.manager.MassageManager;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {

    public ICommand defineCommand(HttpServletRequest request) {

        ICommand current = new EmptyCommand();
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return current;
        }

       try {
         CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
         current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action + MassageManager.getProperty("message.wrongaction"));
        }

        return current;
    }


}
