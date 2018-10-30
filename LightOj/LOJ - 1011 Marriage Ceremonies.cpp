#include <cstdio>
#include <iostream>
#include <algorithm>
#include <cstring>

#define set_bit(a,bit) (a|(1<<bit))
#define clear_bit(a,bit) (a&~(1<<bit))
#define check_bit(a,bit) (a&(1<<bit))
#define shift_left(a,bit) (a<<bit)
#define shift_right(a,bit) (a>>bit)

using namespace std;

int dp[16][1<<16],N,data[16][16];

int solve(int row,int mask)
{
    if(row>=N) return 0;///Row>=N
    if(dp[row][mask]!=-1) return dp[row][mask];
    for(int i=0; i<N; i++)
        if(!check_bit(mask,i))
            dp[row][mask]=max(dp[row][mask],data[row][i]+solve(row+1,set_bit(mask,i)));
    return dp[row][mask];
}

int main()
{
    int test_case,case_no=1;
    for(scanf("%d",&test_case); test_case; test_case--)
    {
        memset(dp,-1,sizeof dp);
        scanf("%d",&N);
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
                scanf("%d",&data[i][j]);
        printf("Case %d: %d\n",case_no++,solve(0,0));
    }
}
