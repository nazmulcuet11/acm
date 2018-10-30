#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>

using namespace std;

char board[10][10];
char black[10][10];
char white[10][10];

int dir_x[]={ 0, 0,-1,+1};
int dir_y[]={-1,+1, 0, 0};

void solve(int i,int j,char arr[10][10],char ch)
{
    if(i<0||j<0||i>=9||j>=9||arr[i][j]!='.')
        return;
    arr[i][j]=ch;
    for(int pos=0;pos<4;pos++)
        solve(i+dir_x[pos],j+dir_y[pos],arr,ch);
}


int main()
{
    int test_case;
    for(scanf("%d",&test_case);test_case;test_case--)
    {
        for(int i=0;i<9;i++)
        {
            getchar();
            for(int j=0;j<9;j++)
            {
                scanf("%c",&board[i][j]);
                black[i][j]=white[i][j]=board[i][j];
            }
        }
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='X')
                {
                    black[i][j]='.';
                    solve(i,j,black,'X');
                }
                if(board[i][j]=='O')
                {
                    white[i][j]='.';
                    solve(i,j,white,'O');
                }
            }
        }
        int b=0,w=0;
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(black[i][j]=='X'&&white[i][j]!='O')
                    b++;
                if(black[i][j]!='X'&&white[i][j]=='O')
                    w++;
            }
        }
        printf("Black %d White %d\n",b,w);
    }
    return 0;
}
