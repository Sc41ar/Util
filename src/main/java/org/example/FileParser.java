package org.example;

public class FileParser {

    //double/float, etc -> float
//    int, short, byte, etc -> Int
//    other -> String
    public String checkType(String originalSt) {
        try {
            var intgr = Integer.parseInt(originalSt);
            return "Int";
        } catch (NumberFormatException e) {
            System.out.println("Не целое");
        }
        try {
            var dotsStr = originalSt.replace(',', '.');
            var dbl = Double.parseDouble(dotsStr);
            return "Float";
        } catch (NumberFormatException e) {
            System.out.println("Не с плавающей");
        }

        return "String";

    }
}
