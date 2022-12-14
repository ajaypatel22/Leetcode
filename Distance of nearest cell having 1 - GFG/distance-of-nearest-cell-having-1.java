//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        Queue<int[]> q = new LinkedList<>();
         int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis= new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j]==1){
                    q.add(new int[]{i,j});
                    vis[i][j]=true;
                }
            }
        }
        
        int[][]ans =new int[n][m];
        int[][]dirs={{1,0},{0,1},{-1,0},{0,-1}};
        
        int dis=0;
        while(!q.isEmpty()){
            int sz =q.size();
            while(sz-- >0){
                int[] idx = q.remove();
                int x =idx[0];
                int y =idx[1];
                ans[x][y] =dis;
                for(int[] dir:dirs){
                    int i=x+dir[0];
                    int j=y+dir[1];
                    if(i>=0 && j>=0 && i<n && j<m && !vis[i][j]){
                        q.add(new int[]{i,j});
                        vis[i][j]=true;
                    }
                    
                }
            }
            dis++;
        }
        return ans;
    }
}