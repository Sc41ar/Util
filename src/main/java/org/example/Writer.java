package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Writer {
    public List<Integer> integerList;
    public List<Double> doubleList;
    public List<String> stringList;
    private String prefix;
    private String resultsPath;
    private boolean fileAddFlag;

    public Writer() {
        integerList = new LinkedList<>();
        doubleList = new LinkedList<>();
        stringList = new LinkedList<>();
        prefix = "";
        resultsPath = "";
        fileAddFlag = false;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public boolean isFileAddFlag() {
        return fileAddFlag;
    }

    public void setFileAddFlag(boolean fileAddFlag) {
        this.fileAddFlag = fileAddFlag;
    }

    public String getResultsPath() {
        return resultsPath;
    }

    public void setResultsPath(String resultsPath) {
        try {
            FileWriter fw = new FileWriter(resultsPath + "\\path_check.txt");
        } catch (IOException e) {
            System.out.println("Путь параметра -о не проходит проверку: " + e.getMessage());
        }
        this.resultsPath = resultsPath;

    }
}