public class Test {
    public static void main(String[] args){
        int[] array = {13,8,2,7,10,9,11,15,12,6};
        TestHeap testHeap = new TestHeap();
        testHeap.createHeap(array);
        testHeap.display();


        testHeap.pushHeap(14);
        testHeap.heapSort();
        testHeap.display();

//        testHeap.popHeap();
//        testHeap.display();
//
//        testHeap.heapSort();
//        testHeap.display();
    }
}
