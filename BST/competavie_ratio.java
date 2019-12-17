import java.util.*;

public class competavie_ratio
{
	public float competative_ratio(int a, int b) 
	{
		float parameter1= a;
		float parameter2 = b;
		return parameter2/parameter1;
	}
	public static void main(String[] args)
	{
		float[] splay_cr = new float [10];
		float[] move_to_root_cr = new float[10];
		float[] wpl_cr_avg = new float[10];
	  for(int run=0; run<10; run++) 
	  {
		  
	    System.out.println("----------------------Run no "+run+"--------------------");
	    Random r = new Random();
		int[] keys = new int[1000];
		int[] q = new int[1000];
		for(int i=0;i<1000; i++) 
		{
			keys[i]=i+1; //generating keys
		}
		for(int i=0; i<1000;i++) //randomizing the keys
		{
			int randompos = r.nextInt(keys.length);
			int temp = keys[i];
			keys[i] =keys[randompos];
			keys[randompos] = temp;
			q[i]=0;
		}
		int[] a = new int[1000];
		int sum = 0;
		int[] c = new int[1001];
		c[0]=0;
		BST_Splay tree = new BST_Splay(); //calling the BST_Splay class to generate the tree
		for(int i =0; i<1000;i++) 
		{
			a[i]= r.nextInt(100)+1;
			sum=sum+a[i];
			c[i+1]=sum;
			tree.insert(keys[i]); //insert in the tree
		}
		int[] frequency = new int[1000];
		int[] acess_sequence = new int[10000];
		for(int i=0; i<10000; i++) 
		{
			int j = r.nextInt(c[1000])+1;
			for(int k=1; k< c.length; k++) 
			{
				if(c[k-1]<j && j<=c[k]) 
				{
					acess_sequence[i]=k;//access_sequence
					frequency[k-1]++; //frequency
				} 
			}
		}
		
		int number = 999;
		int[][] cost = new int[number+1+1][number+1];	
		obst obst1 =new obst();
		int[][] root = obst1.OptimalBST(frequency, q, number,cost);
		int obst_cost = cost[1][number];
		System.out.println("cost of this optimal BST is " + obst_cost);
		for(int i = 0; i<acess_sequence.length;i++) 
		{
			tree.node_search_splay(acess_sequence[i]);//searching for splay
			
		}
		for(int i =0; i<acess_sequence.length;i++) 
		{
			tree.search_move_to_root(acess_sequence[i]); //searching for move to root
		}
		int depth_counter_splay =0;
		depth_counter_splay = tree.get_depth();
		int rotation_counter_splay =0;
		rotation_counter_splay = tree.get_rotation();
		int splay_total = 0;
		splay_total =depth_counter_splay+rotation_counter_splay;
		System.out.println("Splay total " + splay_total);
		int depth_counter_mtr=0;
		depth_counter_mtr = tree.get_depth_move_to_root();
		int rotation_counter_mtr=0;
		rotation_counter_mtr = tree.get_rotation_move_to_root();
		int mtr_total=0; 
		mtr_total = depth_counter_mtr + rotation_counter_mtr;
		System.out.println("The cost of move to root is "+mtr_total);
		WPL_Trees wpl = new WPL_Trees();
	    wpl.sort(keys, frequency);
        for(int i=0; i<keys.length;i++) 
        {
        	wpl.insert(keys[i]);
        }
    	for(int i=0; i<acess_sequence.length; i++) 
    	{
    		wpl.node_search(acess_sequence[i]); //searching for wpl
    	}
    	wpl.inorder_tree_weight_calculator(wpl.root);
    	int weight = wpl.weight_getter();
    	System.out.println("The total weight of the tree is "+weight);
    	competavie_ratio cr = new competavie_ratio();
    	float splay_competative_ratio =cr.competative_ratio(obst_cost,splay_total);
    	splay_cr[run]=splay_competative_ratio; 
    	System.out.println("Competative ratio of splay is "+splay_competative_ratio);
    	float mtr_cr = cr.competative_ratio(obst_cost, mtr_total);
    	move_to_root_cr[run]= mtr_cr;
    	System.out.println("Competative ratio of mtr is "+mtr_cr);
    	float wpl_cr = cr.competative_ratio(obst_cost, weight);
    	wpl_cr_avg[run] = wpl_cr;
    	System.out.println("Competative ratio of WPL is "+wpl_cr);
	}
	float total_splay=0;
  	float total_mtr=0;
  	float total_wpl =0;
    for(int i =0; i<10; i++) 
    {
    	
    	total_splay+=splay_cr[i];
    	total_mtr +=move_to_root_cr[i];
    	total_wpl +=wpl_cr_avg[i]; 
    }
     float avg_splay_cr = total_splay/10;
     float avg_mtr_cr = total_mtr/10;
     float avg_wpl_cr = total_wpl/10;
     System.out.println("-----------------------------Average Competative Ratio---------------------------------");
     System.out.println("Average Competative ratio of Splay is "+avg_splay_cr);
     System.out.println("Average Competative ratio of MTR is "+avg_mtr_cr);
     System.out.println("Average Competative ratio of WPL is "+avg_wpl_cr);
	}
  

}
