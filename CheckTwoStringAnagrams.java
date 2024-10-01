import java.util.Arrays;
import java.util.stream.Collectors;

public class CheckTwoStringAnagrams {


    public static void main(String[] args) {
        String s1 = "cat";
        String s2 = "act";
        anagram(s1, s2);
    }

    private static void anagram(String s1, String s2) {

        String s1temp = Arrays.stream(s1.split("")).sorted().collect(Collectors.joining());
        String s2temp = Arrays.stream(s2.split("")).sorted().collect(Collectors.joining());
        System.out.println("s1temp :: "+s1temp +" s2temp :: "+s2temp);
    }
}
