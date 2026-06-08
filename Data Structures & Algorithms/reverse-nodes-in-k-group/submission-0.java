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
        ListNode dummy = new ListNode(0,head);
        ListNode nodePrev = dummy;
        ListNode curr = head;
        ListNode last = canReverse(curr,k);
        ListNode next = last.next;
        while(true){
            ListNode ref = curr;
            ListNode prev = next;
            for(int i=0;i<k;i++){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp; 
                // System.out.println(prev.val+ " " + curr.val);
            }
            nodePrev.next = prev;
            nodePrev = ref;
            // if(curr != null && prev!= null ) System.out.println("Curr : " + curr.val + " Prev " + prev.val + "Ref : " + ref.val );
            last = canReverse(curr,k);
            if(last == null){
                ref.next = curr;
                break;
            }
            next = last.next;
            // System.out.println("Next Iteration : " + ((last!= null) ? last.val : "null"));
            // printState(dummy.next);
        }
        return dummy.next;
    }
    public ListNode canReverse(ListNode curr, int n){
        while(n > 1 && curr != null ){
            curr = curr.next;
            n--;
        }
        return curr;
    }
    public void printState(ListNode head){
        while(head != null){
            System.out.println(head.val + " ");
            head = head.next;
        }
    }
}