package homework01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task02 {
public static List<String> cities = Arrays.asList("Berlin", "Buenos Aires", "Paris", "Los Angeles", "New York", "London", "Beijing");
    public static void main(String[] args) {
        System.out.println(getLonger6Symbols());
    }

    public static List<String> getLonger6Symbols(){
        List<String> longer6Symbols = cities.stream().filter(city -> city.length() > 6)
                .collect(Collectors.toList());

        return longer6Symbols;
    }
}
