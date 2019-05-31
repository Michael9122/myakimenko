package ru.job4j.inputoutput;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Search {

    public List<File> files(String parent, List<String> exts) {
        List<File> result = new ArrayList<>();
        File file = new File(parent);
        File[] files = file.listFiles();
        if (files == null) {
            return result;
        }
        for (File f : files) {
            if (f.isDirectory()) {
                result.addAll(files(f.getPath(), exts));
            }
            for (String ext : exts) {
                if (f.getName().endsWith(ext)) {
                    result.add(f);
                }
            }
        }
        return result;
    }
}