import java.util.Stack;

public class ReverseStringButPersistAlphabetWords {
    /*Reverse String -
    input="1234my5678name&%@raja90"
    Output="09raja@%&name8765my4321"
    */
    public static void main(String[] args) {

        String input =  "1234my5678name&%@raja90";
        StringBuilder outp = new StringBuilder();

        Stack<String> stack = new Stack<>();
        StringBuilder words = new StringBuilder();

        for (int i = 0 ; i< input.length(); i++){

            boolean alphaflag;
            if(Character.isAlphabetic(input.charAt(i))){
                words.append(input.charAt(i));
                alphaflag = true;
            }
            else {
                alphaflag = false;
            }

            if (!alphaflag && words.length() != 0){
                stack.push(words.toString());
                words = new StringBuilder();
            }
        }

        int count = 0;
        for (int i = input.length()-1; i >= 0; i--){

            if(Character.isAlphabetic(input.charAt(i))){

                if(count == 0) {
                    outp.append(stack.pop());
                }
                count++;
            }
            else{
                count = 0;
                outp.append(input.charAt(i));
            }
        }

        System.out.println(outp);

    }
}
