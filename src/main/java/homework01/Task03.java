package homework01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task03 {
public static List<String> rivers = Arrays.asList("Amazon", "Nile", "Yangtze", "Mississippi", "Danube", "Main", "Ganges");

    public static void main(String[] args) {
        System.out.println(getEvenNumber());
    }

    public static List<String> getEvenNumber(){
        List<String> evenNumber = rivers.stream()
                .filter(river -> river.length() % 2 == 0)
                .collect(Collectors.toList());

        return evenNumber;
    }
}
