import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Palindrome {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("aba", "abba", "no", "nan", "rasar", "sail");
        System.out.println(palindrome(words));
    }

    private static List<String> palindrome(List<String> words) {

        return words.stream().filter(Palindrome::isPalindrome).collect(Collectors.toList());
    }

    private static boolean isPalindrome(String word) {

        for (int i=0; i< word.length()/2; i++){
            if(word.charAt(i) != word.charAt(word.length() -i -1) ){
                return false;
            }
        }
        return true;
    }
}
