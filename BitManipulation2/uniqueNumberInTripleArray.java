import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
	public static boolean currBitSet(int n,int k){
		return (n & (1<<k)) != 0;
	}
    public static int singleNumber(int[] nums) {
    // Your code here
		int[] bits = new int[32];
		for(int num: nums){
			int currBit = 0;
			while(currBit < 32 ){
				if(currBitSet(num,currBit)) bits[currBit]++;
				currBit++;
			}
		}

		int ans = 0;
		int pow = 1;
		for(int bit = 0;bit<32;bit++){
			if(bits[bit] % 3 != 0){
				ans += pow;
				// ans += (1<<bit);
			}
			pow *= 2;
		}
		return ans;
}
}
public class Main {
  public static void main (String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(Solution.singleNumber(nums));
	}
}