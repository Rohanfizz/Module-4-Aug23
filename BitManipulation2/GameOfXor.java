import java.util.*;
class Solution
{
       static int xorSubarrayXors(int arr[], int n) {
	        //Write code here
		   int ans = 0;
		   for(int i =0;i<n;i++){
			   //if i want to include
			   //the ith person in a subarray
			   int sp = i+1;
			   int ep = n-i;
			   int countOfSubArraysIComesIn = sp * ep;
			   if(countOfSubArraysIComesIn % 2 == 1) ans ^= arr[i];
		   }
		   return ans;
	    }
}
public class Main {

    

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        int ans = Solution.xorSubarrayXors(arr, n);
        System.out.print(ans);
        input.close();
    }
}