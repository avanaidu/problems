import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateWordsInAStringJava8 {
    public static void main(String[] args) {
        String name= "My Name is Avu is not my actual Name but name is same";
        System.out.println(findDuplicateWordsInString(name));
    }

    private static List<String> findDuplicateWordsInString(String name) {
        return  Arrays.stream(name.split(" ")).map(str-> str.toLowerCase()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(x-> x.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
