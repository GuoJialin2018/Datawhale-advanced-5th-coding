package day5;
public class invertTree {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val=x;
		}
	}
	public TreeNode invertTree(TreeNode root) {
		if(root==null)return root;
		root.left=invertTree(root.left);
		root.right=invertTree(root.right);
		TreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;
		return root;
	}

}
