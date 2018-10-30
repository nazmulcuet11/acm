#include <iostream>
#include <cstdio>
#include <cstring>
#include <algorithm>

using namespace std;

char board[12][12];
char played[12][12];
int adj[12][12],N;

int dir_x[]={ 0, 0,-1,+1,-1,-1,+1,+1};
int dir_y[]={-1,+1, 0, 0,-1,+1,-1,+1};

void calculate(int i,int j)
{
    for(int pos=0;pos<8;pos++)
    {
        int x=i+dir_x[pos];
        int y=j+dir_y[pos];
        if(x>=0&&y>=0&&x<N&&y<N)
            adj[x][y]++;
    }
}

bool check()
{
    for(int i=0;i<N;i++)
        for(int j=0;j<N;j++)
            if(played[i][j]=='x'&&board[i][j]=='*')
                return true;
    return false;
}

int main()
{
    //freopen("input.in","r",stdin);
    int test_case,case_no=1;
    for(scanf("%d",&test_case);test_case;test_case--)
    {
        scanf("%d",&N);
        getchar();
        if(case_no>1)
            printf("\n");
        for(int i=0;i<N;i++)
            gets(board[i]);
        memset(adj,0,sizeof adj);
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
                if(board[i][j]=='*')
                    calculate(i,j);
        for(int i=0;i<N;i++)
            gets(played[i]);
        bool is_touched=check();

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(played[i][j]=='x'&&board[i][j]!='*')
                    printf("%d",adj[i][j]);
                else if(is_touched&&board[i][j]=='*')
                    printf("*");
                else //if(!is_touched&&board[i][j]=='*')
                    printf(".");
            }
            printf("\n");
        }
        case_no++;
    }
    return 0;
}
