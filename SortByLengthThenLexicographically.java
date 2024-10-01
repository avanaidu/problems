import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortByLengthThenLexicographically {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "pear", "kiwi", "pineapple","arw", "orange", "raw");

        List<String> result = words.stream().sorted(Comparator.comparing(String::length).thenComparing(s->s)).collect(Collectors.toList());
                //.thenComparing(s -> s)).collect(Collectors.toList());
        System.out.println(result);
    }
}
