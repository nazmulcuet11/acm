#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
#include <cstdio>
#include <cmath>
#define sqr(a) (a*a)
using namespace std;
struct P{int x,y;P(int a=0,int b=0){this->x=a;this->y=b;}void scan(){cin>>x>>y;}};
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
double find_area(vector<P> p){
    p.push_back(p[0]);
    double ans=0;
    for(int i=0;i<p.size()-1;i++)
        ans+=0.5*(p[i].x*p[i+1].y-p[i+1].x*p[i].y);
    return ans;
}
vector<P> convex_hall(vector<P> p)
{
    vector<P> s;
    s.push_back(p[0]);
    s.push_back(p[1]);
    s.push_back(p[2]);
    for(int i=3;i<p.size();i++)
    {
        P x=s.back();s.pop_back();
        P y=s.back();
        s.push_back(x);
        while(CP(MV(y,x),MV(y,p[i]))<0)
        {
            s.pop_back();
            if(s.size()>1){///Maksud vai size check korte bolse check na koreo AC paowa jay..
            x=s.back();s.pop_back();
            y=s.back();s.push_back(x);}
            else{x=s.back();y=s.back();}
        }
        s.push_back(p[i]);
    }
    return s;
}
int main()
{
    int n,index,c=1;
    while(cin>>n&&n)
    {
        vector<P> p;
        for(int i=0;i<n;i++){
            P t;t.scan();p.push_back(t);
            if(i==0){pivot=p[0];index=0;}
            else if(p[i].y<pivot.y||p[i].y==pivot.y&&p[i].x<pivot.x)
            {pivot=p[i];index=i;}}

        double area1=ABS(find_area(p));
        p[index]=p[0];
        p[0]=pivot;
        sort(p.begin(),p.end(),comp);
        vector<P> t=convex_hall(p);
        double area2=ABS(find_area(t));
        printf("Tile #%d\nWasted Space = %.2lf %%\n\n",c++,((area2-area1)*100)/area2);
    }
    return 0;
}
