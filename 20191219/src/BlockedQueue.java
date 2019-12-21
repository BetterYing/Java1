/*
* 多生产 多消费 正确
*/

public class BlockedQueue {
    private int[] elem ;
    private int front;//队首元素所在位置
    private int rear;//下一个要插入元素的下标
    private volatile int size; //已有元素的个数

    public BlockedQueue(int captity) {
        elem = new int[captity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void put (int key) throws InterruptedException {
        if (size < elem.length) {
            elem[front] = key;
            front = (front + 1) % elem.length;
            size++;
            notifyAll();
            return;
        }
        while (size == elem.length) {
            synchronized (this) {
                if (size == elem.length) {
                    wait();
                }
            }
        }
    }
    public int take () {
        int key = 0;
        if (size > 0) {
            key = elem[rear];
            rear = (rear + 1) % elem.length;
            size--;
            notifyAll();
            return key;
        }
        return key;

    }
}
