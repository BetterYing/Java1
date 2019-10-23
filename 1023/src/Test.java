public class Test {
    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();

        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(6);
        linkedList.addIndex(0,17);
        linkedList.addIndex(7,27);
        linkedList.addIndex(2,7);
        linkedList.display();
        System.out.println(linkedList.contains(5));
        linkedList.remove(17);
        linkedList.remove(27);
        linkedList.remove(7);
        linkedList.display();
        linkedList.addIndex(2,2);
        linkedList.addIndex(0,2);
        linkedList.addIndex(8,2);
        linkedList.display();
        linkedList.removeAllKey(2);
        linkedList.display();
        linkedList.clear();
    }
}
