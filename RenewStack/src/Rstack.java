public class Rstack {
    private int[] array = new int[10];
    private int top;

    private boolean isFull () {
        if (this.top == array.length) {
            return true;
        }
        return false;
    }

    private boolean isEmpty() {
        if (top == 0) {
            return true;
        }
        return false;
    }

    //入栈
    private void push(int num) {
        if (isFull()) {
            throw new RuntimeException("栈已满");
        }
        top++;
        array[top] = num;
    }
    //得到栈顶元素
    private int peak() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        return array[top];
    }
    //出栈,保存出栈元素
    private int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        int num = array[top];
        top--;
        return num;
    }
    private int size() {
        return top;
    }
}
