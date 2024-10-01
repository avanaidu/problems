import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8SortingByValueMap {
    public static void main(String[] args) {
        Map<String, Integer> items = new HashMap<>();
        items.put("phone", 2);
        items.put("fridge", 4);
        items.put("washing machine", 7);
        items.put("cooker", 3);
        items.put("oven", 5);
        items.put("mixer", 1);

        System.out.println(sortItems(items));
    }

    private static Map<String, Integer> sortItems(Map<String, Integer> items) {

        return items.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o1, o2) -> o1, LinkedHashMap::new));
    }
}
