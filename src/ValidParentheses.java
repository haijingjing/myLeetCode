import java.util.Stack;

//20 有效的括号
public class ValidParentheses {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < n; i ++){
            if(isleft(s.charAt(i))){
                stack.push(s.charAt(i));
            }else {
                if(stack.empty()) return false;
                char c = stack.pop();
                if(!isMatch(c, s.charAt(i))){
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private boolean isleft(char c) {
        return c == '(' || c == '{' || c =='[';
    }

    private boolean isMatch(char a, char b) {
        return (a =='(' && b ==')') || (a =='{' && b =='}') || (a =='[' && b ==']');
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
