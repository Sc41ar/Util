package org.example;

public class ArgParser {
    private final Writer writer;

    public ArgParser() {
        writer = new Writer();
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
                default -> throw new IllegalStateException("Unexpected value: " + args[i]);
            }
        }
    }
}
