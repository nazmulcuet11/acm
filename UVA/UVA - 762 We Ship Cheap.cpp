/**Bismillahir Rahmanir Rahim**/
/**
 *    @author     : Nazmul Islam
 *    @College    : CUET CSE 11
 *    @Topcoder   : nazmul_islam
 *    @CodeForces : nazmul_islam
 *    @UVA        : nazmul_cuet11
 *    @link       : https://www.facebook.com/nazmul.shohagh
 */

#include <bits/stdc++.h>

using namespace std;

typedef long long          ll;
typedef unsigned long long llu;

#define ft        first
#define sd        second
#define mp        make_pair
#define pb(x)     push_back(x)
#define lcm(x,y)  x*y/__gcd(x,y)
#define all(x)    x.begin(),x.end()
#define allr(x)   x.rbegin(),x.rend()
#define MAX(a)    (*max_element(all(a)))
#define MIN(a)    (*min_element(all(a)))
#define mem(a,b)  memset(a,b,sizeof(a))
#define inf       1e9
#define eps       1e-9
#define mod       1000000007
#define NN        30100

int dir_x[]= {1,0,-1, 0,-1,-1,+1,+1};
int dir_y[]= {0,1, 0,-1,-1,+1,-1,+1};

map <string,int> mp1;
map <int,string> mp2;
vector<ll> graph[100000];
vector<string> ans;
bool visited[100000],found;
ll par[100000];

void bfs(string s,string d)
{
    ll source=mp1[s],dest=mp1[d];
    queue<ll>q;
    mem(visited,false);
    mem(par,-1);
    q.push(source);
    visited[source]=true;
    while(!q.empty())
    {
        ll u=q.front();
        q.pop();
        for(ll i=0; i<graph[u].size(); i++)
        {
            ll v=graph[u][i];
            if(!visited[v])
            {
                visited[v]=true;
                par[v]=u;
                q.push(v);
            }
            if(v==dest)
            {
                found=true;
                break;
            }
        }
        if(found)
            break;
    }
}

void print_path(ll a)
{
    if(par[a]==-1)
    {
        ans.pb(mp2[a]);
        return;
    }
    print_path(par[a]);
    ans.pb(mp2[a]);
}

void clear()
{
    for(ll i=0; i<100000; i++)
        graph[i].clear();
    mp1.clear();
    mp2.clear();
    ans.clear();
}

int main()
{
    ll no_of_links,count_node,case_no=1;
    string parent,child,source,dest;
    while(cin>>no_of_links)
    {
        count_node=1;
        for(ll i=0; i<no_of_links; i++)
        {
            cin>>parent>>child;
            if(!mp1[parent])
            {
                mp2[count_node]=parent;
                mp1[parent]=count_node++;
            }
            if(!mp1[child])
            {
                mp2[count_node]=child;
                mp1[child]=count_node++;
            }
            graph[mp1[parent]].pb(mp1[child]);
            graph[mp1[child]].pb(mp1[parent]);
        }
        cin>>source>>dest;

        //cout<<mp1[source]<<" "<<mp1[dest];
        if(!mp1[source])
        {
            mp2[count_node]=source;
            mp1[source]=count_node++;
        }
        if(!mp1[dest])
        {
            mp2[count_node]=dest;
            mp1[dest]=count_node++;
        }
        if(case_no>1)
            cout<<"\n";
        case_no++;
        if(source==dest)
            cout<<source<<" "<<source<<"\n";
        else
        {
            found=false;
            bfs(source,dest);
            if(!found)
                cout<<"No route\n";
            else
            {
                print_path(mp1[dest]);
                for(ll i=1; i<ans.size(); i++)
                    cout<<ans[i-1]<<" "<<ans[i]<<"\n";
            }
        }
        clear();
    }
    return 0;
}
