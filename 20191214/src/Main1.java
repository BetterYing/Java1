import java.util.*;

public class Main1 {
    public static boolean chkParenthesis(String A, int n) {
        // write code here
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '(') {
                stack.push(A.charAt(i));
            } else {
                if (stack.empty()) {
                    return false;
                } else {
                    char ch = stack.peek();
                    if (ch == '(' && A.charAt(i) == ')') {
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

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Boolean ret = chkParenthesis(str,str.length());
        System.out.println(ret);
    }
}