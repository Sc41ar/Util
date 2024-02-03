package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Writer {

    //А может есть смысл сохранять все в строках?
    public List<Long> integerList;
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

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setFileAddFlag(boolean fileAddFlag) {
        this.fileAddFlag = fileAddFlag;
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

    public void writeFilteredData() {
        try {
            if (!integerList.isEmpty()) {
                String path = !resultsPath.isBlank() ? resultsPath + "\\" + prefix + "integers.txt" : prefix + "integers.txt";
                FileWriter fw = new FileWriter(path, fileAddFlag);
                for (var val : integerList) {
                    fw.write(val + "\n");
                }
                fw.close();
            }
            if (!doubleList.isEmpty()) {
                String path = !resultsPath.isBlank() ? resultsPath + "\\" + prefix + "doubles.txt" : prefix + "doubles.txt";
                FileWriter fw = new FileWriter(path, fileAddFlag);
                for (var val : doubleList) {
                    fw.write(val + "\n");
                }
                fw.close();
            }
            if (!stringList.isEmpty()) {
                String path = !resultsPath.isBlank() ? resultsPath + "\\" + prefix + "strings.txt" : prefix + "strings.txt";
                FileWriter fw = new FileWriter(path);
                for (var val : stringList) {
                    fw.write(val + "\n");
                }
                fw.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}