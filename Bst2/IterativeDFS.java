import java.util.*;

import javax.swing.tree.TreeNode;

class IterativeDFS{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        scn.close();
    }
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static class Pair{
		TreeNode node;
		int state;
		Pair(TreeNode node,int state){
			this.node = node;
			this.state = state;
		}
	}
     public static void dfs(TreeNode root) {
        //Write code here
		ArrayList<Integer> pre = new ArrayList<Integer>();
		ArrayList<Integer> in = new ArrayList<Integer>();
		ArrayList<Integer> post = new ArrayList<Integer>();

		Stack<Pair> st = new Stack<>();
		st.push(new Pair(root,1));

		while(st.size() > 0){
			Pair top = st.peek();
			if(top.state == 1){
				//we are visiting this node for the first time
				pre.add(top.node.val);
				top.state++;
				if(top.node.left != null) st.push(new Pair(top.node.left,1));
			}else if(top.state == 2){
				in.add(top.node.val);
				top.state++;
				if(top.node.right != null) st.push(new Pair(top.node.right,1));
			}else{
				post.add(top.node.val);
				st.pop();
			}
		}

		System.out.println(pre);
		System.out.println(in);
		System.out.println(post);
	
    }
}