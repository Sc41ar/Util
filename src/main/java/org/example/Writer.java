package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Writer {

    //А может есть смысл сохранять все в строках?
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

    public void setResultsPath(String resultsPath) {//проверка корректности заданного пути вывода
        //Если нельзя по данному пути создать файл - путь неккоректный
        try {
            String checkFilePath = resultsPath + "\\path_check.txt";
            FileWriter fw = new FileWriter(checkFilePath);
            fw.close();
            File file = new File(checkFilePath);
            if (file.exists())
                file.delete();
        } catch (IOException e) {
            System.out.println("Путь параметра -о не проходит проверку: " + e.getMessage());
        }
        this.resultsPath = resultsPath;

    }
}