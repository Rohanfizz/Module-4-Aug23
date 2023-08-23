class Solution {

    public boolean kthBitSet(int n,int k){
        return (n & (1<<k)) != 0;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n=nums.length;
        int total = (1<<n) - 1;

        for(int i = 0;i<=total;i++){
            List<Integer> curr = new ArrayList<>();

            for(int bit = 0;bit<n;bit++){
                if(kthBitSet(i,bit)) curr.add(nums[bit]);
            }

            ans.add(curr);
        }
        return ans;
    }
}