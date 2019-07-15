package javademo;
import java.util.*;
class Node
{
	int data;
	Node left , right;
	Node(int data)
	{
		this.data = data;
		left = null;
		right = null;
	}
}
public class BinaryTree {
	 static Node root;
	BinaryTree()
	{
		root = null;
	}
	void preorder(Node node)//preorder iteration over tree.
	{
		if(node==null)
			return;
		System.out.print(node.data+" ");
		preorder(node.left);
		preorder(node.right);
	}
	public static void main(String[] args) {
	
	BinaryTree tree = new BinaryTree();//Binary tree created..
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    
    System.out.print("Preorder traversal of tree is : ");
    tree.preorder(root);
}
}