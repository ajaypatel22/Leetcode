//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


class Array
{
public:
    template <class T>
    static void input(vector<T> &A,int n)
    {
        for (int i = 0; i < n; i++)
        {
            scanf("%d ",&A[i]);
        }
    }

    template <class T>
    static void print(vector<T> &A)
    {
        for (int i = 0; i < A.size(); i++)
        {
            cout << A[i] << " ";
        }
        cout << endl;
    }
};


// } Driver Code Ends
class Solution {
  public:
    int solve(int N, int K, vector<int> &arr) {
        // code here
        vector<int>presum;
        int sum=0;
        for(auto it:arr)
        {
            sum += it;
            presum.push_back(sum);
        }
        vector<int>factors;
        for(int i=1;i*i<=sum;i++)
        {
            if(sum%i==0)
            {
                factors.push_back(i);
                if(sum/i !=i)
                    factors.push_back(sum/i);
            }
        }
        sort(factors.rbegin(),factors.rend());
        for(auto it:factors)
        {
            int count =0;
            for(auto itr:presum)
            {
                if(itr%it==0)
                    count++;
            }
            if(count>=K)
            return it;
        }
        return 1;
    }
};


//{ Driver Code Starts.

int main(){
    int t;
    scanf("%d ",&t);
    while(t--){
        
        int N;
        scanf("%d",&N);
        
        
        int K;
        scanf("%d",&K);
        
        
        vector<int> arr(N);
        Array::input(arr,N);
        
        Solution obj;
        int res = obj.solve(N, K, arr);
        
        cout<<res<<endl;
        
    }
}

// } Driver Code Ends