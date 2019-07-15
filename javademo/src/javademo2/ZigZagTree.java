/**
 * 
 */
package javademo2;

/**
 * @author mrinalvatsya
 *
 */
/* importing the inbuilt java classes required for the program */
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList; 

/* Class to represent Tree node */
class Node { 
	int data; 
	Node left, right; 

	public Node(int item) { 
		data = item; 
		left = null; 
		right = null; 
	} 
} 

/* Class to print Level Order Traversal */
class ZigZagTree { 

	Node root; 

	/* Given a binary tree. Print its nodes in level order 
  using array for implementing queue  */
	void printLevelOrder()  
	{ 
		Stack<Node> currentLevel = new Stack<>();
		Stack<Node> nextLevel = new Stack<>();
		currentLevel.add(root);
		Boolean leftToRight = true; 
		while (!currentLevel.isEmpty())  
		{ 
			Node tempNode = currentLevel.peek();
			currentLevel.pop();
			System.out.print(tempNode.data + " "); 
			
			if(leftToRight)
			{
				/*Enqueue right child */
				if (tempNode.right != null) { 
					nextLevel.add(tempNode.right); 
				}

				/*Enqueue right child */
				if (tempNode.left != null) { 
	//				queue.add(tempNode.left); 
				}
				leftToRight = false;
			}
			else//RightToLeft
			{
				if(tempNode.left != null)
				{
					
				}
			}
			
		} 
	} 

	public static void main(String args[])  
	{ 
		/* creating a binary tree and entering  
      the nodes */
		ZigZagTree tree_level = new ZigZagTree(); 
		tree_level.root = new Node(1); 
		tree_level.root.left = new Node(2); 
		tree_level.root.right = new Node(3); 
		tree_level.root.left.left = new Node(4); 
		tree_level.root.left.right = new Node(5); 
		tree_level.root.right.left = new Node(4); 
		tree_level.root.right.right = new Node(5); 

		System.out.println("Level order traversal of binary tree is - "); 
		tree_level.printLevelOrder(); 
	} 
} 