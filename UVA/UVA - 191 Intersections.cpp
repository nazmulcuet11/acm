#include <iostream>
#include <cmath>
#include <cstdio>
#include <cstring>
using namespace  std;
struct P
{
    double x,y;
    P(double x=0,double y=0){this->x=x;this->y=y;}
};
struct segment
{ P a,b;};
P MV(P a,P b){return P((b.x-a.x),(b.y-a.y));}
double CP(P a,P b){return a.x*b.y-a.y*b.x;}
bool isolated[102];
bool is_in_middle(P a,P b,P c)
{
    if(min(a.x,b.x)<=c.x&&c.x<=max(a.x,b.x)&&
       min(a.y,b.y)<=c.y&&c.y<=max(a.y,b.y))
        return true;
    return false;
}
bool is_collided(segment a,segment b)
{
    double v1=CP(MV(a.a,a.b),MV(a.a,b.a));
    if(!v1&&is_in_middle(a.a,a.b,b.a)) return true;
    double v2=CP(MV(a.a,a.b),MV(a.a,b.b));
    if(!v2&&is_in_middle(a.a,a.b,b.b)) return true;
    double v3=CP(MV(b.a,b.b),MV(b.a,a.a));
    if(!v3&&is_in_middle(b.a,b.b,a.a)) return true;
    double v4=CP(MV(b.a,b.b),MV(b.a,a.b));
    if(!v4&&is_in_middle(b.a,b.b,a.b)) return true;
    if(v1*v2<0&&v3*v4<0) return true;
    return false;
}
int main()
{
    int test_case;
    cin>>test_case;
    while(test_case--){
        P s,e,a,b,c,d;
        segment seg1,seg2;
        bool flag=false;
        int m,n,o,p,x1,y1,x2,y2;
        cin>>m>>n>>o>>p>>x1>>y1>>x2>>y2;
        s=P(m,n);e=P(o,p);a=P(x1,y2);b=P(x2,y2);c=P(x2,y1);d=P(x1,y1);
        seg1.a=s;seg1.b=e;
        seg2.a=a;seg2.b=b;
        if(is_collided(seg1,seg2))flag=true;
        seg2.a=b;seg2.b=c;
        if(is_collided(seg1,seg2))flag=true;
        seg2.a=c;seg2.b=d;
        if(is_collided(seg1,seg2))flag=true;
        seg2.a=d;seg2.b=a;
        if(is_collided(seg1,seg2))flag=true;
        if(min(d.x,b.x)<=s.x&&s.x<=max(d.x,b.x)&&min(b.y,d.y)<=s.y&&s.y<=max(b.y,d.y)) flag=true;
        if(flag) cout<<"T"<<endl;
        else cout<<"F"<<endl;
    }
    return 0;
}
