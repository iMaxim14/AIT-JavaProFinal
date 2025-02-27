package de.ait.javalessons.consultation03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParamTestsMusterClassTest {

    private ParamTestsMusterClass paramTestsMusterClass;


    @BeforeEach
    void setUp() {
        paramTestsMusterClass = new ParamTestsMusterClass();
    }


    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10, 12})
    @DisplayName("все числа четные")
    void testIsEven(int number) {
        assertTrue(paramTestsMusterClass.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 7, 9, 11, 13})
    void testIsNotEven(int number) {
        paramTestsMusterClass = new ParamTestsMusterClass();
        assertFalse(paramTestsMusterClass.isEven(number));
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "5,5,10",
            "10, -5, 5",
            "0, 0, 0"
    })
    void testAdd(int a, int b, int expected) {
        assertEquals(expected, paramTestsMusterClass.add(a, b));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testdata/test.csv", numLinesToSkip = 1)
    void testAddFromFile(int a, int b, int expected) {
        assertEquals(expected, paramTestsMusterClass.add(a, b));
    }
}
