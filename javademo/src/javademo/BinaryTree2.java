package javademo;//iterative inorder traversal
import java.util.*;
class node1
{
	int data;
	node1 left, right;
	node1(int data)
	{
		this.data = data;
		left = right = null;
	}
}
public class BinaryTree2 {
	node1 root;
	/*BinaryTree2()
	{
		root = null;
	}*/
	void inorder()
	{
		Stack<node1> s = new Stack<>();
		while(!s.isEmpty()||root!=null)
		{
			while(root!=null)
			{
				s.push(root);
				root = root.left;
			}
			node1 x = s.pop();
			System.out.print(x.data+" ");
			root = x.right;
		}
	}
	public static void main(String[] args) {
		BinaryTree2 x = new BinaryTree2();
		x.root = new node1(1);
		x.root.left = new node1(2);
		x.root.right = new node1(3);
		x.root.left.left = new node1(4);
		x.root.left.right = new node1(5);
		 System.out.print("Inorder traversal of tree is : ");
		 x.inorder();
	}
}
