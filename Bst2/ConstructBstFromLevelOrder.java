import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;
import java.lang.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Main {

    static void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {

            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        Node ans = Obj.bstFromLevel(arr, n);
        printLevelOrder(ans);
        sc.close();
    }
}

class Solution {
	class Pair{
		Node parent;
		int l;
		int r;
		Pair(Node parent,int l,int r){
			this.parent = parent;
			this.l = l;
			this.r = r;
		}
	}
    Node bstFromLevel(int arr[], int n) {
        // write code here
		Queue<Pair> q = new LinkedList<>();
		Node root = new Node(arr[0]);
		q.add( new Pair(root,Integer.MIN_VALUE,root.data-1) );
		q.add( new Pair(root,root.data+1,Integer.MAX_VALUE) );

		int idx = 1;

		while(q.size() > 0){
			Pair curr = q.remove();

			if(idx == n) continue;//no more values
			if(arr[idx] < curr.l || arr[idx] > curr.r) continue;//not in range

			Node me = new Node(arr[idx]);
			idx++;

			if(me.data < curr.parent.data) curr.parent.left = me;
			else curr.parent.right = me;
			//i can also act as a parent
			q.add(new Pair(me,curr.l,me.data-1));
			q.add(new Pair(me,me.data+1,curr.r));
		}
		return root;
    }
}















