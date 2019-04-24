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
        store.generate(7);
        List<Entry> list = store.load();
        assertThat(list.size(), is(7));
    }

    @Test
    public void convertListToXML() throws Exception {
        StoreSQL sql = new StoreSQL(new Config());
        sql.generate(9);
        List<Entry> list = sql.load();
        File source = new File("src/main/StoreXML.xml");
        StoreXML storeXML = new StoreXML(source);
        storeXML.save(list);
        assertTrue(source.exists());
    }

    @Test
    public void convertXMLThroughXSLTAndParse() throws Exception {
        StoreSQL storeSQL = new StoreSQL(new Config());
        storeSQL.generate(1000);
        List<Entry> list = storeSQL.load();
        File source = new File("src/main/StoreXML.xml");
        StoreXML storeXML = new StoreXML(source);
        storeXML.save(list);
        File schema = new File("src/main/resources/schema.xml");
        File dest = new File("src/main/destXML.xml");
        new ConvertXSQT().convert(source, dest, schema);
        SAXParser saxParser = new SAXParser();
        saxParser.parse(dest);
    }
}