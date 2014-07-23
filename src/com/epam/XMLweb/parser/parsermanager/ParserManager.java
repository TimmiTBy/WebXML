package com.epam.XMLweb.parser.parsermanager;

import com.epam.XMLweb.entity.abstractdevice.Device;
import com.epam.XMLweb.entity.house.SmartHouse;
import com.epam.XMLweb.exeptions.TechnicalException;
import com.epam.XMLweb.parser.domparser.DOMParser;
import com.epam.XMLweb.parser.saxparser.SAXParser;
import com.epam.XMLweb.parser.staxparser.StAXParser;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class ParserManager {

    public static ParserManager buildParser(String parserType) throws TechnicalException {

        switch (parserType.toUpperCase()) {

            case "DOM":
                return new DOMParser();
            case "SAX":
                return new SAXParser();
           // case "STAX":
               // return new StAXParser();
            default:
                throw new TechnicalException();
        }
    }


    public ArrayList<Device> putDevicesForWeb(SmartHouse smartHouse) {

        ArrayList<Device> devicesInHouse = new ArrayList<>();

        Iterator<Device> it = smartHouse.iterator();
        while (it.hasNext()) {
            devicesInHouse.add(it.next());
        }

        return devicesInHouse;
    }

    public abstract SmartHouse parse(String XMLPath);


}
