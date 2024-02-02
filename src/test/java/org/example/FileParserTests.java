package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileParserTests {
    @Test
    public void checkTypeTest() {
        FileParser fileParser = new FileParser(new Writer());
        var expected = new String[]{
                "String",
                "String",
                "Float",
                "Float",
                "Float",
                "Float",
                "Int",
                "Int",
        };

        var actual = new String[]{
                fileParser.checkType("String 124sd"),
                fileParser.checkType("-123&123"),
                fileParser.checkType("-123.1"),
                fileParser.checkType("555,123"),
                fileParser.checkType("-1,5E-10"),
                fileParser.checkType("1.1E26"),
                fileParser.checkType("123"),
                fileParser.checkType("-0")
        };

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void checkTypeStatisticsRecordTest() {
        FileParser fileParser = new FileParser(new Writer());

        fileParser.checkType("String 124sd");
        fileParser.checkType("-123&123");
        fileParser.checkType("-123.1");
        fileParser.checkType("555,123");
        fileParser.checkType("-1,5E-10");
        fileParser.checkType("1.1E26");
        fileParser.checkType("123");
        fileParser.checkType("-0");

        var expected = new int[]{2, 4, 2};

        var actual = new int[]{
                fileParser.getStatRecorder().getStringCount(),
                fileParser.getStatRecorder().getFloatCount(),
                fileParser.getStatRecorder().getIntegerCount()
        };

        Assertions.assertArrayEquals(expected, actual);
    }

//    @[098765yutponmkjiwhg3e4rf;

}
