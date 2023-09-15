/*
 Given the head of a singly linked list, return true if it is a palindrome
 or false otherwise.

 Input: head = [1,2,2,1]
 Output: true

 Input: head = [1,2]
 Output: false

 */



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null)
          return false;
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secondhalf=reverse(slow);
        ListNode itr=head;ListNode temp=secondhalf;
        while(temp!=null)
        {
            if(temp.val!=itr.val){
              return false;
            }
            itr=itr.next;
            temp=temp.next;
        }
        slow.next=reverse(secondhalf);
        return true;
    }
    ListNode reverse(ListNode head)
    {
        if(head==null||head.next==null)
          return head;
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null)
        {
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}


