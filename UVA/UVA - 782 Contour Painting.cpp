#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>
#include <algorithm>
#include <cstdlib>
#include <cassert>

using namespace std;

char inp[35][85];
string s;
int row=0,column=0,row_len[35];

int dir_x[]={ 0, 0,-1,+1,-1,-1,+1,+1};
int dir_y[]={-1,+1, 0, 0,-1,+1,-1,+1};

///*********************************
bool check(int i,int j)
{
    for(int pos=0;pos<4;pos++)
    {
        int x=i+dir_x[pos];
        int y=j+dir_y[pos];

        if(x<0||x>=row||y<0||y>=85)
            continue;
        else
        {
            if(inp[x][y]!=' '&&inp[x][y]!='#'&&inp[x][y]!='*')
                return true;
        }
    }
    return false;
}
///**********End of check************


void solve(int i,int j)
{
    if(i<0||i>=row||j<0||j>=85||inp[i][j]!=' '
       ||inp[i][j]=='*'||inp[i][j]=='#')
        return;

    if(check(i,j)==true)
    {
        inp[i][j]='#';
        //row_len[i]=max(row_len[i],j+1);
    }
    else
        inp[i][j]='*';

    for(int pos=0;pos<4;pos++)
        solve(i+dir_x[pos],j+dir_y[pos]);
}
///**********End of solve**************


void print_solution()
{
    for(int i=0;i<row;i++)
    {
        for(int j=0;j<row_len[i];j++)
        {
            printf("%c",inp[i][j]);
        }
        printf("\n");
    }
}
///**********End of print-solution***************

void remove_trailing_space();

int main()
{
    int test_case,calling_i,calling_j;
    bool found;

    for(scanf("%d",&test_case),getchar();test_case;test_case--)
    {
        row=0;
        found=false;
        while(getline(cin,s)&&s[0]!='_')
        {
            row_len[row]=s.size();
            for(int i=0;i<s.size();i++)
            {
                inp[row][i]=s[i];
                if(s[i]=='*')
                {
                    calling_i=row;
                    calling_j=i;
                    inp[row][i]=' ';
                }
            }
            row++;
        }

        for(int i=0;i<row;i++)
            for(int j=row_len[i];j<85;j++)
                inp[i][j]=' ';


        solve(calling_i,calling_j);

        remove_trailing_space();

        print_solution();
        cout<<s<<endl;
    }
    return 0;
}
///***********End of main************

void remove_trailing_space()
{
    for(int i=0;i<row;i++)
        for(int j=0;j<85;j++)
            if(inp[i][j]=='*')
                inp[i][j]=' ';
    for(int i=0;i<row;i++)
    {
        for(int j=84;j>=0;j--)
        {
            if(inp[i][j]!=' ')
                break;
            //inp[i][j]=0;
            row_len[i]=j;
        }
    }
}
///********End of remove_trailing_space****
