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
        int N = 1;
        
        ListNode tail = head;
        while(tail.next!=null){
            N++;
            tail = tail.next;
        }
        
        if(k%N == 0) return head;
        
        tail.next = head;
        int newHeadInd = N - k%N;
        
      
        for(int i = 0; i<newHeadInd; i++){
            tail = tail.next;
        }
        
        head = tail.next;
        tail.next = null;
        
        return head;
        
    }
}