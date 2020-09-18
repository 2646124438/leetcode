package com.jiangli.linked_node;


public class linked_reverse {
    //翻转链表     定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
    /**
     * Definition for singly-linked list.*/
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    // 此种方法是利用新空间,其实可以就考虑栈操作就好.
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        ListNode result = new ListNode(head.val);
        while(q!=null){
            ListNode temp = new ListNode(q.val);
            temp.next = result;
            p = p.next;
            q = q.next;
            result = temp;
        }
        return result;
    }

    // 递归写法
    public ListNode reverseListRecur(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode nextNode = head.next;
        ListNode reverseResult = reverseListRecur(nextNode);
        nextNode.next = head;
        head.next = null;
        return reverseResult;
    }

}
