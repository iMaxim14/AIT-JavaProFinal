package de.ait.javalessons.homework07;

import homework07.Homework07;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Homework07Test {

    private Homework07 homework07;

    @BeforeEach
    public void setup(){
        homework07 = new Homework07();
    }

    //Задание 1
    @ParameterizedTest
    @CsvFileSource(resources = "/testdata/homework07testAdd.csv", numLinesToSkip = 1)
    @DisplayName("Сложение чисел")
    void testAdd(int a, int b, int expected){
        assertEquals(expected, homework07.add(a,b));
    }

    //Задание 2
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    @DisplayName("Четные числа")
    void isEvenTest ( int a){
        assertTrue(homework07.isEven(a));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    @DisplayName("Нечетные числа")
    void isNotEvenTest (int a){
        assertFalse(homework07.isEven(a));
    }

    //Задание 3
    @ParameterizedTest
    @CsvFileSource(resources = "/testdata/homework07testDivide", numLinesToSkip = 1)
    @DisplayName("Деление чисел")
    void testDivide(int a, int b, int expected){
        assertEquals(expected, homework07.divide(a,b));
    }

    //Задание 4
    @ParameterizedTest
    @CsvFileSource(resources = "/testdata/homework07test04", numLinesToSkip = 1)
    @DisplayName("Возврат длины строки")
    void testLengthOfString(String a, int expected){
        assertEquals(expected, homework07.getLength(a));
    }

    //Задание 5
    @ParameterizedTest
    @CsvFileSource(resources = "/testdata/homework07test05", numLinesToSkip = 1)
    @DisplayName("Содержит ли строка определенное слово")
    void testLengthOfString2(String a, String b){
        assertTrue(homework07.containsWord(a, b));
    }

}
