package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionJava8 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("naidu","avu", "abhi", "AVU", "VenkataAvu","pri", "thanos");
        System.out.println(sortList(list));
        System.out.println(duplicateString("avveojjjfhjjwwwwdddrqqwwwaa"));
        System.out.println(dupfreeString("aavuavuprthaaavu"));
        System.out.println("Longest String :: "+longestString(list));

        System.out.println("The string highest length ::"+highestStringlength(list));

        Map<String, Integer> integerHashMap = new HashMap<>();
        integerHashMap.put("thanos", 19);
        integerHashMap.put("abhi", 12);
        integerHashMap.put("naidu", 9);
        integerHashMap.put("katham", 11);
        integerHashMap.put("hab", 8);
        integerHashMap.put("av", 3);

        System.out.println(sortMap(integerHashMap));

    }

    private static String longestString(List<String> list) {
        return list.stream().reduce((s1, s2) -> s1.length()>s2.length() ? s1:s2).get();
    }

    private static String highestStringlength(List<String> list) {

        return list.stream()
                .sorted((string1, string2) -> string2.length()-string1.length())
                .findFirst().orElse("");
    }


    private static Map sortMap(Map<String, Integer> integerHashMap) {
       return integerHashMap.entrySet().stream()
               //.sorted(Comparator.comparing(x-> x.getValue()))
               .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2)->e1, LinkedHashMap::new));
    }

    private static String dupfreeString(String dupString) {
        String dupFree = Arrays.stream(dupString.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .keySet().stream().collect(Collectors.joining(",","[","]"));
        return dupFree;
    }


    private static Map<String, Long> duplicateString(String dupString) {
        Map<String, Long> dupMap = Arrays.stream(dupString.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return dupMap;
    }

    private static List<String> sortList(List<String> list) {

        Map<String, Long> sortedMap = list.stream()
                .map(x-> x.toLowerCase())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        /*List duplicateList = sortedMap.entrySet().stream().filter(x-> x.getValue() > 1)
                .collect(Collectors.toMap(x -> x.getKey(), x-> x.getValue())).keySet()
                .stream().collect(Collectors.toList());*/
        List duplicateList = sortedMap.entrySet().stream().filter(x-> x.getValue() > 1)
                .map(Map.Entry::getKey).collect(Collectors.toList());
        return duplicateList;
    }
}
