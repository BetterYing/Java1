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



}
