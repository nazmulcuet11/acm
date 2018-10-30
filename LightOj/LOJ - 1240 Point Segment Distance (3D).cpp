#include <iostream>
#include <algorithm>
#include <cmath>
#include <cstdio>
#define sqr(a) (a*a)
using namespace std;
struct P{double x,y,z;P(double x=0,double y=0,double z=0){this->x=x;this->y=y;this->z=z;}void scan(){cin>>x>>y>>z;}};
P MV(P a,P b){return P(b.x-a.x,b.y-a.y,b.z-a.z);}
P CP(P a,P b){return P(a.y*b.z-b.y*a.z,a.z*b.x-a.x*b.z,a.x*b.y-a.y*b.x);}
double DP(P a,P b){return a.x*b.x+a.y*b.y+a.z*b.z;}
double DIST(P a,P b){return sqrt(sqr(MV(a,b).x)+sqr(MV(a,b).y)+sqr(MV(a,b).z));}
double ABS(P a){return sqrt(DP(a,a));}
int main()
{
    int test_case;
    cin>>test_case;
    for(int i=1;i<=test_case;i++)
    {
        P a,b,p;
        double d;
        a.scan();b.scan();p.scan();
        if(DP(MV(a,b),MV(a,p))<0)
        d=DIST(a,p);
        else if(DP(MV(b,a),MV(b,p))<0)
        d=DIST(b,p);
        else
            d=ABS(CP(MV(a,b),MV(a,p)))/ABS((MV(a,b)));
        printf("Case %ld: %.10lf\n",i,d);///Baler problem...4 ta wa only .10lf er jaygay .lf deyay...
    }
    return 0;
}
