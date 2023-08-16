import java.util.*;

class Solution {

	public static void dfs(ArrayList<ArrayList<Integer>> graph,boolean[] vis,int node){
		//Mark
		vis[node] = true;
		//work
		System.out.print(node + " ");
		//Visit the unvisited nbrs
		for(int nbr: graph.get(node)){
			if(vis[nbr] == false){
				dfs(graph,vis,nbr);
			}
		}
	}
	
    public static void DFSTraversal(List<List<Integer>> edges, int n) {
        //Write your code here
		ArrayList<ArrayList<Integer>> graph   = new ArrayList<>();
		
		for(int i = 0;i<n;i++) graph.add(new ArrayList<Integer>());

		for(List<Integer> edge: edges){
			int u = edge.get(0);
			int v = edge.get(1);
			//undirected graph
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		//portal magic
		for(int i = 0;i<n;i++){
			Collections.sort(graph.get(i));
		}
		//portal magic ends
		
		boolean[] vis = new boolean[n];//initally every place will be having false
		dfs(graph,vis,0);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        List<List<Integer>> ed = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(sc.nextInt());
            l.add(sc.nextInt());
            ed.add(l);
        }

        Solution ob = new Solution();
        ob.DFSTraversal(ed, n);
    }
}