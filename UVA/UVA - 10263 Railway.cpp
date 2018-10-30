#include <iostream>
#include <cmath>
#include <cstdio>
using namespace  std;
struct P
{
    double x,y;
    P(double x=0,double y=0){this->x=x;this->y=y;}
};
P MV(P a,P b){return P((b.x-a.x),(b.y-a.y));}
P ADD(P a,P b){return P(a.x+b.x,a.y+b.y);}
double DP(P a,P b){return a.x*b.x+a.y*b.y;}
double CP(P a,P b){return a.x*b.y-a.y*b.x;}
double ABS(P a){return sqrt(DP(a,a));}
double DIST(P a,P b){return sqrt(MV(a,b).x*MV(a,b).x+MV(a,b).y*MV(a,b).y);}
P Line_segment(P a,P b,P m)
{
    if(DP(MV(a,b),MV(a,m))<0)return a;
    if(DP(MV(b,a),MV(b,m))<0)return b;
    double l=(DP(MV(a,b),MV(a,m))/ABS(MV(a,b)));
    return ADD(P(((MV(a,b).x*l)/ABS(MV(a,b))),((MV(a,b).y*l)/ABS(MV(a,b)))),a);
}
int main()
{
    P M,a,b,temp,result;
    int n,index;
    while(cin>>M.x>>M.y)
    {
        double dis=99999999;
        cin>>n;
        cin>>a.x>>a.y;
        for(int i=0;i<n;i++)
        {
            cin>>b.x>>b.y;
            temp=Line_segment(a,b,M);
            if(DIST(M,temp)<dis)
            {
                dis=DIST(M,temp);
                result=temp;
            }
            a=b;
        }
        printf("%.4lf\n%.4lf\n",result.x,result.y);
    }
}
