class LinkedNode {
    public int data = 0;
    public LinkedNode next = null;

    public LinkedNode(int data) {
        this.data = data;
    }
}

public class LinkedList {
    public LinkedNode head;
    //1.翻转链表
    public LinkedNode reverse(LinkedNode head) {
      if (head == null) {
          return null;
      }
      if (head.next == null) {
          return head;
      }
      LinkedNode prev = null;
      LinkedNode cur = head;
      LinkedNode newHead = null;
      while (cur != null) {
          LinkedNode curNext = cur.next;
          if (curNext == null) {
             newHead = cur;
          }
          cur.next = prev;
          prev = cur;
          cur = curNext;
      }
      return newHead;
    }


    public LinkedNode reverseT(LinkedNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        LinkedNode cur = head;
        LinkedNode prev = null;
        LinkedNode newHead = null;
        while (cur != null) {
            LinkedNode curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }



    //2.合并两个有序链表
    public LinkedNode merge(LinkedNode headA,LinkedNode headB) {
        LinkedNode newHead = new LinkedNode(-1);
        LinkedNode tmp = newHead;
        while(headA != null && headB != null) {
            if (headA.data < headB.data) {
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            } else {
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if (headA != null) {
            tmp.next = headA;
        }
        if (headB != null) {
            tmp.next = headB;
        }
        return newHead.next;
    }
    //3.返回中间节点
    public LinkedNode middle(){
        LinkedNode fast = head;
        LinkedNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //4.找到倒数第k个节点
    public LinkedNode findKth(LinkedNode head,int k) {
        if(head == null) {
            return null;
        }
        if (k <= 0) {
            return null;
        }
        LinkedNode fast = head;
        LinkedNode slow = head;
        while (k - 1 > 0) {
            if (fast.next != null) {
                fast = fast.next;
                k--;
            } else {
                return null;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    //5.以x为基准分隔链表
    public LinkedNode partition(LinkedNode head,int x) {
        LinkedNode smallHead = new LinkedNode(-1);
        LinkedNode smallTail = smallHead;
        LinkedNode bigHead = new LinkedNode(-1);
        LinkedNode bigTail = bigHead;
        LinkedNode cur = head;
        while (cur != null) {
            LinkedNode curNext = cur.next;
            cur.next = null;
            if (cur.data < x) {
                smallTail.next = cur;
                cur = curNext;
                smallTail = smallTail.next;
            } else {
                bigTail.next = cur;
                cur = curNext;
                bigTail = bigTail.next;
            }
        }
        smallTail.next = bigHead.next;
        return smallHead.next;
    }

    //6.判断链表是否带环
    public boolean hasCycle (LinkedNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return false;
        }
        LinkedNode fast = head;
        LinkedNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    //7.相交链表
    public LinkedNode getIntersectionNode(LinkedNode headA,LinkedNode headB) {
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
        while (pL != null && pS != null && pL != pS) {
            pL = pL.next;
            pS = pS.next;
        }
        if (pL == null || pS == null) {
            return null;
        }
        return pL;
    }
    //8.移除链表元素
    public LinkedNode remove(LinkedNode head,int val) {
        if (head == null) {
            return null;
        }
        LinkedNode prev = head;
        LinkedNode cur = head.next;
        //先处理非头节点
        while (cur != null) {
            if (cur.data == val) {
                prev.next = cur.next;
                cur = prev.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        //处理头节点
        if (head.data == val) {
            head = head.next;
        }
        return head;
    }

    //9.回文链表
    public boolean chkPalindrome(LinkedNode head) {
        if (head == null) {
            return false;
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
        //翻转
        LinkedNode p = slow.next;
        while (p != null) {
            LinkedNode pNext = p.next;
            p.next = slow;
            slow = p;
            p = pNext;
            if (p != null) {
                pNext = p.next;
            }
        }
        //开始判断
        while (head != slow) {
            if (head.data != slow.data) {
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
    //10.删除链表中的节点
    public LinkedNode delect(LinkedNode head) {
        if (head == null) {
            return null;
        }
        LinkedNode cur = head;
        LinkedNode newHead = new LinkedNode(-1);
        LinkedNode tmp = newHead;
        while (cur != null) {
            if (cur.next != null && cur.data == cur.next.data) {
                while (cur.next != null && cur.data == cur.next.data){
                    cur = cur.next;
                }
                cur = cur.next;
                tmp.next = cur;
            } else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        return newHead;
    }
    //11.给定一个链表，返回链表开始入环的第一个节点
    public LinkedNode detectCycle(LinkedNode head) {
        LinkedNode fast = head;
        LinkedNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
