#include <iostream>
#include <vector>
#include <map>
#include <string>
#include <cstring>

using namespace std;

struct graph
{
    string u,v;
};

map <string,string> parent;
vector<graph> g;

string find_parent(string par);
void clear();

int main()
{
    int t,n;
    cin>>t;
    for(int tc=1; tc<=t; tc++)
    {
        cin>>n;
        for(int i=0; i<n; i++)
        {
            graph ob;
            cin>>ob.u>>ob.v;
            parent[ob.u]=ob.u;
            parent[ob.v]=ob.v;
            g.push_back(ob);
        }
        bool flag=true;
        for(int i=0; i<g.size(); i++)
        {
            string a=find_parent(g[i].u);
            string b=find_parent(g[i].v);
            if(a==b)
            {
                flag=false;
                break;
            }
            parent[b]=a;
        }
        if(flag) cout<<"Case "<<tc<<": Yes"<<endl;
        else cout<<"Case "<<tc<<": No"<<endl;
        clear();
    }
    return 0;
}

void clear()
{
    g.clear();
    parent.clear();
}

string find_parent(string par)
{
    if(parent[par]==par) return par;
    return parent[par]=find_parent(parent[par]);
}
