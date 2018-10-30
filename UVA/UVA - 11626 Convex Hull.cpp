#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstdio>
#include <cmath>
#define sqr(a) (a*a)
using namespace std;
struct P{long long int x,y;P(long long int a=0,long long int b=0){this->x=a;this->y=b;}};
P MV(P a,P b){return P(b.x-a.x,b.y-a.y);}
double CP(P a,P b){return a.x*b.y-a.y*b.x;}
double ABS(double a){if(a<0)return -a;return a;}
P pivot;
bool comp(P a,P b)
{
    double c=CP(MV(pivot,a),MV(pivot,b));
    if(c) return c>0;
    return sqrt((sqr(MV(pivot,a).x)+sqr(MV(pivot,a).y)))<sqrt((sqr(MV(pivot,b).x)+sqr(MV(pivot,b).y)));
}
int main()
{
    long int test_case,n,index;
    cin>>test_case;
    while(test_case--)
    {
        cin>>n;
        vector<P> p;
        for(int i=0;i<n;i++)
        {
            long long int x,y;
            char ch;
            cin>>x>>y>>ch;
            if(ch=='Y')
            p.push_back(P(x,y));
        }
        for(int i=0;i<p.size();i++)
        {
            if(i==0){pivot=p[0];index=0;}
            else if(p[i].x<pivot.x||(p[i].x==pivot.x&&p[i].y<pivot.y))
            {pivot=p[i];index=i;}
        }
        p[index]=p[0];
        p[0]=pivot;
        sort(p.begin(),p.end(),comp);
        cout<<p.size()<<endl;
        queue<P> q;
        P temp=p.back();q.push(p.back());p.pop_back();
        while(!p.empty()&&CP(MV(pivot,temp),MV(pivot,p.back()))==0)
        {
            q.push(p.back());
            p.pop_back();
        }
        while(!q.empty()){p.push_back(q.front());q.pop();}
        for(int i=0;i<p.size();i++)
            cout<<p[i].x<<" "<<p[i].y<<endl;
    }
    return 0;
}
