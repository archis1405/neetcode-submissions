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

    public class CustomComparator implements Comparator<ListNode>{
        public int compare(ListNode a , ListNode b){
            return a.val - b.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new CustomComparator());

        for(int i=0 ; i<lists.length ; i++){
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(!pq.isEmpty()){
            ListNode curr = pq.remove();

            temp.next = curr;

            temp = temp.next;

            if(curr.next!=null){
                curr = curr.next;
                pq.add(curr);
            }
        }

        return dummy.next;
    }
}
