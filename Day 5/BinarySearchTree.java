package day5;

import java.util.LinkedList;

class TreeNode{
	private int data=0;
	private TreeNode leftChild=null;
	private TreeNode rightChild=null;
	private TreeNode parent=null;
	public TreeNode() {}
	public TreeNode(int data) {
		this.data=data;
	}
	public int getData() {return data;}
	public void setData(int data) {
		this.data=data;
	}
	public TreeNode getLeftChild() {
		return leftChild;
	}
	public TreeNode getRightChild() {
		return rightChild;
	}
	public TreeNode getParent() {
		return parent;
	}
	public void setParent(TreeNode parent) {
		this.parent=parent;
	}
	public void setRightChild(TreeNode rightChild) {
		this.rightChild=rightChild;
	}
	public void setLeftChild(TreeNode leftChild) {
		this.leftChild=leftChild;
	}
}
public class BinarySearchTree {
	private TreeNode root=null;
	public void createBinarySearchTree(int key) {
		TreeNode node=new TreeNode(key);
		if(root==null) {
			root=node;
		}else {
			TreeNode current=root;
			TreeNode parent=null;
			while(current!=null) {
				parent=current;
				if(current.getData()<node.getData()) {
					current=current.getRightChild();
				}else {
					current=current.getLeftChild();
				}
			}
			node.setParent(parent);
			if(parent==null) {
				root=node;
			}else if(parent.getData()>node.getData()) {
				parent.setLeftChild(node);
			}else {parent.setRightChild(node);
		    }
	      }
    }
    public TreeNode treeSearch(TreeNode node,int key) {
    	if(node==null||key==node.getData()) {
    		return node;
    	}
    	if(key<node.getData()) {
    		return treeSearch(node.getLeftChild(),key);
    	}else {
    		return treeSearch(node.getRightChild(),key);
    	}
    }
    public TreeNode maxNode(TreeNode node) {
    	while(node.getRightChild()!=null) {
    		node=node.getRightChild();
    	}
    	return node;
    }
    public TreeNode minNode(TreeNode node) {
    	while(node.getLeftChild()!=null) {
    		node=node.getLeftChild();
    	}
    	return node;
    }
    public TreeNode getNextNode(TreeNode node) {
    	if(node.getRightChild()!=null) {
    		return minNode(node.getRightChild());
    	}
    	TreeNode parent=node.getParent();
    	//node.setParent(parent);
    	while(parent!=null&&node==parent.getRightChild()) {
    		node=parent;
    		parent=parent.getParent();
    	}
    	return parent;
    }  
    public TreeNode getPreNode(TreeNode node) {
    	if(node.getLeftChild()!=null) {
    		return maxNode(node.getLeftChild());
    	}
    	TreeNode parent=node.getParent();
    	while(parent!=null&&node==parent.getLeftChild()) {
    		node=parent;
    		parent=parent.getParent();
    	}
    	return parent;  	
    }
    public void levelOrder() {
    	LinkedList<TreeNode> list=new LinkedList<TreeNode>();
    	list.add(root);
    	TreeNode currentNode;
    	while(!list.isEmpty()) {
    		currentNode=list.poll();
    		System.out.print(currentNode.getData()+",");
    		if(currentNode.getLeftChild()!=null) {
    			list.add(currentNode.getLeftChild());
    		}
    		if(currentNode.getRightChild()!=null) {
    			list.add(currentNode.getRightChild());
    		}
    	}
    	
    }
    public void preOrder(TreeNode node) {
    	if(node!=null) {
    		System.out.print(node.getData()+",");
    	}
    	if(node.getLeftChild()!=null) {
    		preOrder(node.getLeftChild());
    	}
    	if(node.getRightChild()!=null) {
    		preOrder(node.getRightChild());
    	}   	
    }
    public void midOrder(TreeNode node) {
    	if(node.getLeftChild()!=null) {
    		midOrder(node.getLeftChild());
    	}
    	System.out.print(node.getData()+",");
    	if(node.getRightChild()!=null) {
    		midOrder(node.getRightChild());
    	}
    }
    public void postOrder(TreeNode node) {
    	if(node.getLeftChild()!=null) {
    		postOrder(node.getLeftChild());
    	}
    	if(node.getRightChild()!=null) {
    		postOrder(node.getRightChild());
    	}  
    	System.out.print(node.getData()+",");
    }
    public static void main(String[] args) {
    	BinarySearchTree bt=new BinarySearchTree();
    	for(int i=0;i<16;i++) {
    		bt.createBinarySearchTree(i);
    	}
    	bt.root.setData(0);
    	System.out.println("\n层序遍历:");
    	bt.levelOrder();
    	System.out.println("\n前序遍历:");
    	bt.preOrder(bt.root);
    	System.out.println("\n中序遍历:");
    	bt.midOrder(bt.root);
    	System.out.println("\n后序遍历:");
    	bt.postOrder(bt.root);
    
    	System.out.println("\n4的上一个节点:");
    	System.out.print(bt.getPreNode(bt.treeSearch(bt.root, 4)).getData());
     	System.out.println("\n12的下一个节点:");
    	System.out.print(bt.getNextNode(bt.treeSearch(bt.root, 12)).getData());
    }
}
