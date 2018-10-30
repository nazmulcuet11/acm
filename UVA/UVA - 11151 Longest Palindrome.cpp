#include <iostream>
#include <string>
#include <cstring>
#include <algorithm>
#include <cstdio>
using namespace std;
int dp[1050][1050];
string s;
int find_long_pal(int i,int j)
{
    if(i>j) return 0;
    if(dp[i][j]!=-1) return dp[i][j];
    int temp=2;
    if(i==j) temp=1;
    if(s[i]==s[j]) return dp[i][j]=find_long_pal(i+1,j-1)+temp;
    int x=find_long_pal(i,j-1);
    int y=find_long_pal(i+1,j);
    return dp[i][j]=max(x,y);
}
int main()
{
    int test_case;
    cin>>test_case;
    getchar();
    while(test_case--)
    {
        getline(cin,s);
        memset(dp,-1,sizeof dp);
        cout<<find_long_pal(0,s.size()-1)<<endl;
    }
    return 0;
}
