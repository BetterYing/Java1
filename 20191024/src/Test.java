public class Test {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(3);
        linkedList.addLast(2);
        linkedList.addLast(1);
        linkedList.display();
        System.out.println(linkedList.chkPalindrome());

    }
    public static Node getIntersectionNode(Node headA,Node headB){
        int lenA = 0;
        int lenB = 0;
        Node pL = headA;//长的
        Node pS = headB;//短的
        while (pL != null) {
            lenA++;
            pL = pL.next;
        }
        while (pS != null) {
            lenB++;
            pS = pS.next;
        }
        pL = headA;
        pS = headB;
        int len = lenA - lenB;
        if(len < 0) {
            pL = headB;
            pS = headA;
            len = lenB-lenA;
        }


        //pL肯定指向最长的单链表
        //pS肯定指向最短的单链表
        //len  肯定是一个正数

        for (int i = 0; i < len; i++) {
            pL = pL.next;
        }
        //pL和pS此时已经在同一期起跑线上了
        //可以一人一步走

        while (pL != null && pS != null && pL != pS) {
            pL = pL.next;
            pS = pS.next;
        }
        if (pL == null || pS == null){
            return null;
        }
        return  pL;
    }
}
