
 class obst
{	
	public int[][] OptimalBST(int[] p,int q[],int numberOfKeys,int[][] cost)// As per the textbook we have to return 2 arrays instead I passed 1 array as a parameter and returned the other. 
	{
		int n = numberOfKeys;
		int[][] w = new int[n+1+1][n+1];
		int[][] root = new int[n+1][n+1];
		
		for(int i=0;i<=n;i++)
		{
			cost[i+1][i] = q[i];
			w[i+1][i] = q[i];
		}
		
		for(int k=1;k<=n;k++)
		{
			for(int i=1;i<=n-k+1;i++)
			{
				int j = i+k-1;
				cost[i][j] = Integer.MAX_VALUE;
				w[i][j] = w[i][j-1] + p[j] + q[j];
				for(int r=i;r<=j;r++)
				{
					int t =  cost[i][r-1] + cost[r+1][j]+w[i][j];
					if(t < cost[i][j])
					{
						cost[i][j] = t;
						root[i][j] = r;
					}
				}
			}
		}
		return root;
	}
}
