import java.util.*;

class Solution {
    public static int solve(List<List<Integer>> A) {
    // Write your code here
		//Sorted in asc order on the basis of starting point
		Collections.sort(A,(a,b)->{
			if(a.get(0) == b.get(0)) return a.get(1) - b.get(1);
			return a.get(0)-b.get(0);
		});
		
		int cnt = 0;
		int prevEnd = -1;

		for(List<Integer> currInterval : A){
			int csp = currInterval.get(0);
			int cep = currInterval.get(1);

			if(prevEnd < csp){
				//we are not overlapping
				cnt++;
				prevEnd = cep;
			}else{
				//we are overlapping
				//I cannot keep both intervals,
				// i have to make a choice
				if(cep < prevEnd){
					//choose the current interval over prev
					prevEnd = cep;
				}
			}
		}
		return cnt;
		
	}
}
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            List<Integer> interval = Arrays.asList(a, b);
            A.add(interval);
        }
        int ans = Solution.solve(A);
        System.out.println(ans);
    }
}
