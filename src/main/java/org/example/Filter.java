package org.example;

import java.util.List;

public class Filter {
    private final Writer fileWriter;
    private StatRecorder statRecorder;

    public Filter(Writer fileWriter) {
        this.fileWriter = fileWriter;
        statRecorder = new StatRecorder(fileWriter);
    }

    public void filterStringList(List<String> list) {
        for(var str: list){
            stringTypeFilter(str);
        }
    }

    //double/float, etc -> float
//    int, short, byte, etc -> Int
//    other -> String
    public String stringTypeFilter(String originalSt) {
        if (originalSt.isBlank())
            return "Blank";
        try {
            var intgr = Integer.parseInt(originalSt);
            statRecorder.incrementIntegerCount();
            fileWriter.integerList.add(intgr);
            return "Int";
        } catch (NumberFormatException e) {
            System.out.println("Не целое");
        }
        try {
            var dotsStr = originalSt.substring(0).replace(',', '.'); //Исключение проблем с локалью
            //для сохранения корректности исходной строки делаем сохраняем это в другую строку
            //TODO дабл чек целесообразности этого потом
            var dbl = Double.parseDouble(dotsStr);
            statRecorder.incrementFloatCount();
            fileWriter.doubleList.add(dbl);
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
}