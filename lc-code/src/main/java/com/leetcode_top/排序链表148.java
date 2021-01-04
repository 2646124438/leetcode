package com.leetcode_top;

import com.pojo.ListNode;

public class 排序链表148 {
    public ListNode sortList(ListNode head) {
//        int length = 0;

        return sortHelper(head, null); //　自顶向下进行二分，
    }

    public ListNode sortHelper(ListNode head, ListNode tail){
        if(head==null){
            return null;
        }
        if(head.next == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=tail){
            slow = slow.next;
            fast = fast.next;
            if(fast!=tail){
                fast = fast.next;
            }
        }
        ListNode rightPart = slow;
        return mergeSortTwoListNode(sortHelper(head, rightPart), sortHelper(rightPart, tail));
    }



    public ListNode mergeSortTwoListNode(ListNode l1, ListNode l2){
        ListNode returnNode = new ListNode(0);
        ListNode temp = returnNode;
        while(l1!=null&&l2!=null){
            int l1Val = l1.val;
            int l2Val = l2.val;
            if(l1Val<l2Val){
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }else{
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
        }
        temp.next = l1==null?l2:l1;
        return returnNode.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(1);
        head.next = h1;h1.next = h2; h2.next = h3;
        ListNode result = new 排序链表148().sortList(head);
        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
