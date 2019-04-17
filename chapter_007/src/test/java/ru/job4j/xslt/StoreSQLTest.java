package ru.job4j.xslt;

import org.junit.Test;

import java.io.File;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StoreSQLTest {

    @Test
    public void generateEntriesInTable() throws Exception {
        Config config = new Config();
        StoreSQL store = new StoreSQL(config);
        store.generate(5);
        List<Entry> list = store.load();
        assertThat(list.size(), is(5));
    }

    @Test
    public void convertListToXML() throws Exception {
        StoreSQL sql = new StoreSQL(new Config());
        sql.generate(6);
        List<Entry> list = sql.load();
        File source = new File("E:/projects/myakimenko/chapter_007/src/main/StoreXML.xml");
        StoreXML storeXML = new StoreXML(source);
        storeXML.save(list);
        assertTrue(source.exists());
    }

    @Test
    public void convertXMLThroughXSLTAndParse() throws Exception {
        StoreSQL storeSQL = new StoreSQL(new Config());
        storeSQL.generate(1000000);
        List<Entry> list = storeSQL.load();
        File source = new File("E:/projects/myakimenko/chapter_007/src/main/StoreXML.xml");
        StoreXML storeXML = new StoreXML(source);
        storeXML.save(list);
        File schema = new File("E:/projects/myakimenko/chapter_007/src/main/schema.xml");
        PrintWriter out = new PrintWriter(schema);
        out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">\n"
                + "<xsl:template match=\"/\">\n"
                + "<entries>"
                + "   <xsl:for-each select=\"Entries/entry\">\n"
                + "       <entry>"
                + "           <xsl:attribute name=\"href\">"
                + "               <xsl:value-of select=\"field\"/>"
                + "           </xsl:attribute>"
                + "       </entry>\n"
                + "   </xsl:for-each>\n"
                + " </entries>\n"
                + "</xsl:template>\n"
                + "</xsl:stylesheet>\n");
        out.close();
        File dest = new File("E:/projects/myakimenko/chapter_007/src/main/destXML.xml");
        new ConvertXSQT().convert(source, dest, schema);
        SAXParser saxParser = new SAXParser();
        saxParser.parse(dest);
    }
}