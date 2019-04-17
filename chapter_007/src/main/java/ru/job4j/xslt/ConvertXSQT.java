package ru.job4j.xslt;

import org.apache.commons.io.FileUtils;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @version 1
 * @since 17.04.2019
 */
public class ConvertXSQT {

    /**
     * Преобразует XML файл через XSLT.
     * @param source исходный файл.
     * @param dest конечный файл.
     * @param scheme схема.
     * @throws IOException
     * @throws TransformerException
     */
    public void convert(File source, File dest, File scheme) throws IOException, TransformerException {
        String sour = FileUtils.readFileToString(source);
        String sch = FileUtils.readFileToString(scheme);
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(
                new StreamSource(
                        new ByteArrayInputStream(sch.getBytes())
                )
        );
        transformer.transform(new StreamSource(
                        new ByteArrayInputStream(sour.getBytes())),
                new StreamResult(new FileOutputStream(dest))
        );
    }
}