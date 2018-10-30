#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>
#include <algorithm>

using namespace std;

int M,N,x,y,cnt;
char map[25][25];
char land;

int dir_x[]={ 0, 0,-1,+1};
int dir_y[]={-1,+1, 0, 0};

int turn(int x){if(x<0) return N+x;return x;}

void dfs(int i,int j)
{
    if(i<0||i>=M||map[i][j]!=land)
        return;
    cnt++;
    map[i][j]=land+1;
    for(int pos=0;pos<4;pos++)
        dfs(i+dir_x[pos],turn(j+dir_y[pos])%N);
}

int main()
{
    freopen("input.in","r",stdin);
    while(scanf("%d %d",&M,&N)!=EOF)
    {
        getchar();
        for(int i=0;i<M;i++)
            gets(map[i]);
        scanf("%d %d",&x,&y);
        land=map[x][y];
        dfs(x,y);
        int ans=0;
        for(int i=0;i<M;i++)
            for(int j=0;j<N;j++)
                if(map[i][j]==land)
                {
                    cnt=0;
                    dfs(i,j);
                    ans=max(ans,cnt);
                }
        printf("%d\n",ans);
        //getchar();
        //getchar();
    }
    return 0;
}
