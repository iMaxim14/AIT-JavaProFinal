package homework07;

import lombok.extern.slf4j.Slf4j;

//@Slf4j
public class Homework07 {

    public int add(int a, int b) {
        return a + b;
    }

    public boolean isEven(int a) {
        return a % 2 == 0;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            System.out.println("Divide by zero");

            return -111;
        }
        return a / b;
    }

    public int getLength(String a) {
        if (a == null) {
            System.out.println("String is null");
            return -1;
        }
        return a.length();
    }

    public boolean containsWord(String text, String word) {
        if (text == null || word == null) {
            System.out.println("Text or word is null");
            return false;
        }
        if (text.isEmpty() || word.isEmpty()) {
            System.out.println("Text or word is empty");
            return false;
        }
        return text.contains(word);
    }

}
