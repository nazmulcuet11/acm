#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int weight[1002],cost[1002],number_of_items,capacity;
int dp[1002][1002][100];

int knapsack(int i,int w,int c)
{
    if(i>=number_of_items)
        return 0;
    if(dp[i][w][c]!=-1)
        return dp[i][w][c];
    int profit1=0,profit2=0;
    if(w+weight[i]<=capacity)
        profit1=cost[i]+knapsack(i+1,w+weight[i],c-weight[i]);
    profit2=knapsack(i+1,w,c);
    dp[i][w][c]=max(profit1,profit2);
    return dp[i][w][c];
}
int main()
{
    int testcase,number_of_person,sum;
    cin>>testcase;
    while(testcase--)
    {
        sum=0;
        cin>>number_of_items;
        for(int i=0; i<number_of_items; i++)
        {
            cin>>cost[i]>>weight[i];
        }
        cin>>number_of_person;
        memset(dp,-1,sizeof(dp));
        for(int i=0; i<number_of_person; i++)
        {
            cin>>capacity;
            int temp=knapsack(0,0,capacity);
            sum+=temp;
        }
        cout<<sum<<endl;
    }
    return 0;
}
