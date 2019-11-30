class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Linked {
    private ListNode head = null;
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        while (prev != null) {
            ListNode next = prev.next;
            while (next != null) {
                if (prev.val > next.val) {
                    prev.next = next.next;
                    next.next = prev;
                    prev = prev.next;
                    next = prev.next;
                } else {
                    prev = next;
                    next = next.next;
                }
            }
        }
        return head;
    }



    public void addLast(int elem) {
        ListNode node = new ListNode(elem);
        if (this.head == null) {
            this.head = node;
            return;
        }
        ListNode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        // 循环结束之后, cur 就已经指向最后一个节点了
        // 新节点插入到 cur 之后即可
        cur.next = node;
    }

    public void display() {
        // 打印链表中的所有元素
        for (ListNode cur = head;cur != null;cur = cur.next) {
            System.out.print(cur.val + " ");
        }
        System.out.println();
    }


}

