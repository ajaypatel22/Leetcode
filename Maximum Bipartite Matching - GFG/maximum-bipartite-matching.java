//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int m = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
            int[][] G = new int[m][n];
            for(int i = 0; i < m; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    G[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            int ans = obj.maximumMatch(G);
            out.println(ans);
       }
       out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int maximumMatch(int[][] G)
    {
        // Code here
        int M= G.length;
        int N=G[0].length;
        int ans = fun(G, M,N);
        return ans;
    }
    int fun(int G[][], int M, int N)
    {
        int match[] = new int[N];
        for(int i=0; i<N; i++)
        match[i] =-1;

         int res =0; 
         for(int u=0; u<M; u++)
         {
             boolean seen[] = new boolean[N];
            if(bpm(G, u, seen, match, M, N))
            res++;
         }
         return res;
      }
      boolean bpm(int G[][], int u, boolean seen[], int match[], int M, int N)
      {
          for(int v= 0;v<N ;v++)
          {
              if(G[u][v]==1 && !seen[v])
              {
                  seen[v] =true;
              if(match[v]<0 || bpm(G, match[v], seen, match, M, N))
              {
                  match[v] =u;
                  return true;
              }
             }

          }
          return false;
    }
}