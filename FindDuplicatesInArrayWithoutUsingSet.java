package java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicatesInArrayWithoutUsingSet {

    public static void main(String[] args) {
        int[] a = new int[]{5, 13, 4, 21, 13, 27, 2, 59, 59, 34};
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        System.out.println(findDuplicates(list));
    }

    private static List<Integer> findDuplicates(List<Integer> a) {
        Map<Integer, Long> map = a.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(), LinkedHashMap::new,
                        Collectors.counting()));

       /*Map<Integer, Long> filteredMap =  map.entrySet().stream().filter(m -> m.getValue() > 1)
               .collect(Collectors.toMap(m->m.getKey(), m->m.getValue()));
       return filteredMap.keySet().stream().collect(Collectors.toList());*/
        return  map.entrySet().stream().filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey).collect(Collectors.toCollection(LinkedList:: new));
    }
}
