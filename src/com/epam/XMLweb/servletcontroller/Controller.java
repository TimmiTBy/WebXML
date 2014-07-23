package com.epam.XMLweb.servletcontroller;

import com.epam.XMLweb.command.ICommand;
import com.epam.XMLweb.actionfactory.ActionFactory;
import com.epam.XMLweb.manager.MassageManager;
import com.epam.XMLweb.manager.PageManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {

        String page = null;

        ActionFactory client = new ActionFactory();
        ICommand command = client.defineCommand(request);

        page = command.execute(request);

        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            try {
                dispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            page = PageManager.getPageAddress("path.page.index");
            request.getSession().setAttribute("nullPage", MassageManager.getProperty("message.nullpage"));
            try {
                response.sendRedirect(request.getContextPath() + page);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
