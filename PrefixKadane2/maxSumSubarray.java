import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = input.nextInt();
        }
        Solution ob =new Solution();
        long ans = ob.maxSubarraySum(a,n);
        System.out.println(ans);
    }
}
class Solution{
    public long maxSubarraySum(int arr[],int n){
        //Write code here
		long train = 0;
		long maxi = Integer.MIN_VALUE;

		for(int i = 0;i<n;i++){
			//if the ith person sits with the prev train
			long prev = train + arr[i];
			//if the ith person starts a new train
			long newTrain = arr[i];

			train = Math.max(prev,newTrain);

			//out of all the  trains, max sum subarray sum will be one of the biggest trains
			maxi = Math.max(maxi,train);
			
		}
		return maxi;
    }
}












