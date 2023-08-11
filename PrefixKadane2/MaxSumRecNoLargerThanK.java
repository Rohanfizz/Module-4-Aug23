import java.util.*;

class Solution {

	public int maxSumAtMostK(int[] arr,int  k){
		TreeSet<Integer> ts = new TreeSet<>();
		ts.add(0);
		int  ans = Integer.MIN_VALUE;
		int pref = 0;

		for(int x: arr){
			pref += x;
			int ideal = pref-k;
			Integer closest = ts.ceiling(ideal);
			if(closest != null){
				ans = Math.max(ans,pref-closest);
			}
			ts.add(pref);
		}
		return ans;
	}
	
    public int maxSumSubmatrix(int[][] arr, int k) {
        //Write code here
		int  ans = Integer.MIN_VALUE;
		int n = arr.length;
		int m = arr[0].length;
		for(int l = 0;l<m;l++){
			int[] prefRow = new int[n];
			for(int r = l;r<m;r++){
				//adding stuff to prefRow Array/Maintaining prefix row
				for(int i = 0;i<n;i++) prefRow[i] += arr[i][r];

				int currAns = maxSumAtMostK(prefRow,k);
				ans= Math.max(ans,currAns);
			}
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        }
        int k;
        k = sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.maxSumSubmatrix(matrix, k));
        sc.close();
    }
}