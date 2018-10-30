#include <iostream>
#include <cstring>
#include <queue>
#include <vector>
using namespace std;
int counter=0,col,row;
char ch[22][22];
pair<int,int>p;
vector<pair<int,int> >v;
bool visited[22][22];
int bfs(pair<int,int> p)
{
    queue<pair<int,int> >q;
    q.push(p);
    visited[p.first][p.second]=true;
    counter++;
    while(!q.empty())
    {
        pair<int,int>t=q.front();
        q.pop();
        v.push_back(make_pair(t.first-1,t.second));
        v.push_back(make_pair(t.first,t.second-1));
        v.push_back(make_pair(t.first,t.second+1));
        v.push_back(make_pair(t.first+1,t.second));
        for(int i=0;i<v.size();i++)
        {
            pair<int,int>x=v[i];
            if(x.first>=0&&x.second>=0&&x.first<row&&x.second<col&&ch[x.first][x.second]=='.'&&!visited[x.first][x.second])
            {
                visited[x.first][x.second]=true;
                q.push(x);
                counter++;
            }
        }
        v.clear();
    }
    return counter;
}
int main()
{
    int test_case,m,n;
    cin>>test_case;
    for(int k=1; k<=test_case; k++)
    {
        memset(visited,false,sizeof visited);
        counter=0;
        cin>>col>>row;
        for(int i=0; i<row; i++)
            for(int j=0; j<col; j++)
            {
                cin>>ch[i][j];
                if(ch[i][j]=='@')
                {
                    p=make_pair(i,j);
                }
            }
            cout<<"Case "<<k<<": "<<bfs( p )<<endl;
    }
    return 0;
}
