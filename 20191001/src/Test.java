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
                // 就把cur1指向的节点插入到新链表的尾部
                if (newHead == null){
                    //新链表是空链表
                    newHead = cur1;
                    newTail = cur1;
                    cur1 = cur1.next;
                } else {
                    //新链表不是空链表
                    newTail.next = cur1;
                    //更新尾部的指向
                    newTail = newTail.next;
                    cur1 = cur1.next;
                }
            } else {
                //就把cur2指向的节点插入到新链表的尾部
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
        //如何判断当前的哪个链表到达尾部，哪个还有剩余。
        if (cur1 == null){
            //cur2还有剩余
            newTail.next = cur2;
        } else {
            //cur1还有剩余
            newTail.next = cur1;
        }
        return newHead;
    }

    public ListNode partition (ListNode pHead,int x){
        if (pHead == null){
            return null;
        }
        if(pHead.next == null){
            //只有一个元素
            return pHead;
        }
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        for(ListNode cur = pHead;cur.next != null;
            cur = cur.next){
            if(cur.val < x) {
                //插入到smallTail之后
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
            } else {
                //插入到bigTail之后
                bigTail.next = new ListNode(cur.val);
                bigTail = bigTail.next;
            }
        }
        smallHead.next = bigHead.next;
        return smallHead.next;
    }
    
    public  ListNode deleteDuplication(ListNode pHead){
        //创建一个新链表用来放置不重复的元素
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        ListNode cur = pHead;
        while (cur != null){
            if (cur.next != null && cur.val == cur.next.val){
                //说明cur指向的位置已经是重复的节点了，继续往后找cur，找到不重复的节点的位置
                //这样做是为了把若干个相同的节点都跳过
                while (cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                //循环结束，cur指向的是这片重复元素的最后一个，再多走一步，cur指向的就是不重复的元素了
                cur = cur.next;
            } else {
                //当前这个节点不是重复的节点，把这个节点插入到新链表中
                newTail.next = new ListNode(cur.val);
                newTail = newTail.next;
                cur = cur.next;
            }
        }
        return newHead;
    }
}
