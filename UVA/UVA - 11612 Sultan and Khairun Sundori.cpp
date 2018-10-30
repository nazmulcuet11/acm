#include <iostream>
#include <cstdio>
#include <vector>
#include <queue>
#include <algorithm>
#define sqr(a) (a*a)
using namespace std;
struct P{int x,y,no; P(int a=0,int b=0){this->x=a;this->y=b;}void scan(){cin>>x>>y;}};
P MV(P a,P b){return P(b.x-a.x,b.y-a.y);}
double CP(P a,P b){return a.x*b.y-a.y*b.x;}
P pivot;
bool comp(P a,P b)
{
    double c=CP(MV(pivot,a),MV(pivot,b));
    if(c) return c>0;
    return (sqr(MV(pivot,a).x)+sqr(MV(pivot,a).y))<(sqr(MV(pivot,b).x)+sqr(MV(pivot,b).y));
}
int main()
{
    int n,index;
    while(cin>>n&&n)
    {
        vector<P> p;
        for(int i=0;i<n;i++)
        {
            P t;t.scan();t.no=i;
            p.push_back(t);
            if(i==0)
            {pivot=p[0];index=0;}
            else if(p[i].y<pivot.y||p[i].y==pivot.y&&p[i].x<pivot.x)
            {pivot=p[i];index=i;}
        }
        p[index]=p[0];
        p[0]=pivot;
        sort(p.begin(),p.end(),comp);
        queue<P> q;
        P temp=p.back();q.push(p.back());p.pop_back();
        while(!p.empty()&&CP(MV(pivot,temp),MV(pivot,p.back()))==0)
        {
            q.push(p.back());
            p.pop_back();
        }
        if(p.empty()){cout<<"no solution"<<endl;continue;}
        while(!q.empty()){p.push_back(q.front());q.pop();}
        for(int i=0;i<p.size();i++){if(p[i].no==0){index=i;break;}}
        int counter=0;
        while(counter<n){cout<<p[index].no<<" ";counter++;index=(index+1)%n;}
        cout<<p[index].no<<endl;
    }
    return 0;
}
