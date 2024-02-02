package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private String prefix = "";

    private String resultsPath = "";

    private boolean fileAddFlag = false;

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
            FileWriter fw = new FileWriter(resultsPath+prefix+"test.txt");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        this.resultsPath = resultsPath;

    }
}
