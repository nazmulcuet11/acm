#include<bits/stdc++.h>

#define pb(x) push_back(x)
#define mem(x,y) memset(x,y,sizeof(x))

typedef long long ll;
using namespace std;

#define SZ 110

vector<ll>graph[SZ];
set<ll>arti;

ll discoveryTime[SZ],low[SZ],parent[SZ],noOfChild[SZ];
ll cnt = 0;
bool visited[SZ];

void assignDiscovery(ll u)
{
    if(visited[u])
        return;
    visited[u] = true;
    discoveryTime[u] = low[u] = ++cnt;
    for(ll i=0;i<graph[u].size();i++)
    {
        ll v = graph[u][i];
        if(!visited[v])
        {
            parent[graph[u][i]] = u;
            noOfChild[u]++;
            assignDiscovery(graph[u][i]);
        }
    }
}

void assignLow(ll u)
{
    visited[u] = true;
    ll mn = 9999999999;
    for(ll i=0;i<graph[u].size();i++)
    {
        ll v = graph[u][i];
        if(!visited[v])
            assignLow(v);

        if(parent[u]!=v)
            mn =  min(mn,low[v]);
    }
    low[u] = mn;
}

void findArti(ll u)
{
    /*if(visited[u])
        return;*/
    visited[u] = true;
    for(ll i=0;i<graph[u].size();i++)
    {
        ll v = graph[u][i];
        if(!visited[v])
        {
            if(discoveryTime[u]<=low[v])
            {
                arti.insert(u);
            }
            findArti(v);
        }
    }
}

int main()
{
    //freopen("out.txt","w",stdout);
    ll n,i,j,k;
    ll cn = 1;
    while(cin>>n&&n)
    {
        getchar();
        string str,s;
        //cout<<"\n"<<cn++<<": ";
        //cout<<n<<"\n";
        while(getline(cin,str))
        {
            //cout<<str<<"\n";
            if(str=="0")
                break;

            string s="";
            vector<ll>vec;
            for(i=0;i<str.size();i++)
            {
                if(str[i]!=' ')
                {
                    s+=str[i];
                }
                else
                {
                    ll temp =0;
                    for(ll j=0;j<s.size();j++)
                        temp = temp*10+s[j]-'0';
                    vec.pb(temp);
                    s = "";
                }
            }

            ll temp =0;
            for(ll j=0;j<s.size();j++)
                temp = temp*10+s[j]-'0';
            vec.pb(temp);
            s = "";

            for(i=1;i<vec.size();i++)
            {
                graph[vec[0]].pb(vec[i]);
                graph[vec[i]].pb(vec[0]);
            }
        }

        /*for(i=1;i<=n;i++)
        {
            cout<<i<<"-->";
            for(j=0;j<graph[i].size();j++)
                cout<<graph[i][j]<<" ";
            cout<<"\n";
        }*/

        cnt = 0;
        memset(visited,false,sizeof visited);
        memset(parent,-1,sizeof parent);
        memset(noOfChild,0,sizeof noOfChild);
        assignDiscovery(1);
        memset(visited,false,sizeof visited);
        assignLow(1);
        memset(visited,false,sizeof visited);
        findArti(1);

        /*for(i=1;i<=n;i++)
            cout<<discoveryTime[i]<<" ";
        cout<<"\n";
        for(i=1;i<=n;i++)
            cout<<low[i]<<" ";
        cout<<"\n";

        set<ll>::iterator ita;
        for(ita = arti.begin();ita!=arti.end();ita++)
            cout<<*ita<<" ";
        cout<<"\n";*/

        ll ans = arti.size();
        if(noOfChild[1]<=1)
            ans--;
        cout<<ans<<"\n";

        arti.clear();
        for(i=0;i<SZ;i++)
            graph[i].clear();
    }
    return 0;
}
