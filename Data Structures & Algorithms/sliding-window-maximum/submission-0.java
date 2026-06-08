class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1]; 
        LinkedList<Integer> lis = new LinkedList<>();
        for(int i=0;i<n;i++){
            while(!lis.isEmpty() && lis.getFirst() < i-(k-1)) lis.removeFirst();
            while(!lis.isEmpty() && nums[lis.getLast()] < nums[i] ) lis.removeLast();
            lis.add(i);
            if(i>=(k-1))res[i-(k-1)] = nums[lis.getFirst()]; 
        }
        return res;
    }
}