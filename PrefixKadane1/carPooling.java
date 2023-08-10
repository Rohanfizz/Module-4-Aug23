
 import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	   public static void main(String args[]) {
		  
		        Scanner sc = new Scanner(System.in);
		        int n = sc.nextInt();
		        int[][] trips = new int[n][3];
		        for (int i = 0; i < n; i++) {
		            for (int j = 0; j < 3; j++) {
		                trips[i][j] = sc.nextInt();
		            }
		        }
		        int k = sc.nextInt();
	           
	        Solution obj= new Solution();
	        System.out.println(obj.carPooling(trips,k));
	    }
}
class Solution{
  
    public boolean carPooling(int[][] trips, int capacity) {
	//your code
		int[] pref = new int[1001];
		for(int[] trip: trips){
			int numPass = trip[0];
			int sp = trip[1];
			int ep = trip[2];

			pref[sp] += numPass;//start a sum
			pref[ep] -= numPass;//limit the sum
		}

		//now we will take the prefix sum of the array
		for(int i = 1;i<1001;i++){
			pref[i] += pref[i-1];//creating prefix sum array without extra space
		}
		//we want to check if there are more people than capacity on any station
		for(int i = 0;i<1001;i++){
			if(pref[i] > capacity) return false;
		}

		return true;
	}
}










