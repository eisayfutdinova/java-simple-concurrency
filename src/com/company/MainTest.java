package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void parseIt() {
        String str = "55";
        double strNum = Main.parseDouble(str);
        assertEquals(strNum, 55);

        str = "123.44";
        strNum = Main.parseDouble(str);
        assertEquals(strNum, 123.44);

        str = "33,3";
        strNum = Main.parseDouble(str);
        assertEquals(strNum, 0);

        str = "33.rr";
        strNum = Main.parseDouble(str);
        assertEquals(strNum, 0);

    }

}