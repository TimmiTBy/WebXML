package com.epam.XMLweb.parser.saxparser;

import com.epam.XMLweb.entity.house.SmartHouse;
import com.epam.XMLweb.parser.parsermanager.ParserManager;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAXParser  extends ParserManager {

    private static final Logger LOG = Logger.getLogger(SAXParser.class);

    @Override
    public SmartHouse parse(String XMLpath){

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        javax.xml.parsers.SAXParser saxParser = null;
        try {
            saxParser = saxParserFactory.newSAXParser();
        } catch (ParserConfigurationException e) {
            LOG.error("Error configuration Parser", e);
        } catch (SAXException e) {
            LOG.error("SAXException exception", e);
        }

        SAXHandler saxHandler = new SAXHandler();
        try {
            saxParser.parse(new File(XMLpath), saxHandler);
        } catch (SAXException e) {
            LOG.error("SAXException exception", e);
        } catch (IOException e) {
            LOG.error("File not found exception", e);
        }

        return saxHandler.getSmartHouse();

    }


}
