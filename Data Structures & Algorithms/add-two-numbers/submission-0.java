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
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }

        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        int sum = 0;
        int carry = 0;

        while(p1!=null || p2!=null){
            sum = 0;

            if(p1!=null){
                sum = sum+p1.val;
                p1 = p1.next;
            }
            if(p2!=null){
                sum = sum+p2.val;
                p2 = p2.next;
            }

            sum = sum + carry;

            carry = sum / 10;
            sum = sum % 10;

            ListNode newNode = new ListNode(sum);

            temp.next = newNode;

            temp = temp.next;
        }

        if(carry!=0){
            ListNode newNode = new ListNode(carry);

            temp.next = newNode;

            temp = temp.next;
        }

        return dummy.next;
    }
}
