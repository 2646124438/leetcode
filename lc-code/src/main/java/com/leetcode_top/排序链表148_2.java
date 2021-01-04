package com.leetcode_top;

import com.pojo.ListNode;

public class 排序链表148_2 {
    //使用自底向上的归并排序方法．
    public ListNode sortList(ListNode head) {
        ListNode curr = head;
        int length = 0;
        while(curr!=null){
            curr = curr.next;
            length++;
        }
//        curr = head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        for(int sublen=1;sublen<length;sublen<<=1){
            ListNode pre = dummyHead;
            curr = dummyHead.next;
            while(curr!=null){
                ListNode head1 = curr;
                for(int i=1;i<sublen&&curr.next!=null;i++){
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for(int i=1;i<sublen&&curr!=null&&curr.next!=null;i++){
                    curr = curr.next;
                }
                if(curr!=null){
                ListNode nextSub = curr.next;
                curr.next = null;
                curr = nextSub;
                }
                pre.next = merge(head1, head2);
                while(pre.next!=null){pre = pre.next;}
            }// while

        }
        return dummyHead.next;
    }

    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead;
        while(head1!=null&&head2!=null){
            if(head1.val<=head2.val){
                temp.next = head1;
                temp = temp.next;
                head1 = head1.next;
            }else if(head1.val>head2.val){
                temp.next = head2;
                temp = temp.next;
                head2 = head2.next;
            }
        }
        temp.next = head1==null?head2:head1;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(1);
        head.next = h1;h1.next = h2; h2.next = h3;
        ListNode result = new 排序链表148_2().sortList(head);
        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
