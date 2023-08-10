import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static int maximumSum(int[] arr, int[][] ops) {
		int md = 1000000007;
		int  n = arr.length;
	    int[] contri = new int[n];
		for(int[] op: ops){
			int sp = op[0];
			int ep = op[1];
			contri[sp]++;
			if(ep+1 < n) contri[ep+1]--;
		}
		//prefix array of contri
		for(int i = 1;i<n;i++){
			contri[i] =(contri[i] +  contri[i-1])%md;
		}
		//Now  contri array is having the data regarding in how many ranges
		// does a particular index participate

		//Now i want to map max contributing index -> max value
		// second maxi contri-> second max value......soon
		//for mapping ill sort both the arrays
		Arrays.sort(contri);
		Arrays.sort(arr);
		//Now after sorting in both array's n-1th index, max contri is mapped with max value and so on
		// i just have to calculate the score
		int score = 0;
		for(int i = 0;i<n;i++){
			score =( score + (contri[i] * arr[i])%md)%md;
		}
		return score%md;
    }

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        long m = Long.parseLong(br.readLine().trim());
        int[][] ops = new int[(int)m][2];
        for(int i=0; i<m; i++){
          String inputLine1[] = br.readLine().trim().split(" ");
          ops[i][0]=Integer.parseInt(inputLine1[0]);
          ops[i][1]=Integer.parseInt(inputLine1[1]);
        }
        System.out.println(maximumSum(arr, ops));
	}
}



