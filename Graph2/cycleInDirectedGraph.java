import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

	public boolean dfs(ArrayList<Integer>[] graph,boolean[] path,boolean[] visited,int node){
		//mark
		path[node] = true;
		visited[node] = true;
		//work-nothing
		//visit all the  unvisited nbrs
		for(int nbr: graph[node]){
			if(path[nbr] == true) return true;//i can go to a nbr which is coming inside the path to reach node
			else if(!visited[nbr]){
				boolean isCyclic = dfs(graph,path,visited,nbr);
				if(isCyclic) return true;
			}
		}
		//unmark
		path[node] = false;
		return false;
	}
	
public boolean isCyclic(int V, ArrayList<Integer>[] graph) {
    // Your code here
		boolean[]  visited = new boolean[V];
		boolean[] path = new boolean[V];

		for(int i = 0;i<V;i++){
			if(!visited[i]){
				boolean isCyclic = dfs(graph,path,visited,i);
				if(isCyclic) return true;
			}
		}
		return false;
   }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V, E;
        V = sc.nextInt();
        E = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < E; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            adj[u].add(v);
        }
        Solution obj = new Solution();
        boolean ans = obj.isCyclic(V, adj);
        if (ans == true) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}