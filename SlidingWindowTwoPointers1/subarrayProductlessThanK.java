import java.util.*;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //Write code here
		if(k<=1) return 0;
		int n = nums.length;
		int sp = 0;
		int ep = 0;
		int prod = 1;
		int ans = 0;
		
		while(ep<n){
			//introduce
			prod *= nums[ep];
			//shrink till window is invalid
			while(prod >= k){
				prod /= nums[sp];
				sp++;
			}
			//update ans
			ans += (ep-sp+1); //count all the subarrays ending at ep
			//expand
			ep++;
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k;
        k = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.numSubarrayProductLessThanK(arr, k);
        System.out.println(result);
        sc.close();
    }
}