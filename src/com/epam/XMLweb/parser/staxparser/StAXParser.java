package com.epam.XMLweb.parser.staxparser;

import com.epam.XMLweb.entity.abstractdevice.Device;
import com.epam.XMLweb.entity.bathroom.HairDryer;
import com.epam.XMLweb.entity.kitchen.Fridge;
import com.epam.XMLweb.entity.kitchen.Oven;
import com.epam.XMLweb.entity.house.SmartHouse;
import com.epam.XMLweb.exeptions.TechnicalException;
import com.epam.XMLweb.parser.TagsElements;
import com.epam.XMLweb.parser.parsermanager.ParserManager;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;

public class StAXParser extends ParserManager {

    private static final Logger LOG = Logger.getLogger(StAXParser.class);


    private XMLStreamReader reader;
    private SmartHouse smartHouse;
    private Device currentDevice;
    private String tagContent;


    public StAXParser() {
        smartHouse = new SmartHouse();
    }

    @Override
    public SmartHouse parse(String XMLpath) {

        InputStream in = null;
        try {
            in = new FileInputStream(new File(XMLpath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            reader = inputFactory.createXMLStreamReader(in);


        } catch (XMLStreamException e) {
            LOG.error("XML StreamReader error");
        }

        try {
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {

                    case XMLStreamConstants.START_ELEMENT:
                        switch (reader.getLocalName()) {
                            case TagsElements.HAIRDRYER:
                                currentDevice = new HairDryer();
                                currentDevice.setId(reader.getAttributeValue(0));
                                currentDevice.setBrand(reader.getAttributeValue(1));
                                break;
                            case TagsElements.FRIDGE:
                                currentDevice = new Fridge();
                                currentDevice.setId(reader.getAttributeValue(0));
                                currentDevice.setBrand(reader.getAttributeValue(1));
                                break;
                            case TagsElements.OVEN:
                                currentDevice = new Oven();
                                currentDevice.setId(reader.getAttributeValue(0));
                                currentDevice.setBrand(reader.getAttributeValue(1));
                                break;
                        }

                        break;
                    case XMLStreamConstants.CHARACTERS:
                        tagContent = reader.getText().trim();
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        switch (reader.getLocalName()) {
                            case TagsElements.HAIRDRYER:
                                smartHouse.addDevice(currentDevice);
                                break;
                            case TagsElements.FRIDGE:
                                smartHouse.addDevice(currentDevice);
                                break;
                            case TagsElements.OVEN:
                                smartHouse.addDevice(currentDevice);
                                break;
                            case TagsElements.IS_ON:
                                currentDevice.setOn(Boolean.valueOf(tagContent));
                                break;
                            case TagsElements.POWER:
                                currentDevice.setPower(Integer.valueOf(tagContent));
                                break;
                            case TagsElements.WEIGHT:
                                currentDevice.setWeight(Integer.valueOf(tagContent));
                                break;
                            case TagsElements.COST:
                                currentDevice.setCost(Integer.valueOf(tagContent));
                                break;
                            case  TagsElements.WIND_SPEED:
                                ((HairDryer)currentDevice).setWindSpeed(Integer.valueOf(tagContent));
                                break;
                            case  TagsElements.FRIDGE_TEMPERATURE:
                                ((Fridge)currentDevice).setFridgeTemperature(Integer.valueOf(tagContent));
                                break;
                            case  TagsElements.OVEN_TEMPERATURE:
                                ((Oven)currentDevice).setOvenTemperature(Integer.valueOf(tagContent));
                                break;
                        }
                        break;
                }

            }
        } catch (XMLStreamException e) {
            LOG.error("Stream Error!");
        }

    return smartHouse;
    }

}
