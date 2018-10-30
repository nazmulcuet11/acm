#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int n,case_no=1;
char map[200+5][200+5];
int blk,wht;

int dir_x[]={-1, 0,+1,-1, 0,+1};
int dir_y[]={-1,-1, 0, 0,+1,+1};

void solve(int i,int j,char ch)
{
    if(i>=n||j>=n)///Ei block(base case) ta must age hobe
    {
        if(i==n&&ch=='b')
            blk=true;
        if(j==n&&ch=='w')
            wht=true;
        return;
    }
    if(i<0||j<0||map[i][j]!=ch)///Ei base case ta pore...
        return;

    map[i][j]='.';
    for(int pos=0;pos<6;pos++)
        solve(i+dir_x[pos],j+dir_y[pos],ch);
}

int main()
{
    while(scanf("%d",&n)&&n)
    {
        getchar();
        for(int i=0;i<n;i++)
            gets(map[i]);

        blk=0;
        wht=0;
        for(int i=0;i<n;i++)
        {
            if(map[0][i]=='b')
                solve(0,i,map[0][i]);
            if(map[i][0]=='w')
                solve(i,0,map[i][0]);
        }
        printf("%d %c\n",case_no++,blk==1?'B':'W');
    }
    return 0;
}
