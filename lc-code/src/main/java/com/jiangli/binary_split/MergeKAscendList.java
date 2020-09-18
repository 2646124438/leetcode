package com.jiangli.binary_split;

public class MergeKAscendList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode();
        if(lists.length==0) return null;
        int first=0;
        while(first<=lists.length-1){
            if(lists[first]!=null) {
                result = lists[first];
                break;
            }
            first++;
        }
        if(first==lists.length)return null;
        for(int i=first+1;i<lists.length;i++){
            if(lists[i]==null) continue;
            result = merge2ListNode(result, lists[i]);
        }
        return result;
    }

    private ListNode merge2ListNode(ListNode n1, ListNode n2){
        ListNode resl = new ListNode();
        ListNode temp = resl;
        while(n1!=null&&n2!=null){
            if(n1.val<n2.val){
                temp.next = n1;
                temp = temp.next;
                n1 = n1.next;
            }else{
                temp.next = n2;
                temp = temp.next;
                n2 = n2.next;
            }
            if(n1==null){
                temp.next = n2;
            }else if(n2==null){
                temp.next = n1;
            }
        }
        return resl.next;
    }

    public static void main(String[] args) {
        ListNode[] a = new ListNode[2];
        a[0] = null;
        a[1] = new ListNode(1);
        new MergeKAscendList().mergeKLists(a);
    }
}
