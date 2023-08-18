import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      int n,m,k;
      n=sc.nextInt();
      m=sc.nextInt();
      k=sc.nextInt();
      int[][] a= new int[m][3];
      for(int i=0;i<m;i++){
         int u,v,w;
         u=sc.nextInt();
         v=sc.nextInt();
         w=sc.nextInt();
         a[i][0]=u;
         a[i][1]=v;
         a[i][2]=w;   
      }
      Solution ob = new Solution();
      System.out.println(ob.networkDelayTime(a,n,k));
   }
}
class Solution {
	public class Pair{
		int node;
		int wsf;
		Pair(int node,int wsf){
			this.node = node;
			this.wsf = wsf;
		}
	}

	public class Edge{
		int nbr;
		int wt;
		Edge(int nbr,int wt){
			this.nbr = nbr;
			this.wt = wt;
		}
	}
	
       public int networkDelayTime(int[][] times, int N, int K) {
        //Write code here

			ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

		   for(int i = 0;i<N+1;i++) graph.add(new ArrayList<>());


			for(int[] edge: times){
				int u = edge[0];
				int v = edge[1];
				int w = edge[2];
				
				graph.get(u).add(new Edge(v,w));
			}


		   
		   int[] minTime = new int[N+1];

		   PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
			   return a.wsf - b.wsf;
		   });

		   boolean[] vis = new boolean[N+1];

		   pq.add(new Pair(K,0));

		   while(pq.size() > 0){
			   //Remove
			   Pair curr = pq.remove();

			   //Mark
			   if(vis[curr.node]) continue;
			   vis[curr.node] = true;

			   //Work
			   minTime[curr.node] = curr.wsf;

			   //Add unvisited nbrs
			   for(Edge e:graph.get(curr.node)){
				   int nbr = e.nbr;
				   int wt = e.wt;

				   if(!vis[nbr]) pq.add(new Pair(nbr,curr.wsf+wt));
			   }
		   }

		   for(int i= 1;i<N+1;i++) if(vis[i] == false) return -1;

		   int maxi = 0;
		   for(int i = 1;i<N+1;i++) maxi = Math.max(maxi,minTime[i]);
		   return maxi;
			
    }
}















