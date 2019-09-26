public class Test {
    public static void main(String[] args){
        testAddFirst();
        testAddLast();


    }
    public static void testAddFirst(){
        System.out.println("测试头插");
        LinkedList node = new LinkedList();
        node.addFirst(1);
        node.addFirst(2);
        node.addFirst(3);
        node.addFirst(4);
        node.addFirst(5);
        node.display();
    }
    public static void testAddLast(){
        System.out.println("测试尾插");
        LinkedList node = new LinkedList();
        node.addLast(1);
        node.addLast(2);
        node.addLast(3);
        node.addLast(4);
        node.addLast(5);
        node.display();
    }
//    public static void TestAddIndex(){
//        System.out.println("测试插入任何位置");
//        LinkedList node = new LinkedList();
//        node.
//
//
//
//    }

}
