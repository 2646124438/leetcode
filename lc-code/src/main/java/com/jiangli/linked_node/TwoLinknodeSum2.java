package com.jiangli.linked_node;
import java.util.Stack;

public class TwoLinknodeSum2 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode result = new ListNode(0);
        ListNode temp = result;
        Stack<Integer> stack1 = load2Stack(l1);
        Stack<Integer> stack2 = load2Stack(l2);
        Stack<Integer> resultStack = new Stack<Integer>();
        int pre = 0;
        while(!stack1.isEmpty()||!stack2.isEmpty()||pre>0){
            int num1 = stack1.isEmpty()?0:stack1.pop();
            int num2 = stack2.isEmpty()?0:stack2.pop();
            int numSum = num1+num2+pre;
            pre = numSum/10;
            if(numSum<10){
                resultStack.push(numSum);
            }else{
                resultStack.push(numSum%10);
            }
        }
        while(!resultStack.isEmpty()){
            temp.next = new ListNode(resultStack.pop());
            temp = temp.next;
        }
        return result.next;
    }

    public Stack<Integer> load2Stack(ListNode l){
        Stack<Integer> s1 = new Stack<Integer>();
        while(l!=null){
            s1.push(l.val);
            l= l.next;
        }
        return s1;
    }
}
