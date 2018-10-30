#include <iostream>
#include <vector>
#include <cstring>
using namespace std;
vector<int>eadges[1005];
int a[1005],total,count;
bool visited[1005];
void dfs(int n)
{
    visited[n]=true;
    total+=a[n];
    count++;
    for(int i=0; i<eadges[n].size(); i++)
        if(!visited[eadges[n][i]])
            dfs(eadges[n][i]);
}
int main()
{
    int test_csae,m,n,sum;
    cin>>test_csae;
    for(int i=1; i<=test_csae; i++)
    {
        sum=0;
        memset(visited,false,sizeof visited);
        cin>>m>>n;
        for(int i=1; i<=m; i++)
        {
            cin>>a[i];
            sum+=a[i];
        }
        for(int i=0; i<n; i++)
        {
            int a,b;
            cin>>a>>b;
            eadges[a].push_back(b);
            eadges[b].push_back(a);
        }
        bool flag=true;
        if(sum%m)
        flag=false;
        else
        {
            int avg=sum/m;
            for(int i=1;i<=m;i++)
            {
                total=count=0;
                if(!visited[i])
                dfs(i);
                if(count>0&&avg!=total/count)
                {
                    flag=false;
                    break;
                }
            }
        }
        if(flag)
            cout<<"Case "<<i<<": Yes"<<endl;
        else
            cout<<"Case "<<i<<": No"<<endl;
        for(int i=0; i<1005; i++)
            eadges[i].clear();
    }
    return 0;
}
