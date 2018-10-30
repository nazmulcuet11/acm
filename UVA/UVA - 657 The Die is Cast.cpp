#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

int w,h,throw_no=1,cnt;
char input[51][51];
vector <int> v;

void solve1(int i,int j)
{
    if(i>=h||j>=w||i<0||j<0) return;
    if(input[i][j]=='.'||input[i][j]=='*') return;
    input[i][j]='*';
    solve1(i,j-1);///Left
    solve1(i,j+1);///Right
    solve1(i-1,j);///Up
    solve1(i+1,j);///Down
}

void solve(int i,int j)
{
    if(i>=h||j>=w||i<0||j<0) return;
    if(input[i][j]=='.') return;
    if(input[i][j]=='X')
    {
        cnt++;
        solve1(i,j);
    }
    input[i][j]='.';
    solve(i,j-1);///Left
    solve(i,j+1);///Right
    solve(i-1,j);///Up
    solve(i+1,j);///Down
}

int main()
{

    while(scanf("%d %d",&w,&h)==2&&(w||h))
    {
        for(int i=0; i<h; i++)
        {
            getchar();
            for(int j=0; j<w; j++)
                scanf("%c",&input[i][j]);
        }

        for(int i=0; i<h; i++)
        {
            for(int j=0; j<w; j++)
            {
                if(input[i][j]!='.')
                {
                    cnt=0;
                    solve(i,j);
                    v.push_back(cnt);
                }
            }
        }
        sort(v.begin(),v.end());
        printf("Throw %d\n",throw_no++);
        for(int i=0;i<v.size();i++)
        {
            printf("%d",v[i]);
            i==v.size()-1?printf("\n\n"):printf(" ");
        }
        v.clear();
    }
    return 0;
}
