#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int dir_x[]={1,0,-1, 0,-1,-1,+1,+1};
int dir_y[]={0,1, 0,-1,-1,+1,-1,+1};

ll testCase,caseNo = 1,N,start_i,start_j,total_move = 0,cost[15][15];
char mp[15][15];
bool visited[15][15];
vector<char>food_list;

struct node
{
    ll u,v;
    node(ll u,ll v){this->u=u;this->v=v;}
};

bool bfs(ll i,ll j,char ch)
{
    memset(visited,false,sizeof visited);
    memset(cost,0,sizeof cost);

    queue<node>q;

    q.push(node(i,j));
    visited[i][j]=true;
    cost[i][j] = 0;
    mp[i][j] = '.';

    while(!q.empty())
    {
        node temp = q.front();q.pop();

        if(mp[temp.u][temp.v]==ch)
        {
            total_move+=cost[temp.u][temp.v];
            start_i = temp.u;
            start_j = temp.v;
            return true;
        }

        for(ll pos=0;pos<4;pos++)
        {
            ll new_x = temp.u+dir_x[pos];
            ll new_y = temp.v+dir_y[pos];

            if(new_x<0||new_x>=N||new_y<0||new_y>=N) continue;
            if(visited[new_x][new_y]) continue;
            if(mp[new_x][new_y]!='.'&&mp[new_x][new_y]!=ch) continue;

            cost[new_x][new_y] = cost[temp.u][temp.v]+1;
            visited[new_x][new_y] = true;
            q.push(node(new_x,new_y));
         }
    }

    return false;
}

int main()
{
    cin>>testCase;
    while(testCase--)
    {
        cin>>N;
        for(ll i=0;i<N;i++)
            for(ll j=0;j<N;j++)
            {
                cin>>mp[i][j];
                if(mp[i][j]=='A')
                    start_i = i,start_j = j;
                if(mp[i][j]>='A'&&mp[i][j]<='Z')
                    food_list.push_back(mp[i][j]);
            }


        sort(food_list.begin(),food_list.end());

        total_move = 0;
        bool isPossible = true;

        for(ll i=1;i<food_list.size();i++)
            if(!bfs(start_i,start_j,food_list[i]))
            {
                isPossible = false;
                break;
            }

        cout<<"Case "<<caseNo++<<": ";
        if(!isPossible)
            cout<<"Impossible\n";
        else
            cout<<total_move<<"\n";

        food_list.clear();
    }
    return 0;
}
