package com.epam.XMLweb.command;

import com.epam.XMLweb.entity.abstractdevice.Device;
import com.epam.XMLweb.entity.house.SmartHouse;
import com.epam.XMLweb.exeptions.TechnicalException;
import com.epam.XMLweb.manager.MassageManager;
import com.epam.XMLweb.manager.PageManager;
import com.epam.XMLweb.parser.parsermanager.ParserManager;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;

public class ParseCommand implements ICommand{

    public static final String XML_PATH = "electricalappliance.xml";

    private String parserType;
    private SmartHouse smartHouse;
    public ParseCommand(String parserType) {
        this.parserType = parserType;
    }



    @Override
    public String execute(HttpServletRequest request) {

        String page = null;
        ArrayList<Device> devices = null;

        try {
            ParserManager parser = ParserManager.buildParser(parserType);
            devices = parser.putDevicesForWeb(parser.parse(XML_PATH));
        } catch (TechnicalException e) {
            e.printStackTrace();
        }


        if(!devices.isEmpty()) {
            page = PageManager.getPageAddress("path.page.result");
            request.setAttribute("lst", devices);

        } else {
            request.setAttribute("nullpage", MassageManager.getProperty("message.nullpage"));
            page = PageManager.getPageAddress("path.page.login");

        }
        devices = null;

        return page;
    }

}


