package homework01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task01 {
    private static List<String> countries = Arrays.asList("Germany", "France", "Brazil", "Argentina", "Canada", "China", "Australia", "India");

    public static void main(String[] args) {
        System.out.println(getBeginWithC());
    }

    public static List<String> getBeginWithC (){
        List<String> beginWithC = countries.stream()
                .filter(country -> country.startsWith("C"))
                .collect(Collectors.toList());
        return beginWithC;
    }
}
