import java.util.*;

class Solution {
    public int MaxSum(int[] arr, int n) {
        // Write your code here
		int total = 0;

		//max sum subarray
		int maxTrain = 0;
		int maxi = Integer.MIN_VALUE;

		//min sum subarray
		int minTrain = 0;
		int mini = Integer.MAX_VALUE;

		for(int i = 0;i<n;i++){
			total+=arr[i];

			//calc maxsumsubarray
			maxTrain = Math.max( maxTrain + arr[i] , arr[i] );//choose among prev train and new train
			maxi = Math.max(maxi,maxTrain);

			//calc minsubsubarray
			minTrain = Math.min(minTrain + arr[i],arr[i]);
			mini = Math.min(mini,minTrain);
		}
		if(total==mini) return maxi;//all -ve values
		return Math.max( maxi , total-mini );
		//total-mini represents the answer to the wrap around case
		//other edge cases are handled by maxi
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
	    Solution Obj = new Solution();
        int ans = Obj.MaxSum(arr, n);
        System.out.println(ans);
    }
}