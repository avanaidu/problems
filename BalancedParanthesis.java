import java.util.Stack;

public class BalancedParanthesis {
    public static void main(String[] args) {
        System.out.println(validateParanthesis("[({})][]()"));
        System.out.println(validateParanthesis("[(])"));
        System.out.println(validateParanthesis("{}"));
    }

    private static boolean validateParanthesis(String paranthesis) {

        Stack<Character> stack = new Stack<>();

        for (char ch : paranthesis.toCharArray()) {
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                else if (ch == '}' && stack.peek() == '{') {
                    stack.pop();
                }
                else if (ch == ']' && stack.peek() == '[') {
                    stack.pop();
                }
                else if (ch == ')' && stack.peek() == '(') {
                    stack.pop();
                }
                else return false;
            }
        }


        return stack.isEmpty();
    }
}
