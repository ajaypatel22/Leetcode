//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(St[0]);
            int m = Integer.parseInt(St[1]);
            int k = Integer.parseInt(St[2]);
            
            int[][] mat = new int[n][m];
            
            for(int i=0; i<n; i++)
            {
                String S[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                    mat[i][j] = Integer.parseInt(S[j]);
            }

            Solution ob = new Solution();
            System.out.println(ob.shotestPath(mat,n,m,k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int shotestPath(int[][] mat, int n, int m, int k) {
        // code here
        int visited[][][]=new int[n][m][k+1];
        int steps=0;
        Queue<int[]> q=new LinkedList<>();
        visited[0][0][k]=1;
        q.add(new int[]{0,0,k});
        int dirx[]={1,0,-1,0};
        int diry[]={0,1,0,-1};
        while(q.size()>0)
        {
            int size=q.size();
            while(size-->0)
            {
                int nd[]=q.remove();
                int x=nd[0];
                int y=nd[1];
                int z=nd[2];
                if(x==n-1&&y==m-1)
                {
                    return steps;
                }
                for(int i=0;i<4;i++)
                {
                    int a=x+dirx[i];
                    int b=y+diry[i];
                    if(a>=0&&a<mat.length&&b>=0&&b<mat[0].length)
                    {
                    if(mat[a][b]==1&&z>0&&visited[a][b][z-1]==0)
                    {
                        q.add(new int[]{a,b,z-1});
                        visited[a][b][z-1]=1;
                    }
                    else if(mat[a][b]==0&&visited[a][b][z]==0)
                    {
                    q.add(new int[]{a,b,z});
                    visited[a][b][z]=1;
                    }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}