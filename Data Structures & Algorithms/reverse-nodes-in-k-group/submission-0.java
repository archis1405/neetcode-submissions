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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
            return head;
        }

        ListNode temp = head;

        for(int i=0 ; i<k ; i++){
            if(temp==null){
                return head;
            }

            temp = temp.next;
        }

        ListNode newHead = reverse(head , temp);

        head.next = reverseKGroup(temp , k);

        return newHead;
    }

    public ListNode reverse(ListNode head , ListNode tail){
        ListNode prev = null;

        while(head!=tail){
            ListNode front = head.next;
            head.next = prev;

            prev = head;
            head = front;
        }

        return prev;
    }
}
