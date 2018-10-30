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
void calculate_point(P a,P b,P c,P d)
{
    double x=(CP(a,b)*(c.x-d.x)-(a.x-b.x)*CP(c,d))/((a.x-b.x)*(c.y-d.y)-(a.y-b.y)*(c.x-d.x));
    double y=(CP(a,b)*(c.y-d.y)-(a.y-b.y)*CP(c,d))/((a.x-b.x)*(c.y-d.y)-(a.y-b.y)*(c.x-d.x));
    printf("POINT %.2lf %.2lf\n",x,y);
}
int main()
{
    int test_case;
    cin>>test_case;
    cout<<"INTERSECTING LINES OUTPUT"<<endl;
    P a,b,c,d;
    while(test_case--)
    {
        cin>>a.x>>a.y>>b.x>>b.y;
        cin>>c.x>>c.y>>d.x>>d.y;
        double v1=CP(MV(a,b),MV(a,c));
        double v2=CP(MV(a,b),MV(a,d));
        double v3=CP(MV(c,d),MV(c,a));
        double v4=CP(MV(c,d),MV(c,b));
        if(CP(MV(a,b),MV(c,d))==0)
        {
            if(CP(MV(a,b),MV(a,c))==0)
            cout<<"LINE"<<endl;
            else
            cout<<"NONE"<<endl;
        }
        else
            calculate_point(a,b,c,d);
    }
    cout<<"END OF OUTPUT"<<endl;
}
