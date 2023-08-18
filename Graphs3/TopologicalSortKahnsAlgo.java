import java.util.*;

class Solution {
 
    @SuppressWarnings("unchecked")
    
    public int[] canFinish(int n, int[][] prerequisites) {
    //Write your code here
		ArrayList<ArrayList<Integer>> graph = new  ArrayList<>();

		for(int i = 0;i<n;i++){
			graph.add(new ArrayList<>());
		}

		int[] indegree= new  int[n];
		
		for(int[] edge: prerequisites){
			int ai = edge[0];
			int bi = edge[1];

			// bi -> ai
			indegree[ai]++;
			graph.get(bi).add(ai);
		}

		ArrayList<Integer> topo = new ArrayList<>();
		
		Queue<Integer> q = new LinkedList<>();

		//Add all the nodes with indegree 0 to the queue
		for(int i = 0;i<n;i++){
			if(indegree[i] == 0) q.add(i);
		}

		//bfs
		while(q.size() > 0){
			int curr = q.remove();
			
			topo.add(curr);
			
			//I will reduce the indegrees of all those who are dependant on me
			for(int nbr: graph.get(curr)){
				indegree[nbr]--;
				if(indegree[nbr] == 0){
					//nbr is ready to be executed
					q.add(nbr);
				}
			}
		}
		//Directed Graph is having a cycle, hence topo order is not possible
		if(topo.size() < n) return new int[0];

		//convert topo arraylist to array
		int[] res = new int[n];
		for(int i = 0;i<n;i++) res[i] = topo.get(i);
		return res;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int prerequisites[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                prerequisites[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        int []ans=Obj.canFinish(N,prerequisites);
        if(ans.length==0)
            System.out.println(-1);
        else{
            for(int i=0; i<ans.length; i++){
                System.out.print(ans[i]+" ");
            }

            System.out.println("");
        }

    }
}