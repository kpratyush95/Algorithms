
class Node_wpl
{
	int key;
	int depth;
	int access;
	int access_path;
	int weight;
	int rotate;
	Node_wpl left, right, parent;
	public Node_wpl(int key) 
	 {
		 this.key=key;
		 this.left = null;
		 this.right = null;
		 this.parent = null;
		 this.access =0;
	     this.access_path=0;
	     this.weight =0;
	     this.depth=0;
	     this.rotate=0;
	 }	  
 }
 class WPL_Trees
{   
	Node_wpl root;
	int total_weight=0;
	WPL_Trees()
	{
		  root = null;
	}
    public int weight_getter() 
    {
    	return total_weight;
    }
	public void sort(int[] keys, int[] frequency) //to sort the keys in decreasing order of their frequency.
	{
		 for(int i=0; i<1000; i++) 
		 {
			 int max_index = i;
			 for(int j=i+1; j<1000; j++) 
			 {
				 if(frequency[j]>=frequency[max_index]) 
				{
					 max_index =j;
					 int temp1=keys[max_index];
					 keys[max_index]= keys[i];
					 keys[i]= temp1;
					 int temp2 = frequency[max_index];
					 frequency[max_index] = frequency[i];
					 frequency[i] = temp2;
				}
			 }
		 }
	}
	public void insert(int key) 
	  {
		  Node_wpl new_node = new Node_wpl(key);
		  Node_wpl holder = null;
		  Node_wpl walker = this.root;
		  int depth =0;
		  while(walker!=null) 
		  {
			  depth++;
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
		  new_node.depth = (depth);
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
    public void node_search(int key) 
	 {
		  Node_wpl walker = root;
		  while(walker!= null) 
		  { 
			  if(key> walker.key) 
			  {
				  walker = walker.right;
			  }
			  else if(key < walker.key)
			  {
				  walker= walker.left;
			  }
			  else if(key == walker.key)
			  {
				 walker.access++;
				 if(walker.parent!=null) 
				 {
					 walker.parent.access_path++;
				 }
				 weight_calculator(walker);
				 return;
			  }
		  }
		  
		 return; 
	  } 
    public void weight_calculator(Node_wpl node) 
    {
    	if(node==null) 
    	{
    		return;
    	}
    	else 
    	{
    		int weight = node.depth*(node.access)+ node.access_path ;
    		node.weight =  weight;
            check_update_weight(node);
    	 }
      }
    public void check_update_weight(Node_wpl node)
     {
    	 if(node.parent!=null) 
 	    {
 	     if(node.weight<node.parent.weight) 
 	     {
 	      if(node==node.parent.left) 
 	      {
 	        right_rotate(node.parent);
 	      }
 	     else 
 	     {
 	       left_rotate(node.parent);
 	   	  }
 	     }
 	    }
    	if(node.parent!=null) 
    	{ 
        if(node.parent.rotate!=0) 
        {
          weight_calculator(node.parent);
         }
 	   }
    }
    public void inorder_tree_weight_calculator(Node_wpl node) 
    {
    	if(node!=null) 
    	{
    		inorder_tree_weight_calculator(node.left);
    		total_weight += node.weight;
    		inorder_tree_weight_calculator(node.right);
    	}
    }
    public void left_rotate(Node_wpl node) 
	{
	    Node_wpl right_holder = node.right;
		node.right = right_holder.left;
		if(right_holder.left !=null) 
		{
			right_holder.left.parent = node;
		}
		right_holder.parent = node.parent;
		if (node.parent==null) 
		{
			root = right_holder;
		}
		else if(node == node.parent.left) 
		{
			node.parent.left = right_holder;
		}
		else 
		{
			node.parent.right = right_holder; 
		}
		right_holder.depth--;
		node.depth++;
		node.rotate=1;
		right_holder.left = node;
		node.parent = right_holder;
	}
    public void right_rotate(Node_wpl node) 
	{
		Node_wpl left_holder = node.left;
		node.left = left_holder.right;
		if(left_holder.right!=null) 
		{
			left_holder.right.parent = node;
		}
		left_holder.parent = node.parent;
		if(node.parent==null) 
		{
			root = left_holder;
		}
		else if(node==node.parent.left) 
		{
			node.parent.left = left_holder;
		}
		else 
		{
			node.parent.right = left_holder;
		}
		left_holder.depth--;
		node.depth++;
		node.rotate=1;
		left_holder.right = node;
		node.parent = left_holder;
	}

}
