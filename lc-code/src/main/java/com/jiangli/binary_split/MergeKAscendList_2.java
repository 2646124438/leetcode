package com.jiangli.binary_split;

public class MergeKAscendList_2 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length-1);
    }

    public ListNode merge(ListNode[] lists, int begin, int end){
        if(begin==end) return lists[begin];
        if(begin>end) return null;
        int mid = (begin+end)>>1;
        return mergeTwoLists(merge(lists, begin, mid), merge(lists, mid+1, end));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if(list1==null||list2==null) return list1!=null?list1:list2;
        ListNode head = new ListNode();
        ListNode temp = head;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        temp.next = list1==null?list2:list1;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode[] a = new ListNode[2];
        a[0] = null;
        a[1] = new ListNode(1);
        new MergeKAscendList_2().mergeKLists(a);
    }
}
