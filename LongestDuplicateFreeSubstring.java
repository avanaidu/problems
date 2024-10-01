import java.util.HashMap;

public class LongestDuplicateFreeSubstring {


    public static void main(String[] args) {
        //String, Integer

        //ABCDEFGABEF

        String input = "ADBCFRAEBCD";///bbbbb
        System.out.println(longestDupFree(input));

    }

    private static int longestDupFree(String input) {

        int maxlen =1;
        int len = input.length();

        for(int i =0; i< len ; i++){
            int count = 1;
            HashMap<Character, String> temp = new HashMap<>();
            temp.put(input.charAt(i), "");
            for(int j=i+1; j< len; j++){
                if(input.charAt(i) != input.charAt(j) && !temp.containsKey(input.charAt(j)) ){
                    temp.put(input.charAt(j),"");
                    count++;
                }
                else{
                    break;
                }

            }

            System.out.println("count :: "+count +" char :: "+temp);
            if(count > maxlen) {
                maxlen = count;
            }

        }

        return maxlen;
    }
}
