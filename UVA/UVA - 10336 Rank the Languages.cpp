#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;

struct data{char ch;int n;};

bool comp(data a,data b){if(a.n==b.n) return a.ch<b.ch;return a.n>b.n;}

int row,column,ans[97+27];
char map[1000+5][1000+5];

int dir_x[]={ 0, 0,+1,-1};
int dir_y[]={+1,-1, 0, 0};

void solve(int i,int j,char ch)
{
    if(i<0||j<0||i>=row||j>=column||map[i][j]!=ch)
        return;
    map[i][j]='*';
    for(int pos=0;pos<4;pos++)
        solve(i+dir_x[pos],j+dir_y[pos],ch);
}

int main()
{
    int test_case,case_no=1;
    for(scanf("%d",&test_case);test_case;test_case--)
    {
        scanf("%d %d",&row,&column);
        getchar();
        for(int i=0;i<row;i++)
            gets(map[i]);

        memset(ans,0,sizeof ans);
        for(int i=0;i<row;i++)
            for(int j=0;j<column;j++)
                 if(map[i][j]!='*')
                 {
                        ans[map[i][j]]++;
                        solve(i,j,map[i][j]);
                 }
        vector <data> v;
        for(int i='a';i<'z';i++)
            if(ans[i])
            {
                data obj;
                obj.ch=i;
                obj.n=ans[i];
                v.push_back(obj);
            }
        sort(v.begin(),v.end(),comp);
        printf("World #%d\n",case_no++);
        for(int i=0;i<v.size();i++)
            printf("%c: %d\n",v[i].ch,v[i].n);
    }
    return 0;
}
