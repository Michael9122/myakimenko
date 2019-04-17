package ru.job4j.xslt;

import javax.xml.parsers.*;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

import java.util.*;
import java.io.*;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @version 1
 * @since 17.04.2019
 */
public class SAXParser {

    private static List<Entry> entries = new ArrayList<>();

    public void parse(File file) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser parser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            parser.parse(file, handler);
            System.out.println(entries.size());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class XMLHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equals("entry")) {
                String name = attributes.getValue("href");
                entries.add(new Entry(name));

            }
        }
    }
}
