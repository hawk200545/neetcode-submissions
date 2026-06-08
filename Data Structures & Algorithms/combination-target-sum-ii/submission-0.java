class Solution {
     static List<List<Integer>> res;
        static int[] can;
        static int target;
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            this.res = new ArrayList<>();
            this.target = target;
            this.can = candidates;
            Arrays.sort(this.can);
            gen(0,0, new ArrayList<>());
            return res;
        }
        public static void gen(int i, int sum, List<Integer> curr){
            // System.out.println(i+" " + sum);
            if(sum == target){
                res.add(new ArrayList<>(curr));
                return;
            }
            if(i >= can.length || sum > target) return;
            
            curr.add(can[i]);
            gen(i + 1, sum + can[i], curr);
            curr.remove(curr.size() - 1);

            int next = i + 1;
            while(next < can.length && can[next] == can[i]) next++; 
            gen(next, sum, curr);
        }
}