#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstdio>
#include <cmath>
#define sqr(a) (a*a)
using namespace std;
struct P{double x,y,z;P(double a=0,double b=0,double c=0){this->x=a;this->y=b;this->z=c;}void scan(){cin>>x>>y>>z;}};
P MV(P a,P b){return P(b.x-a.x,b.y-a.y,b.z-a.z);}
P CP(P a,P b){return P(a.y*b.z-b.y*a.z,a.z*b.x-a.x*b.z,a.x*b.y-a.y*b.x);}
double DP(P a,P b){return a.x*b.x+a.y*b.y+a.z*b.z;}
double DIST(P a,P b){return sqrt(sqr(MV(a,b).x)+sqr(MV(a,b).y)+sqr(MV(a,b).z));}
double ABS(P a){return sqrt(DP(a,a));}

int main()
{
    int n,cs=1;
    bool point_above,point_below;
    P p[27];
    while(cin>>n&&n)
    {
        for(int i=0;i<n;i++)
            p[i].scan();
        double area=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                for(int k=j+1;k<n;k++)
                {
                    point_above=point_below=false;
                    P c=CP(MV(p[i],p[j]),MV(p[i],p[k]));
                    for(int l=0;l<n;l++)
                    {
                        double d=DP(c,MV(p[i],p[l]));
                        if(d>0)
                        point_above=true;
                        if(d<0)
                        point_below=true;
                    }
                    if(!point_above||!point_below)
                    area+=(ABS(c)*0.5);
                }
            }
        }
        printf("Case %d: %.2lf\n",cs++,area);
    }
    return 0;
}
