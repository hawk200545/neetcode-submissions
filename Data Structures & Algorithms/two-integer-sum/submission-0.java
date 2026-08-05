class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        hs.put(nums[0],0);
        int[] ans = new int[2];
        for(int i = 1 ;i<nums.length; i++){
            if(hs.containsKey(target-nums[i])) {
                ans[0] = hs.get(target-nums[i]);
                ans[1] = i;
                return ans;
            }
            hs.put(nums[i],i);
        }
        return ans;
    }
}
