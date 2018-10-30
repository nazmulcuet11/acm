#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int dir_x[]= {1,0,-1, 0,-1,-1,+1,+1};
int dir_y[]= {0,1, 0,-1,-1,+1,-1,+1};

struct node
{
    ll x,y;
    node(ll x,ll y)
    {
        this->x=x;
        this->y=y;
    }
};

ll testCase,caseNo = 1,r,c,cost[205][205];
bool visited[200][205];
char mp[205][205];
queue<node>f_q;

void update()
{
    ll sz = f_q.size();
    for(ll j=0; j<sz; j++)
    {
        node f = f_q.front();
        f_q.pop();
        for(ll k=0; k<4; k++)
        {
            ll nfx = f.x+dir_x[k];
            ll nfy = f.y+dir_y[k];

            if(nfx<=0||nfx>r||nfy<=0||nfy>c) continue;
            if(mp[nfx][nfy]=='#'||mp[nfx][nfy]=='F') continue;
            mp[nfx][nfy] = 'F';

            f_q.push(node(nfx,nfy));
        }
    }
}

ll bfs()
{
    queue<node>j_q;
    memset(visited,false,sizeof visited);
    memset(cost,0,sizeof cost);
    while(!f_q.empty())
        f_q.pop();

    for(ll i=0; i<=r; i++)
        for(ll j=0; j<=c; j++)
        {
            if(mp[i][j]=='J')
                j_q.push(node(i,j)),visited[i][j] = true;
            if(mp[i][j]=='F')
                f_q.push(node(i,j));
        }

    while(!j_q.empty())
    {
        ll sz = j_q.size();
        for(ll i=0; i<sz; i++)
        {
            node t = j_q.front();
            j_q.pop();
            if(t.x<=0||t.x>=r+1||t.y<=0||t.y>=c+1) return cost[t.x][t.y];
            if(mp[t.x][t.y]=='F') continue;///already cathced by fire;

            for(ll i=0; i<4; i++)
            {
                ll new_x = t.x+dir_x[i];
                ll new_y = t.y+dir_y[i];

                if(new_x<0||new_x>r+1||new_y<0||new_y>c+1) continue;
                if(visited[new_x][new_y]) continue;
                if(mp[new_x][new_y]!='.') continue;

                visited[new_x][new_y] = true;
                cost[new_x][new_y] = cost[t.x][t.y]+1;
                j_q.push(node(new_x,new_y));
            }
        }
        update();
    }

    return -1;
}

int main()
{
    cin>>testCase;
    while(testCase--)
    {
        cin>>r>>c;

        for(ll i=0; i<=r+1; i++)
            for(ll j=0; j<=c+1; j++)
                mp[i][j] = '.';

        for(ll i=1; i<=r; i++)
            for(ll j=1; j<=c; j++)
                cin>>mp[i][j];

        cout<<"Case "<<caseNo++<<": ";
        ll ans=bfs();
        if(ans!=-1)
            cout<<ans<<"\n";
        else
            cout<<"IMPOSSIBLE\n";
    }
    return 0;
}
