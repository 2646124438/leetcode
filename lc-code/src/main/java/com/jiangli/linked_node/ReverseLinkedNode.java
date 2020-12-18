package main.java.com.jiangli.linked_node;

public class ReverseLinkedNode {
    public ListNode reverse2(ListNode head, int m, int n){
        ListNode dummyHead= new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        for(int i=0;i<m-1;i++){
            pre = pre.next;
        }
        ListNode curr = pre.next;
        for(int i=m;i<n;i++){
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummyHead.next;
    }
}
