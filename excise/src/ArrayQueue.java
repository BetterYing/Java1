public class ArrayQueue {
    private int[] array = new int[10];
    private volatile int size = 0;  //
    // volatile最主要的目的，保证size的可见性
    private int front = 0;
    private int rear = 0;

    public void put (int val) throws InterruptedException {
        if (size == array.length) {
            wait();
        }
        array[rear] = val;
        rear = (rear + 1) % array.length;
        synchronized (this) {
            size++;
        }
        notifyAll();
    }

    public int take () throws InterruptedException {
        if (size == 0) {
            wait();
        }
        int val = array[front];
        front = (front + 1) % array.length;
        synchronized (this) {
            size--;
        }
        notifyAll();
        return val;
    }

    public int size () {
        return size;
    }

    public boolean isEmpty () {
        return size == 0;
    }

}
