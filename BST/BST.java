import java.util.Random;

class Node
  {
	  int key;
	  Node left, right, parent;
	  public Node(int key) 
	  {
		   this.key=key;
		   this.left = null;
		   this.right = null;
		   this.parent = null;
	  }	  
  }

public class BST
{
  Node root;
  BST()
  {
	  root = null;
  }
  public void insert(int key) 
  {
	  Node new_node = new Node(key);
	  Node holder = null;
	  Node walker = this.root;
	  while(walker!=null) 
	  {
		  holder = walker;
		  if(new_node.key< walker.key) 
		  {
			  walker = walker.left;
		  }
		  else 
		  {
			  walker = walker.right;
		  }
	  }
	  new_node.parent = holder;
	  if(holder == null) 
	  {
		  root = new_node;
	  }
	  else if(new_node.key < holder.key)
	  {
		  holder.left= new_node;
	  }
	  else 
	  {
		  holder.right = new_node;
	  }	
  }
  public void inorder(Node node) 
  {
	  if(node!=null) 
	  {
		  inorder(node.left);
		  System.out.println(node.key+" ");
		  inorder(node.right);
	  }
  }
 public static void main(String [] args) 
 {
	BST tree = new BST();
	Random r = new Random();
	int[] keys = new int[1000];
	for(int i=0;i<1000; i++) 
	{
		keys[i]=i+1;
	}
	for(int i=0; i<1000;i++) 
	{
		int randompos = r.nextInt(keys.length);
		int temp = keys[i];
		keys[i] =keys[randompos];
		keys[randompos] = temp;
     	tree.insert(keys[i]);
    }
	tree.inorder(tree.root);
	System.out.println(tree.root.key);
  }
}