package com.jiangli.linked_node;

public class two_linknode_sum {
    //给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
    //
    //如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
    //
    //您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    //
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode pos = new ListNode(0);
        ListNode q = null;
        boolean hasOver = true;
        while(l1!=null||l2!=null){
            int l1_val = l1==null?0:l1.val;
            int l2_val = l2==null?0:l2.val;
            int posval = hasOver?pos.val:0;
            int sum = l1_val+l2_val+posval;
            ListNode first = new ListNode(sum%10);
            if(head == null){
                head = first;
                pos = head;
                q = pos;
            }
            if(hasOver) {
                pos = first;
                q.next = pos;
            }else{
                pos.next = first;
            }
            if(sum/10>0){
                ListNode second = new ListNode(sum/10);
                while(pos.next!=null){
                    pos = pos.next;
                }
                pos.next = second;
                pos = pos.next;
                hasOver = true;
            }else{
                while(pos.next!=null){
                    pos = pos.next;
                }
                hasOver = false;
            }
            
            l1 = l1.next;
            l2 = l2.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;
        ListNode head = addTwoNumbers(a1, b1);
        System.out.println("a");

    }
}
