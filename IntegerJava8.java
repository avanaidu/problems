package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IntegerJava8 {
    public static void main(String[] args) throws Exception {
        int[] a = new int[]{13, 5, 13, 5, 4, 21, 13, 27, 2, 59, 59, 34};
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        System.out.println(reverseList(list));
        System.out.println(findThirdhighest(list));
        System.out.println("last three :: "+lastThreeSorted(list));
        System.out.println("First Non repeated :: "+firstNonRepeted(list));
        System.out.println("Most Repeated :: "+mostRepeated(list));
    }

    private static Integer mostRepeated(List<Integer> list) {
        return list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(x-> x.getValue()>1).map(Map.Entry::getKey).findFirst().get();
    }

    private static Integer firstNonRepeted(List<Integer> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap :: new, Collectors.counting()))
                .entrySet().stream().filter(x-> x.getValue() == 1).map(Map.Entry::getKey).findFirst().get();
    }

    private static List lastThreeSorted(List<Integer> list) {
        return list.stream().distinct().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
    }

    private static List reverseList(List<Integer> list) {
        return list.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    private static Integer findThirdhighest(List<Integer> list) throws Exception {

        return list.stream().distinct().sorted(Comparator.reverseOrder()).skip(2).findFirst()
                .orElseThrow(Exception::new);
    }
}
