public class Test {
    public static void main(String[] args){
        TestAdd();
        Testremove();
    }
    public static void TestAdd(){
        System.out.println("测试插入");
        SeqList seqList = new SeqList();
        seqList.display();
        seqList.add(0,3);
        seqList.add(3,5);
        seqList.display();
    }

    public static  void Testremove(){
        System.out.println("测试删除");
        SeqList seqList = new SeqList();
        seqList.display();
        seqList.add(0,3);
        seqList.add(3,5);
        seqList.remove(3);
        seqList.display();


    }
}


