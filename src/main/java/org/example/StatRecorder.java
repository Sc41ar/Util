package org.example;

public class StatRecorder {

    private final Writer writer;
    private int integerCount;
    private int floatCount;
    private int stringCount;
    private boolean briefStatOutput = true;

    public StatRecorder(Writer writer) {
        this.writer = writer;
    }


    //? TODO
    /*public void addIntegerCount(int count) {
        integerCount += count;
    }

    public void addFloatCount(int count) {
        floatCount += count;
    }

    public void addStringCount(int count) {
        stringCount += count;
    }*/
    public void incrementIntegerCount() {
        integerCount++;
    }

    public void incrementFloatCount() {
        floatCount++;
    }

    public void incrementStringCount() {
        stringCount++;
    }

    public int getStringCount() {
        return stringCount;
    }

    public void setStringCount(int stringCount) {
        this.stringCount = stringCount;
    }

    public int getIntegerCount() {
        return integerCount;
    }

    public void setIntegerCount(int integerCount) {
        this.integerCount = integerCount;
    }

    public int getFloatCount() {
        return floatCount;
    }

    public void setFloatCount(int floatCount) {
        this.floatCount = floatCount;
    }

    public boolean isBriefStatOutput() {
        return briefStatOutput;
    }

    public void setBriefStatOutput(boolean briefStatOutput) {
        this.briefStatOutput = briefStatOutput;
    }

    private void briefOut() {
        System.out.println("\n---------------------------------------------------------\n"
                + "Количество целых чисел в файлах: "
                + integerCount
                + "\n---------------------------------------------------------\n");

        System.out.println("\n---------------------------------------------------------\n"
                + "Количество чисел с плвающей запятой в файлах: "
                + floatCount
                + "\n---------------------------------------------------------\n");

        System.out.println("\n---------------------------------------------------------\n"
                + "Количество строковых данных в файлах: "
                + stringCount
                + "\n---------------------------------------------------------\n");
    }

    private void fullOut() {
        intFullOut();
        doubleFullOut();
        StringFullOut();
    }

    private void StringFullOut() {
        var maxLength = writer.stringList.stream().max(String::compareTo);
        var minLength = writer.stringList.stream().min(String::compareTo);


        System.out.println("\n---------------------------------------------------------\n"
                + "Количество строковых данных в файлах: "
                + stringCount
                + "\nНаибольшая длина строки: "
                + (maxLength.map(string -> string.length() + "\tСтрока: " + string).orElse("Нельзя однозначно определить"))
                + "\nНаименьшая длина строки: "
                + (minLength.map(s -> s.length() + "\tСтрока: " + s).orElse("Нельзя однозначно определить"))
                + "\n---------------------------------------------------------\n");
    }

    private void doubleFullOut() {
        var doubleList = writer.doubleList;
        double[] doubleArray = doubleList.stream().mapToDouble(Double::doubleValue).sorted().toArray();
        var sum = doubleList.stream().mapToDouble(Double::doubleValue).sum();
        var doubleMinOptional = doubleList.stream().min(Double::compareTo);
        var doubleMaxOptional = doubleList.stream().max(Double::compareTo);
        double doubleMedian;
        if (doubleList.size() % 2 == 0) {
            doubleMedian = (doubleArray[floatCount / 2]
                    + doubleArray[(floatCount / 2) - 1]) / 2;
        } else
            doubleMedian = doubleArray[floatCount / 2];

        System.out.println("\n---------------------------------------------------------\n"
                + "Количество чисел с плавающей запятой в файлах: "
                + floatCount
                + "\nМинимальное число с плавающей точки: "
                + (doubleMinOptional.isPresent() ? doubleMinOptional.get() : "Не найдено")
                + "\nМаксимальное целое: "
                + (doubleMaxOptional.isPresent() ? doubleMaxOptional.get() : "Не найдено")
                + "\nСумма всех целых чисел: "
                + sum
                + "\nСреднее значение: "
                + sum / floatCount     // - не совсем ясно какое среднее требуется ????
                + "\nМедианное значение: "
                + doubleMedian
                + "\n---------------------------------------------------------\n");
    }

    private void intFullOut() {
        var intList = writer.integerList;
        var integerArray = intList.stream().mapToInt(Long::intValue).sorted().toArray();
        var intSum = intList.stream().mapToLong(Long::intValue).sum();   // List -> Stream -> LongStream(по значению) тут уже метод суммы есть в 21
        var intMinOptional = intList.stream().min(Long::compareTo); //возвращаемы тип Optinal >> его надо проверить на isPresent  получить значение
        var intMaxOptional = intList.stream().max(Long::compareTo); //
        int intMedian;
        if (intList.size() % 2 == 0)
            intMedian = (integerArray[integerCount / 2]
                    + integerArray[(integerCount / 2) - 1]) / 2; // Если четное кол-во целых >> сумма 2 средних/2
        else
            intMedian = integerArray[integerCount / 2];

        System.out.println("\n---------------------------------------------------------\n"
                + "Количество целых чисел в файлах: "
                + integerCount
                + "\nМинимальное целое: "
                + (intMinOptional.isPresent() ? intMinOptional.get() : "Не найдено")
                + "\nМаксимальное целое: "
                + (intMaxOptional.isPresent() ? intMaxOptional.get() : "Не найдено")
                + "\nСумма всех целых чисел: "
                + intSum
                + "\nСреднее значение: "
                + intSum / integerCount// - не совсем ясно какое среднее требуется ????
                + "\nМедианное значение: "
                + intMedian
                + "\n---------------------------------------------------------\n");
    }


    public void statOut() {
        if (briefStatOutput) briefOut();
        else fullOut();
    }

}
