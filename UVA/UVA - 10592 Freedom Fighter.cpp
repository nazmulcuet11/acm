#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>
#include <algorithm>

using namespace std;

char map[50+5][50+5];
int n,fighting_group,freedom_fighter,enemy;
bool flag;

int dir_x[]={+1,-1, 0, 0};
int dir_y[]={ 0, 0,+1,-1};

void dfs(int i,int j,char ch)
{
    if(i<0||j<0||i>=n||j>=n||map[i][j]=='*'||map[i][j]=='.')
        return;
    if(map[i][j]!=ch)
    {
        if(flag==false)
        {
            flag=true;
            fighting_group+=2;
        }
        return;
    }
    map[i][j]='*';
    for(int pos=0;pos<4;pos++)
        dfs(i+dir_x[pos],j+dir_y[pos],ch);
}

void solve(int i,int j)
{
    if(i<0||j<0||i>=n||j>=n||map[i][j]=='.')
        return;
    if(map[i][j]=='B')
    {
        freedom_fighter++;
        flag=false;
        dfs(i,j,map[i][j]);
    }
    if(map[i][j]=='P')
    {
        enemy++;
        flag=false;
        dfs(i,j,map[i][j]);
    }
    map[i][j]='.';
    for(int pos=0;pos<4;pos++)
        solve(i+dir_x[pos],j+dir_y[pos]);
}

int main()
{
    while(scanf("%d",&n)&&n)
    {
        getchar();
        for(int i=0;i<n;i++)
            gets(map[i]);

        int sector=1;
        fighting_group=0;

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(map[i][j]!='.')
                {
                    freedom_fighter=enemy=0;
                    solve(i,j);
                    printf("Sector #%d: contain %d freedom fighter group(s) & %d enemy group(s)\n",sector++,freedom_fighter,enemy);
                }

        printf("Total %d group(s) are in fighting position.\n\n",fighting_group);
    }
    return 0;
}
