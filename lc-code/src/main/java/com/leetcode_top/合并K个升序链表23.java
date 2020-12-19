package com.leetcode_top;


import com.pojo.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 合并K个升序链表23 {
    public ListNode mergeKLists(ListNode[] lists) {
        //分治思想
        ListNode head = new ListNode(0);
        return mergeHelper(lists, 0, lists.length-1);
    }

    public ListNode mergeHelper(ListNode[] listNodes, int start, int end){
        if(start<end) {
            int mid = (start + end) / 2;
            return mergeTwo(mergeHelper(listNodes, start, mid), mergeHelper(listNodes, mid + 1, end));
        }
        if(start==end) {
            return listNodes[start];
        }
        return null;
    }

    public ListNode mergeTwo(ListNode l1, ListNode l2){
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(t1!=null&&t2!=null){
            if(t1.val<t2.val){
                curr.next = new ListNode(t1.val);
                t1 = t1.next;
            }else{
                curr.next = new ListNode(t2.val);
                t2 = t2.next;
            }
            curr = curr.next;
        }
        curr.next = t1==null?t2:t1;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode h1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode h2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode h3 = new ListNode(2, new ListNode(6));
        lists[0] = h1;
        lists[1] = h2;
        lists[2] = h3;
        new 合并K个升序链表23().mergeKLists(lists);
    }

}

