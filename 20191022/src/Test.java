public class Test {
    public static void main(String[] args){
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0,1);
        myArrayList.add(1,2);
        myArrayList.add(2,3);
        myArrayList.add(3,4);
        myArrayList.display();
        System.out.println(myArrayList.contains(4));
        System.out.println(myArrayList.search(5));
        System.out.println(myArrayList.size());
        myArrayList.clear();
        myArrayList.add(0,11);
        myArrayList.add(1,12);
        myArrayList.add(2,4);
        myArrayList.display();
        myArrayList.remove(4);
        myArrayList.display();
        System.out.println(myArrayList.getPos(1));
    }
}
