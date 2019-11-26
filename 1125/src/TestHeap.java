import java.util.Arrays;

public class TestHeap {
    public int[] elem;
    public int usedSize;
    public TestHeap (){
        this.elem = new int[20];
        this.usedSize = 0;
    }

    public void adjustDown(int root,int len) {
        int parent = root;
        int child = 2 * parent + 1;
        while (child < len) {
            if (child + 1 < len && this.elem[child + 1] > this.elem[child]) {
                child = child + 1;
            }
            if (this.elem[child] > this.elem[parent]) {
                swap (child,parent);
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }
    public void swap (int child,int parent) {
        int tmp = this.elem[parent];
        this.elem[parent] = this.elem[child];
        this.elem[child] = tmp;
    }

    public void createHeap (int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        for (int i = (this.usedSize - 1 - 1) / 2; i >= 0; i--) {
            adjustDown(i,this.usedSize - 1);
        }
    }
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }



    public void adjustUp(int child) {
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (this.elem[child] > this.elem[parent]) {
                swap(child,parent);
                child = parent;
                parent = (child - 1) / 2;
            } else {
                break;
            }
        }
    }


    public boolean isFull() {
        if (this.usedSize == this.elem.length) {
            return true;
        }
        return false;
    }

    public void pushHeap(int val) {
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem,this.elem.length * 2);
        }

        this.elem[this.usedSize] = val;
        this.usedSize++;//11
        adjustUp(this.usedSize - 1);
    }

    public boolean isEmpty() {
        return this.usedSize == 0;
    }
    public void popHeap () {
        if (isEmpty()){
            return;
        }
        swap(this.usedSize - 1,0);
        this.usedSize--;
        adjustDown(0,this.usedSize -1 );
    }

    //堆排序
    public void heapSort () {
        adjustDown(0,this.usedSize - 1);
        int end = this.usedSize - 1;
        while (end > 0) {
            swap(end,0);
            adjustDown(0,end);
            end--;
        }
    }
}
