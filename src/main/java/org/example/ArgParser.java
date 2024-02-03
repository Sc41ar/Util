package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class ArgParser {
    private final Writer writer;
    private FileOpener fileOpener;

    public ArgParser() {
        writer = new Writer();
        fileOpener = new FileOpener();
    }

    public void parseArgsArray(String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-a" -> writer.setFileAddFlag(true);
                case "-p" -> {
                    if (i < args.length - 1) {
                        writer.setPrefix(args[++i]);//Сомнительно, но ОКЭ TODO
                        break;
                    }
                }
                case "-o" -> {
                    if (i < args.length - 1) {
                        writer.setResultsPath(args[++i]);// TODO
                        break;
                    }
                }
                default -> {
                    var fileLines = fileOpener.readFileLines(args[i]);
                    if (fileLines != null)
                    {

                    }

                }
            }
        }
    }
}
