package org.example;

public class StatRecorder {

    private int integerCount;
    private int floatCount;
    private int stringCount;


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
}
