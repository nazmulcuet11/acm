#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

struct data{char ch;int n;};

bool comp(data a,data b)
{
    if(a.n==b.n) return a.ch<b.ch;
    return a.n>b.n;
}

int row,colum,case_no=1,cnt;
char map[51][51];

int dir_x[]={+1,-1, 0, 0};
int dir_y[]={ 0, 0,+1,-1};

void solve(int i,int j,char ch)
{
    if(i<0||j<0||i>=row||j>=colum||map[i][j]!=ch)
        return;
    map[i][j]='.';
    cnt++;
    for(int pos=0;pos<4;pos++)
        solve(i+dir_x[pos],j+dir_y[pos],ch);
}

int main()
{
    while(scanf("%d %d",&row,&colum)&&(row||colum))
    {
        getchar();
        for(int i=0;i<row;i++)
            gets(map[i]);

        vector<data> v;
        for(int i=0;i<row;i++)
            for(int j=0;j<colum;j++)
                if(map[i][j]!='.')
                {
                    data obj;
                    obj.ch=map[i][j];
                    cnt=0;
                    solve(i,j,map[i][j]);
                    obj.n=cnt;
                    v.push_back(obj);
                }
        sort(v.begin(),v.end(),comp);
        printf("Problem %d:\n",case_no++);
        for(int i=0;i<v.size();i++)
            printf("%c %d\n",v[i].ch,v[i].n);
    }
    return 0;
}
