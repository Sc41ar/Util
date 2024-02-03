package org.example;

public class ArgParser {
    private final Writer writer;
    private final FileOpener fileOpener;
    private final StatRecorder statRecorder;

    private final Filter filter;

    public ArgParser() {
        writer = new Writer();
        fileOpener = new FileOpener();
        statRecorder = new StatRecorder(writer);
        filter = new Filter(writer, statRecorder);
    }

    public void parseArgsArray(String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-a" -> writer.setFileAddFlag(true);
                case "-p" -> {
                    if (i < args.length - 1) {
                        writer.setPrefix(args[++i]);//Сомнительно, но ОКЭ TODO
                    }
                }
                case "-o" -> {
                    if (i < args.length - 1) {
                        writer.setResultsPath(args[++i]);// TODO
                    }
                }
                case "-s" -> statRecorder.setBriefStatOutput(true);
                case "-f" -> statRecorder.setBriefStatOutput(false);
                default -> {
                    var fileLines = fileOpener.readFileLines(args[i]);
                    if (fileLines != null) {
                        filter.filterStringList(fileLines);
                    }
                }
            }
        }
        writer.writeFilteredData();
        statRecorder.statOut();
    }
}
