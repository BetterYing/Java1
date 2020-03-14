class LinkedNode {
    int val;
    LinkedNode next;

    LinkedNode(int x) {
        this.val = x;
    }

}


public class RenewLinked {
    //判断是否有环
    public boolean isHasCycle (LinkedNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return false;
        }
        LinkedNode slow = head;
        LinkedNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    //返回链表开始入环的第一个节点
    public LinkedNode detectCycle (LinkedNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        LinkedNode fast = head;
        LinkedNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //分割链表
    public LinkedNode partition(LinkedNode head, int x) {
        if (head == null) {
            return null;
        }
        LinkedNode smallHead = new LinkedNode(0);
        LinkedNode smallTail = smallHead;
        LinkedNode bigHead = new LinkedNode(0);
        LinkedNode bigTail = bigHead;

        while (head != null) {
            LinkedNode next = head.next;
            head.next = null;
            if (head.val < x) {
                smallTail = head;
                head = next;
                smallTail = smallTail.next;
            } else {
                bigTail = head;
                head = next;
                bigTail = bigTail.next;
            }
        }
        smallTail.next = bigHead.next;
        return smallHead.next;
    }

    //相交链表
    public LinkedNode getIntersectionNode(LinkedNode headA, LinkedNode headB) {
        int lenA = 0;
        int lenB = 0;
        LinkedNode pL = headA;
        LinkedNode pS = headB;
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
        if (len < 0) {
            pL = headB;
            pS = headA;
            len = lenB - lenA;
        }
        for (int i = 0; i < len; i++) {
            pL = pL.next;
        }
        while (pS != null && pL != null && pS != pL) {
            pS = pS.next;
            pL = pL.next;
        }
        if (pL == null && pS == null) {
            return null;
        }
        return pL;
    }

    //反转链表
    public LinkedNode reverseList(LinkedNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        LinkedNode prev = null;
        LinkedNode newHead = null;
        while (head != null) {
            LinkedNode next = head.next;
            if (next == null) {
                newHead = head;
            }
            head.next = prev;
            prev = head;
            head = next;
        }
        return newHead;
    }

    //移除链表元素
    public LinkedNode removeElements(LinkedNode head, int val) {
        if (head == null) {
            return null;
        }
        LinkedNode prev = head;
        LinkedNode next = head.next;
        while (next != null) {
            if (next.val == val) {
                prev.next = next.next;
                next = prev.next;
            } else {
                prev = next;
                next = next.next;
            }
        }
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    //回文链表
    public boolean chkPalindrome(LinkedNode head) {
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }
        LinkedNode fast = head;
        LinkedNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //进行反转
        LinkedNode p = slow.next;
        while (p != null) {
            LinkedNode next = p.next;
            p.next = slow;
            slow = p;
            p = next;
            if (p != null) {
                next = p.next;
            }
        }
        //进行判断
        while (head != slow) {
            if (head.val != slow.val) {
                return false;
            }
            if (head.next == slow) {
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    //合并两个链表
    public LinkedNode mergeTwoLists(LinkedNode l1, LinkedNode l2) {
        LinkedNode newHead = new LinkedNode(0);
        LinkedNode tail = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail = l1;
                tail = tail.next;
                l1 = l1.next;
            } else {
                tail = l2;
                tail = tail.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }
        return newHead.next;
    }

    //删除链表中的节点
    public LinkedNode deleteDuplication(LinkedNode head) {
        if (head == null) {
            return null;
        }
        LinkedNode newHead = new LinkedNode(0);
        LinkedNode tail = newHead;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                head = head.next;
                tail.next = head;
            } else {
                tail.next = head;
                tail = tail.next;
                head = head.next;
            }
        }
        return newHead;
    }

    //倒数第k个节点
    public LinkedNode FindKthToTail(LinkedNode head,int k) {
        if (head == null) {
            return null;
        }
        if (k <= 0) {
            return null;
        }
        LinkedNode fast = head;
        LinkedNode slow = head;
        int len = 0;
        while (fast != null) {
            len++;
            fast = fast.next;
        }
        if (len < k) {
            return null;
        }
        fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
