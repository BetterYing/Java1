import java.util.Stack;

class MyQueue {

    public Stack<Integer> stack;

    public Stack<Integer> stackTmp;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
        stackTmp = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stackTmp.empty()) {
            //将stack 栈当中的所有元素全部倒入 stackTmp;
            for (int i = 0; i < stack.size(); i++) {
                stackTmp.push(stack.pop());
            }
        }
        if(!stackTmp.empty()) {
            //将stackTmp 的栈顶元素弹出-》出栈stackTmp.pop
            return stackTmp.pop();
        }
        return -1;
    }

    /** Get the front element. */
    public int peek() {
        if(stackTmp.empty()) {
            //将stack 栈当中的所有元素全部倒入 stackTmp;
            for (int i = 0; i < stack.size(); i++) {
                stackTmp.push(stack.pop());
            }
        }
        if(!stackTmp.empty()) {

            return stackTmp.peek();
        }
        return -1;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stackTmp.empty() && stack.empty()) {
            return true;
        }
        return false;
    }
}

public class Test1 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());

    }
}
