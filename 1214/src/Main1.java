import java.util.Stack;

public class Main1 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.add(node);

    }
    public int pop() {
        while (!stack1.empty()) {
            stack2.add(stack1.pop());
        }
        int ret = stack2.pop();
        while (!stack2.empty()) {
            stack1.add(stack2.pop());
        }
        return ret;
    }
}
