import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static int[] twoSum(int[] A, int target) {
       // Your code here
		int l = 0;
		int r = A.length-1;
		while(l<r){
			int  sum = A[l] + A[r];

			if(sum == target){
				int[] res = new int[2];
				res[0] = l+1;
				res[1] = r+1;
				return res;
			}else if(sum > target){
				r--;
			}else{
				l++;
			}
		}
		//dummy return
		return new int[0];
    }
	
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        int m = Integer.parseInt(br.readLine().trim());
        int[] ans = (twoSum(arr, m));
        System.out.println(ans[0] + " " + ans[1]);
	}
}



