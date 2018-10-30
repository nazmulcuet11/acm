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
typedef struct { P a,b; void scan(){cin>>a.x>>a.y>>b.x>>b.y;}}segment;
P MV(P a,P b){return P((b.x-a.x),(b.y-a.y));}
double CP(P a,P b){return a.x*b.y-a.y*b.x;}
bool isolated[1005];
bool is_on_segment(P a,P b,P c)
{
    if(min(a.x,b.x)<=c.x&&c.x<=max(a.x,b.x)&&
       min(a.y,b.y)<=c.y&&c.y<=max(a.y,b.y))
        return true;
    return false;
}
bool is_segment_intersect(segment a,segment b)
{
    double v1=CP(MV(a.a,a.b),MV(a.a,b.a));
    if(!v1&&is_on_segment(a.a,a.b,b.a)) return true;
    double v2=CP(MV(a.a,a.b),MV(a.a,b.b));
    if(!v2&&is_on_segment(a.a,a.b,b.b)) return true;
    double v3=CP(MV(b.a,b.b),MV(b.a,a.a));
    if(!v3&&is_on_segment(b.a,b.b,a.a)) return true;
    double v4=CP(MV(b.a,b.b),MV(b.a,a.b));
    if(!v4&&is_on_segment(b.a,b.b,a.b)) return true;
    if(v1*v2<0&&v3*v4<0) return true;
    return false;
}
int main()
{
    int n;
    segment s[1005];
    while(cin>>n&&n)
    {
        int ans=0,sum=0;
        memset(isolated,true,sizeof isolated);
        for(int i=0;i<n;i++)
            s[i].scan();
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            if(is_segment_intersect(s[i],s[j]))
            {
                ans++;
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
        cout<<ans+(n-sum)*2<<endl;
    }
    return 0;
}
