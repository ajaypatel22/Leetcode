//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int q = sc.nextInt();
            ArrayList<Long> query = new ArrayList<>();
            for(int i=0;i<q;i++){
                query.add(sc.nextLong());
            }
            Solution ob = new Solution();
                
            ArrayList<Integer> ans = ob.threeDivisors(query,q);
            for(int cnt : ans) {
                System.out.println(cnt);
            }
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int qn){
        // code here
        int n =0;
        for(Long q:query){
            n = Math.max(n,(int)Math.sqrt(q));
        }
        boolean[] prime=new boolean[n+1];
        Arrays.fill(prime,true);
        for(int i=2;i<=n;i++){
            if(prime[i]){
                for(int j=i+i;j<=n;j+=i){
                    prime[j]=false;
                }
            }
        }
        int[] dp= new int[n+1];
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1];
            if(prime[i]){
                dp[i]++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(Long q:query){
            int root =(int)Math.sqrt(q);
            ans.add(dp[root]);
        }
        return ans;
    }
}