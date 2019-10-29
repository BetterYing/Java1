public class Test {
    public static void main(String[] args) {
        DoubleListed doubleListed = new DoubleListed();
        doubleListed.addLast(4);
        doubleListed.addLast(2);
        doubleListed.addLast(3);
        doubleListed.addLast(4);
        doubleListed.addLast(4);
        doubleListed.addLast(6);
        doubleListed.addLast(4);
        doubleListed.display();
        //System.out.println(doubleListed.size());
       // System.out.println(doubleListed.contains(6));
        doubleListed.removeAll(4);
        doubleListed.display();

    }
}
