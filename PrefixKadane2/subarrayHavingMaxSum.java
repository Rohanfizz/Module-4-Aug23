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
		int osp = -1;
		int oep = -1;
		int maxi = Integer.MIN_VALUE;

		int csp = 0;
		int cep = 0;
		int csum = 0;

		for(int i = 0;i<n;i++){
			int newSum = arr[i];
			int prevSum = csum + arr[i];

			if(newSum > prevSum){
				//This is the time to start a new sum/train
				//this means that old sp is no more valid
				csp = i;
				cep = i;
				csum = newSum;
			}else csum = prevSum; // prev is better, no need to update cep and csp
	
			if(csum > maxi){
				maxi = csum;
				osp = csp;
				oep = cep;
			}
			cep++;
		}
		System.out.println(osp +" "+oep);
		return maxi;
		

		
    }
}












