#include <cstdio>
#include <cstring>
#include <algorithm>
#include <string>
#include <iostream>

#define inf 1<<25

using namespace std;

string s;
int dp[1001];

bool is_palindrome(int i,int j)
{
    if(i>=j) return true;
    if(s[i]!=s[j]) return false;
    return is_palindrome(i+1,j-1);
}

int solve(int pos)
{
    if(pos>=s.size()) return 0;
    if(dp[pos]!=-1) return dp[pos];
    int ret=inf;
    for(int i=pos;i<s.size();i++)
    {
        if(is_palindrome(pos,i))
        {
           ret=min(ret,1+solve(i+1));
        }
    }
    return dp[pos]=ret;
}

int main()
{
    int test_case,case_no=1;
    for(scanf("%d",&test_case);test_case;test_case--)
    {
        memset(dp,-1,sizeof dp);
        cin>>s;
        printf("Case %d: %d\n",case_no++,solve(0));
    }
    return 0;
}
