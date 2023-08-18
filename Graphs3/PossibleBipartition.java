import java.util.*;

class Solution {
   public class Pair{
	   int node;
	   int color;
		Pair(int node,int color){
			this.node = node;
			this.color = color;
		}
   }
	public boolean isBipartate(ArrayList<ArrayList<Integer>> graph,int[] vis,int src){
		Queue<Pair> q= new LinkedList<>();
		q.add(new Pair(src,1));//Ill try to color 1 with color 

		while(q.size() > 0){
			Pair curr = q.remove();

			if(vis[curr.node] !=0)   continue;
			vis[curr.node] = curr.color;

			int oppColor = curr.color == 1 ? -1 : 1;

			for(int nbr: graph.get(curr.node)){
				if(vis[nbr]== 0){
					q.add(new Pair(nbr,oppColor));
				}else if(vis[nbr] == curr.color) return false;
			}
		}
		return true;
		
	}
    public int possibleBipartition(int n, int[][] edges) {
        // Write your code here
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

		for(int i = 0;i<=n;i++){
			graph.add(new ArrayList<Integer>());
		}

		for(int[] edge: edges){
			int u = edge[0];
			int v = edge[1];

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		//now i have to check if the created graph is bipartate or not

		int[] vis = new  int[n+1]; // n+1 because 1 based indexing
		//1 == blue
		//0 == colorless
		//-1 == red

		for(int i = 1;i<=n;i++){
			if(vis[i] == 0){
				boolean ansFound = isBipartate(graph,vis,i);
				if(ansFound == false) return 0;
			}
		}
		return 1;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int dislike[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                dislike[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.possibleBipartition(N,dislike));

    }
}