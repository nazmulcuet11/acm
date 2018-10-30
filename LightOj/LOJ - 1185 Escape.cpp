#include <iostream>
#include <cstdio>
#include <cstring>
#include <vector>
#include <queue>
using namespace std;
vector<int>eadges[102];
bool walked[102],carried[102];
void bfs(int start)
{
    memset(walked,false,sizeof walked);
    memset(carried,false,sizeof carried);
    queue<int>q;
    q.push(start);
    for(int i=0;i<eadges[start].size();i++)
    {
        q.push(eadges[start][i]);
        walked[eadges[start][i]]=true;
    }
    while(!q.empty())
    {
        int t=q.front();
        q.pop();
        for(int i=0;i<eadges[t].size();i++)
        {
            if(carried[t]&&!walked[eadges[t][i]])
            {
                walked[eadges[t][i]]=true;
                q.push(eadges[t][i]);
            }
            else if(walked[t]&&!carried[eadges[t][i]])
            {
                carried[eadges[t][i]]=true;
                q.push(eadges[t][i]);
            }
        }
    }
}
int main()
{
    int test_case,n,m,counter;
    cin>>test_case;
    for(int i=1;i<=test_case;i++)
    {
        counter=0;
        cin>>n>>m;
        for(int j=0;j<m;j++)
        {
            int a,b;
            cin>>a>>b;
            eadges[a].push_back(b);
            eadges[b].push_back(a);
        }
        bfs(1);
        for(int i=1;i<=n;i++)
        {
            if(carried[i])
            counter++;
        }
        cout<<"Case "<<i<<": "<<counter<<endl;
        for(int i=0;i<102;i++)
        eadges[i].clear();
    }

}
