#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>

using namespace std;

char map[51][51];
int row,column,cnt;

int dir_x[]={ 0, 0,-1,+1};
int dir_y[]={-1,+1, 0, 0};

bool is_draft_senced(int i,int j)
{
    for(int pos=0;pos<4;pos++)
        if(map[i+dir_x[pos]][j+dir_y[pos]]=='T')
            return true;
    return false;
}

void dfs(int i,int j)
{
    if(i<0||j<0||i>=row||j>=column||map[i][j]=='#')
        return;
    if(map[i][j]=='G')
        cnt++;
    map[i][j]='#';
    if(!is_draft_senced(i,j))
    {
        for(int pos=0;pos<4;pos++)
            dfs(i+dir_x[pos],j+dir_y[pos]);
    }
}

int main()
{
    while(scanf("%d %d",&column,&row)!=EOF)
    {
        getchar();
        for(int i=0;i<row;i++)
            gets(map[i]);

        for(int i=0;i<row;i++)
            for(int j=0;j<column;j++)
                if(map[i][j]=='P')
                {
                    cnt=0;
                    dfs(i,j);
                }
        printf("%d\n",cnt);
    }
    return 0;
}
