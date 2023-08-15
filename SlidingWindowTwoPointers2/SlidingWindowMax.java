import java.util.*;

class Solution{
    static int[] SlidingWindowMaximum(int N, int K, int[] arr){
        // write code here
		ArrayList<Integer> ans = new ArrayList<>();

		Deque<Integer> dq = new ArrayDeque<>();
		//for the first window i have to manually calculate the ans
		//because window length is constant
		int sp =0;
		int ep = 0;
		while(ep<K){
			//add every epth person
			while(dq.size() > 0 && arr[dq.getLast()] < arr[ep]) dq.removeLast();
			dq.addLast(ep);
			ep++;
		}
		ans.add(arr[dq.getFirst()]); // consider the answer for the first window

		//now i can apply sliding window for the rest of the window
		while(ep<N){
			//add the epth person
			while(dq.size() > 0 && arr[dq.getLast()] < arr[ep]) dq.removeLast();
			dq.addLast(ep);
			//remove first if the front person is out of the current window
			while(dq.getFirst() <= sp) dq.removeFirst();
			//consider answer for this window
			ans.add(arr[dq.getFirst()]); 
			//move the window
			sp++; ep++;
		}
		//Arraylist to array for returning
		int[] res = new  int[ans.size()];
		for(int i = 0;i<res.length;i++){
			res[i] = ans.get(i);
		}
		return res;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int nums[]=new int[n];
        for(int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        int[] ans=obj.SlidingWindowMaximum(n,k,nums);
        for(int i=0;i<ans.length;++i){
            System.out.print(ans[i] + " ");
        }
    }
}
