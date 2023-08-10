import java.util.*;

class Solution {
		public int sumOfRange(int[] pref,int sp,int ep){
			if(sp == 0) return pref[ep];
			return pref[ep] - pref[sp-1];//sp-1 because sp is  inclusive, all the people before sp should be subtracted
		}
	//O(N+Q);
	//O(N)
	//Range sum immutable 1D
        public int[] sumQuery(int[] arr, int[][] queries) {
            // Your code here.
			//create prefix sum array
			int n = arr.length;
			int[] pref = new int[n];
			
			int currSum = 0;
			for(int i = 0;i<n;i++){
				currSum += arr[i];
				pref[i] = currSum;
			}

			//i have successfully created prefix sum array,
			//its time to answer every query
			int q = queries.length;
			int[] ans = new int[q];

			for(int i = 0;i<q;i++){
				int sp = queries[i][0];
				int ep = queries[i][1];
				ans[i] = sumOfRange(pref,sp,ep);
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
        int m;
        m = sc.nextInt();
        int[][] ranges = new int[m][2];
        for(int i = 0; i < m; i++) {
            ranges[i][0] = sc.nextInt();
            ranges[i][1] = sc.nextInt();
        }
        Solution Obj = new Solution();
        int[] ans = Obj.sumQuery(arr, ranges);
        for(int i =0; i< ans.length; i++)
            System.out.print(ans[i] + " ");
    }
}