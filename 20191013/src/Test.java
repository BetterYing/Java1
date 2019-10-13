public class Test {
    public static void main(String[] args){
        testAddFirst();
        testAddLast();
        testAddIndex();
        //testContains();
        testClear();
        testRemove();
        testRemoveAll();
    }

    public static void testAddFirst(){
        System.out.println("测试头插");
        DLinkedList node = new DLinkedList();
        node.addFirst(1);
        node.addFirst(2);
        node.addFirst(3);
        node.addFirst(4);
        node.addFirst(5);
        node.display();
    }

    public static void testAddLast(){
        System.out.println("测试尾插");
        DLinkedList node = new DLinkedList();
        node.addLast(1);
        node.addLast(2);
        node.addLast(3);
        node.addLast(4);
        node.addLast(5);
        node.display();
    }

    public static void testAddIndex(){
        System.out.println("测试插入任意位置");
        DLinkedList node = new DLinkedList();
        node.addFirst(1);
        node.addFirst(2);
        node.addFirst(3);
        node.addFirst(4);
        node.addFirst(5);
        node.addIndext(2,6);
        node.display();
    }

//    public static boolean testContains(){
//        System.out.println("测试包含：");
//        DLinkedList node = new DLinkedList();
//        node.addFirst(1);
//        node.addFirst(2);
//        node.addFirst(3);
//        node.addFirst(4);
//        node.addFirst(5);
//        node.contains(2);
//        //node.display();
//
//    }

    public static void testClear(){
        System.out.println("测试清除");
        DLinkedList node = new DLinkedList();
        node.addFirst(1);
        node.addFirst(2);
        node.addFirst(3);
        node.addFirst(4);
        node.addFirst(5);
        node.display();
        node.clear();
        node.display();
    }

    public static void testRemove(){
        System.out.println("测试删除");
        DLinkedList node = new DLinkedList();
        node.addFirst(1);
        node.addFirst(2);
        node.addFirst(3);
        node.addFirst(4);
        node.addFirst(5);
        node.display();
        node.remove(4);
        node.display();
    }

    public static void testRemoveAll(){
        System.out.println("测试删除重复");
        DLinkedList node = new DLinkedList();
        node.addFirst(1);
        node.addFirst(2);
        node.addFirst(3);
        node.addFirst(3);
        node.addFirst(4);
        node.addFirst(5);
        node.display();
        node.removeAll(3);
        node.display();
    }

}
