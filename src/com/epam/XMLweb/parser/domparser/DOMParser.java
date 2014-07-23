package com.epam.XMLweb.parser.domparser;

import com.epam.XMLweb.builder.Director;
import com.epam.XMLweb.entity.abstractdevice.Device;
import com.epam.XMLweb.entity.house.SmartHouse;
import com.epam.XMLweb.parser.TagsElements;
import com.epam.XMLweb.parser.parsermanager.ParserManager;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMParser  extends ParserManager {

    public static final Logger LOG = Logger.getLogger(DOMParser.class);

    @Override
    public SmartHouse parse(String XMLpath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOG.error("Configuration Parser Exeption", e);
        }
        Document document = null;
        try {
            document = documentBuilder.parse(new File(XMLpath));
        } catch (SAXException e) {
            LOG.error("SAXException", e);

        } catch (IOException e) {
            LOG.error("XML file not found", e);
        }

        SmartHouse smartHouse = new SmartHouse();
        NodeList nodeList = document.getChildNodes().item(0).getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            switch (node.getNodeName()){
                case TagsElements.HAIRDRYER:
                    smartHouse.addDevice(parseHairDryer((Element) node));
                    break;
                case TagsElements.FRIDGE:
                    smartHouse.addDevice(parseFridge((Element) node));
                    break;
                case TagsElements.OVEN:
                    smartHouse.addDevice(parseOven((Element) node));
                    break;
            }
        }

        return smartHouse;

    }

    public Device parseHairDryer(Element element) {

        String id = element.getAttribute(TagsElements.ID);
        String brand = element.getAttribute(TagsElements.BRAND);
        boolean isOn = Boolean.valueOf(element.getElementsByTagName(TagsElements.IS_ON).item(0).getFirstChild().getNodeValue());
        int power = Integer.valueOf(element.getElementsByTagName(TagsElements.POWER).item(0).getFirstChild().getNodeValue());
        int weight = Integer.valueOf(element.getElementsByTagName(TagsElements.WEIGHT).item(0).getFirstChild().getNodeValue());
        int cost = Integer.valueOf(element.getElementsByTagName(TagsElements.COST).item(0).getFirstChild().getNodeValue());
        int windSpeed = Integer.valueOf(element.getElementsByTagName(TagsElements.WIND_SPEED).item(0).getFirstChild().getNodeValue());
        LOG.info("HAIRDRYER parsed");
        return Director.getHairDryer(id, isOn, weight, cost, power, windSpeed, brand);
    }

    public Device parseFridge(Element element) {

        String id = element.getAttribute(TagsElements.ID);
        String brand = element.getAttribute(TagsElements.BRAND);
        boolean isOn = Boolean.valueOf(element.getElementsByTagName(TagsElements.IS_ON).item(0).getFirstChild().getNodeValue());
        int power = Integer.valueOf(element.getElementsByTagName(TagsElements.POWER).item(0).getFirstChild().getNodeValue());
        int weight = Integer.valueOf(element.getElementsByTagName(TagsElements.WEIGHT).item(0).getFirstChild().getNodeValue());
        int cost = Integer.valueOf(element.getElementsByTagName(TagsElements.COST).item(0).getFirstChild().getNodeValue());
        int temperature = Integer.valueOf(element.getElementsByTagName(TagsElements.FRIDGE_TEMPERATURE).item(0).getFirstChild().getNodeValue());
        LOG.info("FRIDGE parsed");
        return Director.getFridge(id, isOn, weight, cost, power, temperature, brand);
    }

    public Device parseOven(Element element) {

        String id = element.getAttribute(TagsElements.ID);
        String brand = element.getAttribute(TagsElements.BRAND);
        boolean isOn = Boolean.valueOf(element.getElementsByTagName(TagsElements.IS_ON).item(0).getFirstChild().getNodeValue());
        int power = Integer.valueOf(element.getElementsByTagName(TagsElements.POWER).item(0).getFirstChild().getNodeValue());
        int weight = Integer.valueOf(element.getElementsByTagName(TagsElements.WEIGHT).item(0).getFirstChild().getNodeValue());
        int cost = Integer.valueOf(element.getElementsByTagName(TagsElements.COST).item(0).getFirstChild().getNodeValue());
        int temperature = Integer.valueOf(element.getElementsByTagName(TagsElements.OVEN_TEMPERATURE).item(0).getFirstChild().getNodeValue());
        LOG.info("OVEN parsed");
        return Director.getOven(id, isOn, weight, cost, power, temperature, brand);
    }




}
