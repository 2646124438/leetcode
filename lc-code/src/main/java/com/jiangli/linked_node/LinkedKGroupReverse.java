package main.java.com.jiangli.linked_node;

public class LinkedKGroupReverse {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null||k==0) return head;
        int total = 1;
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode pre = dum;
        ListNode end = dum;
        while(end.next!=null){
            for(int i=0;i<k&&end!=null;i++) {
                end = end.next;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dum.next;
    }

    public ListNode reverse(ListNode head){
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

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;b.next = c; c.next=d; d.next = e;
        new LinkedKGroupReverse().reverseKGroup(a, 2);

    }
}
