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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode curr = null;
        int n = lists.length;
        for(int i = 0;i<n;i++) curr = merge2List(curr,lists[i]);
        return curr;
    }
    public ListNode merge2List(ListNode list1, ListNode list2){
        if(list1 == null) return list2;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(list1 != null && list2!= null){
            // System.out.println(list1.val + " " + list2.val);
            if(list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = list1 != null ? list1 : list2;
        return dummy.next;
    }
}