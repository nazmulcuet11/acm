#include <iostream>
#include <cstdio>
#include <vector>
#include <queue>
#include <cmath>
#include <cstring>
using namespace std;
long long int prime[1025],a,b;
vector<int>factor[1025];
pair<int,int>p;
bool visited[1025];
void prime_generator()
{
    for(long long int i=1; i<1025; i+=2)
        prime[i]=1;
    prime[2]=1;
    for(long long int i=3; i<32; i+=2)
    {
        for(long long int j=i*3; j<1025; j=j+i)
            prime[j]=0;
    }
    return;
}
void factor_calculator()
{
    for(int i=1; i<1025; i++)
    {
        for(int j=2; j<i; j++)
        {
            if(prime[j]&&i%j==0)
                factor[i].push_back(j);
        }
    }
}
int bfs(pair<int,int>p)
{
    memset(visited,false,sizeof visited);
    queue<pair<int,int> >q;
    q.push(p);
    visited[p.first]=true;
    while(!q.empty())
    {
        pair<int,int>t=q.front();
        q.pop();
        if(t.first==b)
            return t.second;
        for(int i=0; i<factor[t.first].size(); i++)
        {
            if(t.first+factor[t.first][i]>b)
                break;
            if(!visited[t.first+factor[t.first][i]])
            {
                visited[t.first+factor[t.first][i]]=true;
                q.push(make_pair(t.first+factor[t.first][i],t.second+1));
            }
        }
    }
    return -1;
}
int main()
{
    prime_generator();
    factor_calculator();
    int test_case;
    cin>>test_case;
    for(int i=1; i<=test_case; i++)
    {
        memset(visited,false,sizeof visited);
        cin>>a>>b;
        p=make_pair(a,0);
        if(a==b)
            cout<<"Case "<<i<<": "<<"0"<<endl;
        else if(a>b)
            cout<<"Case "<<i<<": "<<"-1"<<endl;
        else
            cout<<"Case "<<i<<": "<<bfs(p)<<endl;
    }
}











