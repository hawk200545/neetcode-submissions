class Solution {
    static List<List<Integer>> res;
    static int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.res = new ArrayList<>();
        this.nums = nums;
        Arrays.sort(nums);
        subset(0,new ArrayList<>());
        return res;
    }
    public static void subset(int idx, List<Integer> curr){
        if(idx == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[idx]);
        subset(idx+1, curr);
        int next = idx+1;
        if(!curr.isEmpty()) while(next < nums.length && nums[next] == nums[next-1]) next++; 
        curr.remove(curr.size()-1);
        subset(next,curr);
        return;
    }
}
