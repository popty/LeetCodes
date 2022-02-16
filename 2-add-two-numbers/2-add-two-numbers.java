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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     
        int len1 = 0, len2 = 0;
        
        ListNode node = l1;
       
        while(node!=null){
            node = node.next;
            len1++;
        }
        
        node = l2;
        
        while(node!=null){
            node= node.next;
            len2++;
        }
        
        if(len1 < len2){
            node = l1;
            l1 = l2;
            l2 = node;
        }
        
        node = l1;
        ListNode node2 = l2;
        int carry = 0;
        ListNode prev = l1;
        
        while(node != null && node2 != null){
            
            int sum = node.val + node2.val + carry;
            
            node.val = sum%10;
            
            carry = sum/10;
            
            prev = node;
            
            node= node.next;
            
            node2 = node2.next;
            
            
        }
        
        
        while(node!=null && carry != 0){
            
            int sum = node.val + carry;
            node.val = sum%10;
            carry = sum/10;
            prev = node;
            node = node.next;
            
        
        }
        
        if(carry != 0){
            ListNode nodeNew = new ListNode();
            nodeNew.val = carry;
            prev.next = nodeNew;
        }
        
        
        return l1;
        
        
        
        
        
        
        
        
    }
}