package ru.job4j.xslt;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @version 1
 * @since 17.04.2019
 */
@XmlRootElement
public class Entry {

    private int field;
    private String parse;

    public Entry() {
    }

    public Entry(String parse) {
        this.parse = parse;
    }

    public Entry(int field) {
        this.field = field;
    }

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }
}
