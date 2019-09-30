public class SeqList {
    private int[] data = new int[10];
    private int size = 0;
    public void display(){
        System.out.print("[");
        for(int i = 0;i < size;i++){
            System.out.print(data[i]);
            if (i != size - 1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public void add(int pos,int elem){
        if(pos > data.length || pos < 0){
            return;
        }
        if(size >= data.length){
            realloc();
        }
        if(pos == size){
            data[pos] = elem;
            size++;
        } else {
            for(int i = size;i > pos;i--){
                data[i] = data[i - 1];
            }
            data[pos] = elem;
            size++;
        }
    }
  
    private void realloc(){
        int[] newData = new int[this.data.length * 2];
        for(int i = 0;i < this.data.length;i++){
            newData[i] = this.data[i];
        }
        this.data = newData;
    }
    public boolean contains(int toFind){
        return this.search(toFind) != -1;
    }

    public int search(int toFind){
        for(int i = 0;i < this.size;i++){
            if(this.data[i] == toFind){
                return i;
            }
        }
        return -1;
    }

    public int getPos(int pos){
        return this.data[pos];
    }
    public void setPos(int pos,int elem){
        this.data[pos] = elem;
    }

    public void remove(int toRemove){
        int pos = search(toRemove);
        if(pos == -1){
            return;
        }
        if(pos == this.size - 1){
            this.size--;
            return;
        }
        for(int i = pos;i < this.size - 1;i++){
            this.data[i] = this.data[i+1];
        }
        this.size--;
    }
    public int size(){
        return this.size;
    }
    public void clear(){
        this.size = 0;
        this.data = new int[10];
    }
}
