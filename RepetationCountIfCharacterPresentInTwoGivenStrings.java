import java.util.HashMap;

public class RepetationCountIfCharacterPresentInTwoGivenStrings {

    public static void main(String[] args) {

        //Repetion Count if  char exist in two strings
        String s1 ="sisileraam";
        String s2 = "mitylerett";

        HashMap<Character, Integer> charLength = new HashMap<>();
        for (int i=0; i< s1.length(); i++){
            int c=0;
            for (int j=0; j<s2.length(); j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    c++;
                }
            }

            if(c>0){
                c = c + countRepeatwithinString(s1, s1.charAt(i));
                charLength.put(s1.charAt(i), c);
            }
        }

        charLength.entrySet().stream().forEach(entry ->
                System.out.println("key :: "+entry.getKey() +" Repetetions :: "+entry.getValue()));
    }

    private static int countRepeatwithinString(String s1, char c) {
        int cnt = 0;
        for (int k=0; k< s1.length(); k++){

            if(s1.charAt(k) == c){
                cnt++;
            }
        }
        if(cnt >1){
            return cnt++;
        }
        return 0;
    }
}
