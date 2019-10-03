public class Test {
    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
        int lenA = size(headA);
        int lenB = size(headB);
        if (lenA > lenB){
            int offset = lenA - lenB;
            for (int i = 0; i < offset; i++) {
                headA = headA.next;
            }
        } else {
            int offset = lenB - lenA;
            for (int i = 0; i < offset; i++) {
                headB = headB.next;
            }
        }
        while(headA != null && headB != null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public boolean chkPalindrome(ListNode A){
        if (A == null){
            return true;
        }
        if (A.next == null){
            return true;
        }
        int len = size(A);
        int steps = len / 2;
        ListNode B = A;
        for (int i = 0; i < steps; i++) {
            B = B.next;
        }
        ListNode prev = null;
        ListNode cur = B;
        while(cur != null){
            ListNode next = cur.next;
            if (next == null){
                B = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        while(B != null){
            if (A.val != B.val){
                return false;
            }
            A = A.next;
            B = B.next;
        }
        return true;
    }


    public int size(ListNode head){
        int size = 0;
        for(ListNode cur = head;cur != null;cur = cur.next){
            size++;
        }
        return size;
    }


}
