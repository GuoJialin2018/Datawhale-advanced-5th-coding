package day5;

public class MaxDepth {
    public class TreeNode{
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x){
    		val=x;
    	}
    }
    public int maxDepth(TreeNode root) {
    	if(root==null) {
    		return 0;
    	}
    	return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	}

}
