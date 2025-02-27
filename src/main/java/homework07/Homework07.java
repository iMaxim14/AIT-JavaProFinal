package homework07;

public class Homework07 {
    public int add(int a, int b){
        return a + b;
    }

    public boolean isEven (int a){
        return a % 2 == 0;
    }

    public int divide (int a, int b){
        return a / b;
    }

    public int getLength (String a){
        return a.length();
    }

    public boolean containsWord(String text, String word){
        return text.contains(word);
    }
}
