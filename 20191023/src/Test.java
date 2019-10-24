public class Test {
    public static void main(String[] args){
        //testAddFirst();
        //testAddLast();
        //testAddIndex();
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(7);
        linkedList.addFirst(8);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addFirst(5);
        linkedList.display();
//        Node node = linkedList.reverseList();
//        linkedList.display2(node);
//        Node node1= linkedList.middleNode();
//        System.out.println(node1.data);
//
//        Node node = linkedList.middleNode2();
//        System.out.println(node.data);

//
        linkedList.partition(4);
        linkedList.display();


    }
    public static void testAddFirst(){
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addFirst(5);
        linkedList.display();
    }

    public static void testAddLast(){
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.display();
    }

    public static void testAddIndex(){
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addFirst(5);
        linkedList.addIndex(2,6);
        linkedList.display();
    }

}
