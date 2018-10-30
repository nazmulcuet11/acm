#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>
#include <algorithm>

typedef long long int i64;

using namespace std;

int dp1[31][31];
i64 dp2[31][31];
string s1,s2;

int solve1(int i,int j)
{
    if(i<0||j<0) return (i+j+2);///Protektar length i, or j er ceye 1 kore besi...so 1+1=2;
    if(dp1[i][j]!=-1) return dp1[i][j];
    if(s1[i]==s2[j])
        return dp1[i][j]=1+solve1(i-1,j-1);
    else
        return dp1[i][j]=1+min(solve1(i-1,j),solve1(i,j-1));
}

i64 solve2(int i,int j)
{
    if(i<0||j<0) return 1;
    if(dp2[i][j]!=-1) return dp2[i][j];
    i64 ret=0;
    if(s1[i]==s2[j])
        ret+=solve2(i-1,j-1);
    else
    {
        if(solve1(i-1,j)<solve1(i,j-1))
            ret+=solve2(i-1,j);
        else if(solve1(i-1,j)>solve1(i,j-1))
            ret+=solve2(i,j-1);
        else
            ret+=solve2(i-1,j)+solve2(i,j-1);
    }
    return dp2[i][j]=ret;
}

int main()
{
    int test_case,case_no=1;
    for(scanf("%d",&test_case);test_case;test_case--)
    {
        cin>>s1>>s2;
        memset(dp1,-1,sizeof dp1);
        memset(dp2,-1,sizeof dp2);
        int ans1=solve1(s1.size()-1,s2.size()-1);
        i64 ans2=solve2(s1.size()-1,s2.size()-1);
        printf("Case %d: %d %lld\n",case_no++,ans1,ans2);
    }
    return 0;
}
