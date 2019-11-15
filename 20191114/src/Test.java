import java.util.Stack;

public class Test {
    public boolean isValid(String s)  {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(' ) {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()) {
                    return false;
                } else {
                    if (stack.peek() == s.charAt(i)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }



    public static void main(String[] args) {

    }
}
