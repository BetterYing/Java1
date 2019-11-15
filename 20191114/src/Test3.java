import java.util.Stack;
class MinStack {
    public Stack<Integer> stack;
    public Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        //1、stack栈内一定会入栈
        stack.push(x);
        //2、第一次minStack一定会放元素，其余的每次
        //往stack栈-》和minStack栈顶比较
        // x <= minStack.peek()--->minStack.push(x);
        if (minStack.empty()) {
            minStack.push(x);
        } else {
            if (x <= minStack.peek()) {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        if(stack.empty()) {
            return;
        }
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        if (stack.empty()) {
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        if(minStack.empty()) {
            return -1;
        }
        return minStack.peek();
    }
}

public class Test3 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(7);
        minStack.push(5);
        minStack.pop();
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
    }

}
