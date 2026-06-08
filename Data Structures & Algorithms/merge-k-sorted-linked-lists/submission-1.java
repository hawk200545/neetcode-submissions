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
class ListNodeComparator implements Comparator<ListNode> {
    @Override
    public int compare(ListNode a, ListNode b) {
        if (a == null && b == null) return 0;
        if (a == null) return -1;
        if (b == null) return 1;
        return a.val - b.val;   
        
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int n = lists.length;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new ListNodeComparator());
        int minIdx = 0;
        int minVal = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            while (lists[i] != null){
                minHeap.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }
        while(!minHeap.isEmpty()){
            curr.next = minHeap.poll();
            curr = curr.next;
            curr.next = null;
        }

        return dummy.next;
    }
}