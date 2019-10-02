public class Demon {
    public ListNode  reverseList(ListNode head){
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        ListNode newHead = null;
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null){
            ListNode next = cur.next;
            if (next == null){
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return newHead;
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode node = head.next;
        while (node != null) {
            if (node.val == val){
                prev.next = node.next;
                node = prev.next;  
            } else {
                prev = node;
                node = node.next;
            }
            
        }
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    public ListNode middleNode(ListNode head){
        int steps = size(head) / 2;
        ListNode cur = head;
        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }
        return cur;
    }
    public ListNode FindKthToTail(ListNode head,int k){
        int len = size(head);
        if (head == null || k <= 0 || k > len){
            return null;
        }
        int offset = len - k;
        ListNode cur = head;
        for (int i = 0; i < offset; i++) {
            cur = cur.next;
        }
        return cur;
    }


    public int size(ListNode head){
        int size = 0;
        for (ListNode cur = head;cur != null;cur = cur.next){
            size++;
        }
        return size;
    }

}
