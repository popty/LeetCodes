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
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null) return head;
        
        int N = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            N++;
        }
        
        k = k%N;
        if(k == 0) return head;
        
        ListNode prev = null;
        ListNode temp2 = head;
        temp = head;
        
        while(temp != null){
            temp2 = temp.next;
            temp.next = prev;
            prev = temp;
            temp = temp2;
        }
        
        head = prev;
        temp = head;
        while(k-- > 0){
            prev = temp;
            temp = temp.next;
        }
        
        ListNode head2 = temp;
        prev.next = null;
        
        temp = head;
        prev = null;
        ListNode tail = head;
        while(temp!=null){
            temp2  = temp.next;
            temp.next = prev;
            prev = temp;
            temp = temp2;
        }
        
        head = prev;
        
        ListNode tail2 = head2;
        temp = head2;
        prev = null;
        while(temp!=null){
            temp2  = temp.next;
            temp.next = prev;
            prev = temp;
            temp = temp2;
        }
         
        head2 = prev;
        
        tail.next = head2;
        
        return head;
        
    }
}