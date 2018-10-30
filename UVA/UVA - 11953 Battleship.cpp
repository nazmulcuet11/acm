#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>
#include <algorithm>

using namespace std;

char grid[100+1][100+1];
int test_case,case_no=1,n,cnt;

int dir_x[]={ 0, 0,-1,+1,-1,-1,+1,+1};
int dir_y[]={-1,+1, 0, 0,-1,+1,-1,+1};

void dfs(int i,int j)
{
    if(i<0||j<0||i>=n||j>=n||grid[i][j]=='.')
        return;
    grid[i][j]='.';
    for(int pos=0;pos<4;pos++)
        dfs(i+dir_x[pos],j+dir_y[pos]);
}

int main()
{
    for(scanf("%d",&test_case);test_case;test_case--)
    {
        scanf("%d",&n);
        getchar();
        for(int i=0;i<n;i++)
            gets(grid[i]);

        cnt=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(grid[i][j]=='x')
                    cnt++,dfs(i,j);
        printf("Case %d: %d\n",case_no++,cnt);
    }
    return 0;
}
