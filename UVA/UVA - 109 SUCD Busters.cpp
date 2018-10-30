#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
#include <cstdio>
#include <cmath>
#define sqr(a) (a*a)
using namespace std;
struct P{int x,y;P(int a=0,int b=0){this->x=a;this->y=b;}void scan(){cin>>x>>y;}};
P MV(P a,P b){return P(b.x-a.x,b.y-a.y);}
double CP(P a,P b){return a.x*b.y-a.y*b.x;}
double ABS(double a){if(a<0)return -a;return a;}
double DIST(P a,P b){return sqrt(sqr(MV(a,b).x)+sqr(MV(a,b).y));}
bool destroyed[1000];
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
bool is_in_convexhull(vector<P> p, P a)
{
    P piv=p[0];
    int i=1;
    while(i<p.size()&&CP(MV(piv,p[i]),MV(piv,a))>0)
        i++;
    if(i>=p.size()||i==1)
        return false;
    double x=DIST(piv,p[i-1]);
    double y=DIST(piv,p[i]);
    if(DIST(piv,a)<=max(x,y))
    return true;
    return false;
}
int main()
{
    int n,index,i=0;
    vector<double> area;
    vector<vector<P> > kingdom;
    memset(destroyed,false,sizeof destroyed);
    while(cin>>n&&n!=-1)
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
        kingdom.push_back(convex_hall(p));
        area.push_back(find_area(kingdom[i]));
        i++;
    }
    int x,y,number_of_kingdom=i;
    vector<P> missile;
    double total_area_destroyed=0;
    while(scanf("%d%d",&x,&y)==2)
    {
        missile.push_back(P(x,y));
    }
    for(int i=0;i<missile.size();i++)
        for(int j=0;j<number_of_kingdom;j++)
            if(!destroyed[j]&&is_in_convexhull(kingdom[j],missile[i]))
                destroyed[j]=true;
    for(int i=0;i<number_of_kingdom;i++)
        if(destroyed[i])
            total_area_destroyed+=area[i];
    printf("%0.2lf\n",total_area_destroyed);
    return 0;
}
