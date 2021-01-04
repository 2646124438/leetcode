package com.leetcode_top;

import com.pojo.ListNode;

public class 回文链表234 {
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        ListNode halfNode = endOfHalf(head);
        ListNode reverseHalfHeadNode = reverseList(halfNode.next);
        ListNode leftHalfHead = head;
        while(reverseHalfHeadNode!=null){
            if(leftHalfHead.val!=reverseHalfHeadNode.val){
                return false;
            }else{
                leftHalfHead = leftHalfHead.next;
                reverseHalfHeadNode = reverseHalfHeadNode.next;
            }
        }
        return true;
    }

    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    public ListNode endOfHalf(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode h2 = new ListNode(0);
        head.next = h2;
        new 回文链表234().isPalindrome(head);
    }
}
