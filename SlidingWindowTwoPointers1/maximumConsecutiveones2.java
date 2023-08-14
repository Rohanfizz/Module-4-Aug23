import java.util.*;

class Solution {
    static int maxOne(int arr[], int n,int k){
        //Write your code here

		int sp = 0;
		int ep = 0;
		int ans =  0;

		int numZeroes =  0;

		while(ep<n){
			//Step 1: introduce
			if(arr[ep] == 0) numZeroes++;
			//Now due to addition of a new member inside window
			//it is possible that the window have become invalid
			
			//Step 2: shrink until invald
			while(numZeroes > k){
				if(arr[sp] == 0) numZeroes--;
				sp++;
			}

			//On this line of code, window will always be valid
			//Step 3: Update ans
			ans = Math.max(ans, ep-sp+1 );
			//Step 4: Expand
			ep++;
		}
		return ans;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.maxOne(array,n,k));
    }
}