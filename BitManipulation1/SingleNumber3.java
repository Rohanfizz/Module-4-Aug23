import java.util.*;

class Solution {
	public boolean checkKthBitSet(int  n,int k){
		return (n & (1<<k)) != 0;
	}
    public int[] singleNumber3(int n, int[] nums) {
        // write code here
		int xorOfAll = 0;
		for(int i = 0;i<n;i++){
			xorOfAll ^= nums[i];
		}
		//xorOfAll is having a^b
		//the kth bit which is set in xorOfAll, that is the bit a and b are diff
		int k= 0;
		while(checkKthBitSet(xorOfAll,k) == false) k++;
		//ill diff everbody on the basis of 1th bit
		int kthBitSet =0;
		int kthBitUnset =0;
		for(int i =0;i<n;i++){
			if(checkKthBitSet(nums[i],k)){
				//add this number in kthbitsetGroup
				kthBitSet ^= nums[i];
			}else{
				//add this number in kthBitUnsetgroup
				kthBitUnset ^= nums[i];
			}
		}

		int[] res = new int[2];
		res[0] = Math.min(kthBitSet,kthBitUnset);
		res[1] = Math.max(kthBitSet,kthBitUnset);
		return res; 
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        Solution Obj = new Solution();
        scn.close();
        int[] ans = Obj.singleNumber3(n, arr);
        System.out.print(ans[0] + " " + ans[1]);
    }
}