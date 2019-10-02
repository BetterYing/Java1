public class Test {

    public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode newHead = null;
        ListNode newTail = null;
        while (cur1 != null && cur2 != null){
            if (cur1.val < cur2.val){
                if (newHead == null){
                    newHead = cur1;
                    newTail = cur1;
                    cur1 = cur1.next;
                } else {
                    newTail.next = cur1;
                    newTail = newTail.next;
                    cur1 = cur1.next;
                }
            } else {
                if (newHead == null){
                    newHead = cur2;
                    newTail = cur2;
                    cur2 = cur2.next;
                } else {
                    newTail.next = cur2;
                    newTail = newTail.next;
                    cur2 = cur2.next;
                }
            }
        }
        if (cur1 == null){
            newTail.next = cur2;
        } else {
            newTail.next = cur1;
        }
        return newHead;
    }

    public ListNode partition (ListNode pHead,int x){
        if (pHead == null){
            return null;
        }
        if(pHead.next == null){
            return pHead;
        }
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        for(ListNode cur = pHead;cur.next != null;
            cur = cur.next){
            if(cur.val < x) {
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
            } else {
                bigTail.next = new ListNode(cur.val);
                bigTail = bigTail.next;
            }
        }
        smallHead.next = bigHead.next;
        return smallHead.next;
    }
    public  ListNode deleteDuplication(ListNode pHead){
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;

        ListNode cur = pHead;
        while (cur != null){
            if (cur.next != null && cur.val == cur.next.val){
                while (cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                newTail.next = new ListNode(cur.val);
                newTail = newTail.next;
                cur = cur.next;
            }
        }
        return newHead;
    }


}
