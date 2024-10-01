import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Anagrams {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("cat", "dog", "act", "god", "tac", "den");

        System.out.println(sortStrings(words));
    }

    private static Set<Set<String>>  sortStrings(List<String> words) {
        
        Map<String, List<String>> anagram = words.stream().collect(Collectors.groupingBy(Anagrams::sortWord));
        return anagram.values().stream().map(HashSet::new).collect(Collectors.toSet());

    }

    private static String sortWord(String word) {
        /*char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);*/
        return Arrays.stream(word.split("")).sorted().collect(Collectors.joining());
    }


}
