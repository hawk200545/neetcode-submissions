class Solution {
    static List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        this.res = new ArrayList<>();
        perm(0,nums);
        return res;
    }
    public static void perm(int idx, int[] nums){
        if(idx == nums.length){
            res.add(Arrays.stream(nums).boxed().toList());
            return;
        }
        int t;
        for(int i = idx;i < nums.length;i++){
            t = nums[i];
            nums[i] = nums[idx];
            nums[idx] = t;
            perm(idx+1, nums);
            t = nums[i];
            nums[i] = nums[idx];
            nums[idx] = t;
        }
        return;
    }
}
