/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = len(headA);
        int lenB = len(headB);
        
        if(lenA < lenB){
            ListNode temp = headA;
            headA = headB;
            headB = temp;
            int templen = lenA;
            lenA = lenB;
            lenB = templen;
        }
        
        int lenDiff = lenA - lenB;
        
        ListNode tempA = headA;
        ListNode tempB = headB;
        
        while(lenDiff-->0){
            tempA = tempA.next;
        }
        
        while(tempA!=null && tempB!=null){
            if(tempA == tempB) return tempA;
            tempA = tempA.next;
            tempB = tempB.next;
        }
        
        return null;
    }
    
    public int len(ListNode head){
        int count = 0;
        while(head!=null){
            head = head.next;
            count++;
        }
        return count;
    }
}