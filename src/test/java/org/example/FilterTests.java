package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilterTests {
    @Test
    public void checkTypeTest() {
        Filter filter = new Filter(new Writer());
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
                filter.stringTypeFilter("String 124sd"),
                filter.stringTypeFilter("-123&123"),
                filter.stringTypeFilter("-123.1"),
                filter.stringTypeFilter("555,123"),
                filter.stringTypeFilter("-1,5E-10"),
                filter.stringTypeFilter("1.1E26"),
                filter.stringTypeFilter("123"),
                filter.stringTypeFilter("-0")
        };

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void checkTypeStatisticsRecordTest() {
        Filter filter = new Filter(new Writer());

        filter.stringTypeFilter("String 124sd");
        filter.stringTypeFilter("-123&123");
        filter.stringTypeFilter("-123.1");
        filter.stringTypeFilter("555,123");
        filter.stringTypeFilter("-1,5E-10");
        filter.stringTypeFilter("1.1E26");
        filter.stringTypeFilter("123");
        filter.stringTypeFilter("-0");

        var expected = new int[]{2, 4, 2};

        var actual = new int[]{
                filter.getStatRecorder().getStringCount(),
                filter.getStatRecorder().getFloatCount(),
                filter.getStatRecorder().getIntegerCount()
        };

        Assertions.assertArrayEquals(expected, actual);
    }

//    @[098765yutponmkjiwhg3e4rf;

}
