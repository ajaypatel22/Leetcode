//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        // code here
        if(n==1)
        return arr[0];
        int max1 = arr[0]; //max sum including the 0th ele
        int max2 = 0; // max sum excluding 0th ele
        int new_max1=0;
        for(int i=1; i<n; i++)
        {
            new_max1 = arr[i] + max2;
            max2 = Math.max(max1, max2);
            max1 = new_max1;
        }
        return Math.max(new_max1,max2);
    }
}