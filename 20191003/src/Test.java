public class Test {
    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
        //分别求两个链表的长度
        int lenA = size(headA);
        int lenB = size(headB);
        //让长的链表先走长度的差值步
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
        //分别让两个链表的节点同时移动，比较节点是否是相同节点
        while(headA != null && headB != null){
            //比较身份的对象（地址）
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
            //此处假设是回文
            return true;
        }
        if (A.next == null){
            //只有一个元素，就是回文
            return true;
        }
        //找中间节点
        int len = size(A);
        int steps = len / 2;
        ListNode B = A;
        for (int i = 0; i < steps; i++) {
            B = B.next;
        }
        //经过画图演示，发现奇数个和偶数个的情况
        
        ListNode prev = null;
        ListNode cur = B;
        while(cur != null){
            ListNode next = cur.next;
            if (next == null){
                //使用B指向新链表的头部
                B = cur;
            }
            cur.next = prev;
            //更新prev，更新cur
            prev = cur;
            cur = next;
        }
        //对比两个链表的内容是否相同
        while(B != null){
            if (A.val != B.val){
                //对应元素不相等，一定不是回文
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
