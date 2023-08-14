class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0;
        List<List<Integer>> ans = new ArrayList<>();
        while(i<n){
            int j = i+1;
            while(j<n){
                //For the remaining 2 people I want to select,
                //Ill apply 2sum approach with a new target,
                long newTarget = (long)target - (nums[i] + nums[j]);

                int l = j+1;
                int r = n-1;

                while(l<r){
                    long sum =(long) nums[l] + nums[r];

                    if(sum == newTarget){
                        List<Integer> currQuad = new ArrayList<>();

                        currQuad.add(nums[i]);
                        currQuad.add(nums[j]);
                        currQuad.add(nums[l]);
                        currQuad.add(nums[r]);
                        ans.add(currQuad);

                        int prevL = nums[l];
                        while(l<r && nums[l] == prevL) l++;

                        int prevR = nums[r];
                        while(r>l && nums[r] == prevR) r--;

                    }else if(sum < newTarget){
                        int prev = nums[l];
                        while(l<r && nums[l] == prev) l++;
                    }else{
                        int prev = nums[r];
                        while(r>l && nums[r] == prev) r--;
                    }
                }
                int prev = nums[j];
                while(j<n && nums[j] == prev) j++;
            }

            int prev = nums[i];
            while(i<n && nums[i] == prev) i++;
        }
        return ans;
    }
}