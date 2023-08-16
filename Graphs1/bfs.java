import java.util.*;
import java.io.*;
 
class Graph {
    public int vertices;
    public ArrayList<Integer>[] graph;
 
    Graph(int v) {
        this.vertices = v+1;
        graph = new ArrayList[v+1];
        
        for (int i = 0; i <= v; i++) graph[i] = new ArrayList<Integer>();
    }
 
    void addEdge(int v, int w) {
        graph[v].add(w);
     
    }
 
    void BFS(int x) {
        // your code here
		boolean[] visited = new boolean[vertices];
		Queue<Integer> q = new LinkedList<>();
		q.add(x);

		while(q.size() >0){
			//remove
			int currNode = q.remove();
			//mark
			if(visited[currNode] == true) continue;
			visited[currNode] = true;
			//work
			System.out.print(currNode+" ");
			//add unvisited
			for(int nbr: graph[currNode]){//graph is an array of arraylists
				if(!visited[nbr]) q.add(nbr);
			}
		}
		
    }
}
 
public class Main {
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        Graph g = new Graph(110);
        for(int i =0;i<e;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            g.addEdge(x,y);
        }
        g.BFS(0);
    }
}
