#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;
int m,n,a[25],b,c[25],ans;
int knapsack(int i,int sum,int mask)
{
    if(sum>m)
        return 0;
    if(sum>ans)
    {
        ans=sum;
        b=mask;
    }
    if(i>=n)
        return 0;
    a[i]+knapsack(i+1,sum+a[i],mask|1<<i);
    knapsack(i+1,sum,mask);
}
int main()
{
    while(cin>>m>>n)
    {
        for(int i=0;i<n;i++)
            cin>>a[i];
        b=0;
        ans=-1;
        knapsack(0,0,0);
        for(int i=0;i<n;i++)
        {
            if((b>>i)%2)
            cout<<a[i]<<" ";
        }
        cout<<"sum:"<<ans<<endl;
    }
    return 0;
}
