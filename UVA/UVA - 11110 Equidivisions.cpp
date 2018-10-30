#include <iostream>
#include <string>
#include <cstdio>
#include <sstream>

using namespace std;

int n,x,y,map[101][101],cnt;

int dir_x[]={ 0, 0,-1,+1};
int dir_y[]={-1,+1, 0, 0};

void dfs(int i,int j,int ch)
{
    if(i<0||j<0||i>=n||j>=n||map[i][j]!=ch)
        return;
    map[i][j]=0;
    cnt++;
    for(int pos=0;pos<4;pos++)
        dfs(i+dir_x[pos],j+dir_y[pos],ch);
}

int main()
{
    freopen("input.in","r",stdin);
    while(scanf("%d",&n)&&n)
    {
        getchar();
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                map[i][j]=n;

        for(int i=1; i<=n-1; i++)
        {
            string s;
            getline(cin,s);
            stringstream ss(s);
            while(ss>>x>>y)
            {
                map[x-1][y-1]=i;
            }
        }

        bool flag=true;
        for(int k=1;k<=n&&flag;k++)
            for(int i=0;i<n&&flag;i++)
                for(int j=0;j<n&&flag;j++)
                    if(map[i][j]==k)
                    {
                        cnt=0;
                        dfs(i,j,k);
                        if(cnt!=n)
                        {
                            flag=false;
                            break;
                        }
                    }
        flag==true?printf("good\n"):printf("wrong\n");
    }
    return 0;
}
