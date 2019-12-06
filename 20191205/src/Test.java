public class Test {
    public static void main(String[] args){
        HashBuck hashBuck = new HashBuck();
        hashBuck.put(1,66);
        hashBuck.put(11,86);
        hashBuck.put(4,400);
        hashBuck.put(26,900);
        hashBuck.put(21,8888);

        int ret = hashBuck.get(21);
        System.out.println(ret);

    }
}
