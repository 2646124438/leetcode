package com.jiangli.leetcode.top100;

public class ReverseLinked2 {
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

    public void reverse(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
    }

    public ListNode reserverCurr(ListNode head){
        if(head.next==null)
            return head;
        ListNode nextNode = head.next;
        ListNode result = reserverCurr(nextNode);
        nextNode.next = head;
        head.next = null;
        return result;

    }

    public ListNode reverseBetween(ListNode head, int m, int n){
        int step = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode g = dummyHead;
        ListNode p = dummyHead.next;
        while(step<m-1){
            g = g.next;
            p = p.next;
            step++;
        }
        for(int i=0;i<n-m;i++){
            ListNode temp = p.next;
            p.next = p.next.next;
            temp.next = g.next;
            g.next = temp;
        }
        return dummyHead.next;
    }
}
