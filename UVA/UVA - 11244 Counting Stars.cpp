#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>
#include <algorithm>

using namespace std;

int row,column,cnt,counted_star;
char map[105][105];

int dir_x[]={ 0, 0,-1,+1,-1,-1,+1,+1};
int dir_y[]={-1,+1, 0, 0,-1,+1,-1,+1};

void dfs(int i,int j)
{
    if(i<0||j<0||i>=row||j>=column||map[i][j]!='*')
        return;
    map[i][j]='.';
    cnt++;
    for(int pos=0;pos<8;pos++)
        dfs(i+dir_x[pos],j+dir_y[pos]);
}

int main()
{
    freopen("input.in","r",stdin);
    while(scanf("%d %d",&row,&column)&&(row||column))
    {
        getchar();
        for(int i=0;i<row;i++)
            gets(map[i]);

        counted_star=0;
        for(int i=0;i<row;i++)
            for(int j=0;j<column;j++)
                if(map[i][j]=='*')
                {
                    cnt=0;
                    dfs(i,j);
                    if(cnt==1)
                        counted_star++;
                }

        printf("%d\n",counted_star);
    }
    return 0;
}
