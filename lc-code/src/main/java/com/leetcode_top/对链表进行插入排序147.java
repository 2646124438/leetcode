package com.leetcode_top;

import com.pojo.ListNode;

public class 对链表进行插入排序147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode curr = head.next;
        ListNode sorted = head;
        ListNode pos = head;
        ListNode pre = dummyHead;
        while(curr!=null){
            if(curr.val<sorted.val){
                while(pos.val<=curr.val){
                    pre = pre.next;
                    pos = pos.next;
                }
                ListNode temp = curr.next;
                pre.next = curr;
                curr.next = pos;
                curr = temp;
                sorted.next = curr;
                pos = dummyHead.next;
                pre = dummyHead;
            }else{
                curr = curr.next;
                sorted = sorted.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(1);
        head.next = h1;h1.next = h2; h2.next = h3;
        new 对链表进行插入排序147().insertionSortList(head);
    }
}
