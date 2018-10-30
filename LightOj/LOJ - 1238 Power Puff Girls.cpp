#include <bits/stdc++.h>

using namespace std;
typedef long long ll;


#define inf 99999999

int dir_x[]={1,0,-1, 0,-1,-1,+1,+1};
int dir_y[]={0,1, 0,-1,-1,+1,-1,+1};

ll testCase,caseNo = 1,r,c;

char mp[25][25];
bool visited[25][25];

struct node
{
    ll x,y,cost;
    node(ll a = 0,ll b=0,ll cost = 0)
    {
        this->x = a;
        this->y = b;
        this->cost = cost;
    }
};


ll bfs(ll i,ll j)
{
    memset(visited,false,sizeof visited);
    queue<node>q;
    q.push(node(i,j,0));
    visited[i][j] = true;

    while(!q.empty())
    {
        node u = q.front(); q.pop();
        if(mp[u.x][u.y]=='h') return u.cost;
        for(ll pos=0;pos<4;pos++)
        {
            ll new_x = u.x+dir_x[pos];
            ll new_y = u.y+dir_y[pos];

            if(new_x<0||new_x>r||new_y<0||new_y>c||mp[new_x][new_y]=='m'||
               mp[new_x][new_y]=='#'||visited[new_x][new_y])
                    continue;

            q.push(node(new_x,new_y,u.cost+1));
            visited[new_x][new_y] = true;
        }
    }
}

int main()
{
    cin>>testCase;
    while(testCase--)
    {
        cin>>r>>c;
        for(ll i=0;i<r;i++)
            for(ll j=0;j<c;j++)
                cin>>mp[i][j];

        ll ans = 0;
        for(ll i=0;i<r;i++)
            for(ll j=0;j<c;j++)
            {
                if(mp[i][j]=='a'||
                   mp[i][j]=='b'||
                   mp[i][j]=='c')
                    ans=max(ans,bfs(i,j));
            }
        cout<<"Case "<<caseNo++<<": "<<ans<<"\n";
    }
    return 0;
}
