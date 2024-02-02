package org.example;

public class FileParser {
    private final Writer fileWriter;
    private StatRecorder statRecorder;

    public FileParser(Writer fileWriter) {
        this.fileWriter = fileWriter;
        statRecorder = new StatRecorder();
    }

    //double/float, etc -> float
//    int, short, byte, etc -> Int
//    other -> String
    public String checkType(String originalSt) {
        if (originalSt.isBlank())
            return "Blank";
        try {
            Integer.parseInt(originalSt);
            statRecorder.incrementIntegerCount();
            fileWriter.integerList.add(originalSt);
            return "Int";
        } catch (NumberFormatException e) {
            System.out.println("Не целое");
        }
        try {
            var dotsStr = originalSt.substring(0).replace(',', '.'); //Исключение проблем с локалью
            //для сохранения корректности исходной строки делаем сохраняем это в другую строку
            //TODO дабл чек целесообразности этого потом
            Double.parseDouble(dotsStr);
            statRecorder.incrementFloatCount();
            fileWriter.doubleList.add(dotsStr);
            return "Float";
        } catch (NumberFormatException e) {
            System.out.println("Не с плавающей");
        }
        statRecorder.incrementStringCount();
        fileWriter.stringList.add(originalSt);
        return "String";

    }

    public StatRecorder getStatRecorder() {
        return statRecorder;
    }

    public void setStatRecorder(StatRecorder statRecorder) {
        this.statRecorder = statRecorder;
    }
}
