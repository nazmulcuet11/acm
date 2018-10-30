#include <iostream>
#include <cstdio>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

int row,column,cnt;
int map[30][30];
string s;

int dir_x[]={-1,+1, 0, 0,-1,-1,+1,+1};
int dir_y[]={ 0, 0,-1,+1,-1,+1,-1,+1};

void solve(int i,int j)
{
    if(i<0||j<0||i>=row||j>=column||map[i][j]!=1)
        return;
    map[i][j]=0;
    cnt++;
    for(int pos=0;pos<8;pos++)
        solve(i+dir_x[pos],j+dir_y[pos]);
}

int main()
{
    freopen("input.in","r",stdin);
    int test_case,ans,case_no=1;
    for(scanf("%d",&test_case)&&getchar()&&getchar();test_case;test_case--)
    {

        row=0;
        while(getline(cin,s)&&s!="")
        {
            column=s.size();
            for(int i=0;i<s.size();i++) map[row][i]=s[i]-'0';
            row++;
        }
        ans=0;
        for(int i=0;i<row;i++)
            for(int j=0;j<column;j++)
                if(map[i][j]==1)
                {
                    cnt=0;
                    solve(i,j);
                    ans=max(ans,cnt);
                }
        if(case_no>1) printf("\n");
        printf("%d\n",ans);
        case_no++;
    }
    return 0;
}
