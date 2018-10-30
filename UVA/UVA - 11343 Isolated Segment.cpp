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
        int m;
        cin>>m;
        int x1,y1,x2,y2,sum=0;
        memset(isolated,true,sizeof isolated);
        segment s[100];
        for(int i=0;i<m;i++){
            cin>>x1>>y1>>x2>>y2;
            s[i].a=P(x1,y1);
            s[i].b=P(x2,y2);}
        for(int i=0;i<m-1;i++){
            for(int j=i+1;j<m;j++){
                bool f=is_collided(s[i],s[j]);
                if(f)
                {
                    if(isolated[i])
                    {
                        isolated[i]=false;
                        sum++;
                    }
                    if(isolated[j])
                    {
                        isolated[j]=false;
                        sum++;
                    }
                }
            }
        }
        cout<<m-sum<<endl;
    }
    return 0;
}
