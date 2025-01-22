import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if("([{".contains(s.charAt(i) + "")) {
                brackets.push(s.charAt(i));
            } else if(")]}".contains(s.charAt(i) + "")) {
                if(brackets.isEmpty()) return false;
                char top = brackets.pop();
                if(top == '(' && s.charAt(i) != ')' || top == '[' && s.charAt(i) != ']' || top == '{' && s.charAt(i) != '}') return false;
            } else {
                throw new IllegalArgumentException();
            }
        }
        return brackets.isEmpty();
    }
}
