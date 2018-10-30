#include <iostream>
#include <cstring>
#include <cstdio>
#include <algorithm>

using namespace std;
int total_time,w,n;
int d_time[31],value[31];
int dp[31][1001];
bool  x[31]={false},taken[31][1001];

int max_gold(int i,int t)
{
    if(i<0||t<0)
        return 0;
    if(dp[i][t]!=-1)
        return dp[i][t];
    int a=0,b;
    if(t-d_time[i]*3*w>=0)
        a=max_gold(i-1,t-d_time[i]*3*w)+value[i];
    b=max_gold(i-1,t);

    if(a>b)
    {
        dp[i][t]=a;
        taken[i][t]=true;
    }
    else
    {
        dp[i][t]=b;
        taken[i][t]=false;
    }
    return dp[i][t];
}

int main()
{
    bool first=true;
    while(cin>>total_time>>w)
    {
        if(!first)
            cout<<endl;
            first=false;
        memset(dp,-1,sizeof (dp));
        memset(taken,false,sizeof taken);
        cin>>n;
        for(int i=0; i<n; i++)
        {
            cin>>d_time[i]>>value[i];
        }
        cout<<max_gold(n-1,total_time)<<endl;
        int count=0,t=total_time;
        for(int i=n-1; i>=0; i--)
        {
            if(taken[i][t])
            {
                count++;
                t=t-d_time[i]*3*w;
                x[i]=true;
            }
        }
        cout<<count<<endl;
        for(int i=0; i<n; i++)
        {
            if(x[i])
            {
                cout<<d_time[i]<<" "<<value[i]<<endl;
            }
        }
    }
    return 0;
}
