//栈如果用单链表实现，采用头进头出，时间复杂度与空间复杂度都为O（1）

public class MyStack<T> {
    public T[] elem;
    public int top;

    public MyStack() {
        this.elem = (T[]) new Object[10];//泛型不能new一个泛型的数组
    }

    public boolean isFull() {
        if (this.top == this.elem.length) {
            return true;
        }
        return false;
    }
    //入栈
    public void push (T data) {
        if (isFull()) {
            throw new UnsupportedOperationException("栈满了");
        }
        this.elem[top++] = data;
    }

    public boolean isEmpty() {
        if (this.top == 0) {
            return true;
        }
        return false;
    }
    //出栈
    public T pop() {
        if (isEmpty()) {
            //NullPointerException
            throw new NullPointerException("栈为空");
        }
        T num = this.elem[--this.top];
        //this.top--;
        return num;
    }
    //得到栈顶元素,但是不删除栈顶元素
    public T peek() {
        return elem[top - 1];
    }
    //长度
    public int size() {
        return top;
    }
}
