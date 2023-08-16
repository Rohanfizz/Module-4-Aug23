import java.io.*;
import java.util.*;

class Solution {

	public static boolean bfs(boolean[] visited,ArrayList<ArrayList<Integer>> graph,int  src){
		Queue<Integer> q = new LinkedList<>();
		q.add(src);

		while(q.size() > 0){
			//remove
			int currNode = q.remove();
			//mark
			if(visited[currNode]) return true;//this person is already visited, we are visiting this person for the second time, hence cycle detected
			visited[currNode] = true;
			//work
			//------
			//add unvisited nbrs
			for(int nbr: graph.get(currNode)){
				if(!visited[nbr]) q.add(nbr);
			}
		}
		return false;
	}
	
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> graph) {
       // Your code here
		boolean[] visited = new boolean[V];
		for(int i =0;i<V;i++){
			//ill apply bfs with ith node as source if that node is not visited in any prev bfs call
			if(visited[i]==false){
				boolean cycleFound = bfs(visited,graph,i);
				if(cycleFound) return true;
			}	
		}
		return false;
    }
}

public class Main{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N, E;
        N = sc.nextInt();
        E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<N; i++) adj.add(i, new ArrayList<Integer>());    
        for(int i =0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean ans = Solution.isCycle(N,adj);
        if(ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}