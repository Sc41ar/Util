package org.example;

import java.util.List;

public class Filter {
    private final Writer fileWriter;
    private final StatRecorder statRecorder;

    public Filter(Writer fileWriter, StatRecorder statRecorder) {
        this.fileWriter = fileWriter;
        this.statRecorder = statRecorder;
    }

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
//    int, short, byte, etc. -> Int
//    other -> String
    // возвращаемое значение необходимо для тестов
    public String stringTypeFilter(String originalSt) {
        if (originalSt.isBlank())
            return "Blank";
        try {
            var intgr = Long.parseLong(originalSt);
            statRecorder.incrementIntegerCount();
            fileWriter.integerList.add(intgr);
            return "Int";
        } catch (NumberFormatException ignored) {
        }
        try {
            var dotsStr = originalSt.substring(0).replace(',', '.'); //Исключение проблем с локалью
            //для сохранения корректности исходной строки делаем сохраняем это в другую строку
            var dbl = Double.parseDouble(dotsStr);
            statRecorder.incrementFloatCount();
            fileWriter.doubleList.add(dbl);
            return "Float";
        } catch (NumberFormatException ignored) {
        }
        statRecorder.incrementStringCount();
        fileWriter.stringList.add(originalSt);
        return "String";

    }

    public StatRecorder getStatRecorder() {
        return statRecorder;
    }
}