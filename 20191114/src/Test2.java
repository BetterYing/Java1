import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    public Queue<Integer> queue1;
    public Queue<Integer> queue2;
    /** Initialize your data structure here. */    //初始化
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (!queue1.isEmpty()) {
            queue1.offer(x);
        } else if (!queue2.isEmpty()){
            queue2.offer(x);
        } else {
            queue1.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (empty()) {
            return -1;
        }
        int old;
        if (!queue1.isEmpty()) {
            int size = queue1.size();
            for (int i = 0; i < size - 1; i++) {
                queue2.offer(queue1.poll());
            }
            old = queue1.poll();
        } else {
            int size = queue2.size();
            for (int i = 0; i < size - 1; i++) {
                queue1.offer(queue2.poll());
            }
            old = queue2.poll();
        }
        return old;
    }

    /** Get the top element. */
    public int top() {
        if (empty()) {
            return -1;
        }
        int old = 0;
        if (!queue1.isEmpty()) {
            int size = queue1.size();
            for (int i = 0; i < size; i++) {
                old = queue1.poll();
                queue2.offer(old);
            }
        } else {
            int size = queue2.size();
            for (int i = 0; i < size ; i++) {
                old = queue2.poll();
                queue1.offer(old);
            }
        }
        return old;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return true;
        }
        return false;
    }
}


public class Test2 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println(myStack.pop());
        System.out.println(myStack.top());


    }
}
