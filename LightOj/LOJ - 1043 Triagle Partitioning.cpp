#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cmath>
#define sqr(a) (a*a)
#define eps 1e-11
using namespace std;
int main()
{
    int test_case;
    double ab,ac,bc,ratio;
    cin>>test_case;
    for(int i=1;i<=test_case;i++)
    {
        cin>>ab>>ac>>bc>>ratio;
        double s=(ab+ac+bc)/2;
        double height=(2*sqrt(s*(s-ab)*(s-ac)*(s-bc)))/bc;
        double area1=sqrt(s*(s-ab)*(s-ac)*(s-bc));
        double area2=0.5*height*bc;
        double x=(sqr(ab)-sqr(ac)+sqr(bc))/(2*bc);
        double y=(sqr(ac)-sqr(ab)+sqr(bc))/(2*bc);
        double tan_theta1=height/x;
        double tan_theta2=height/y;
        double high=height;
        double low=0;
        double mid,x_prime,y_prime;
        while(high>=low+eps)
        {
            mid=(low+high)/2;
            x_prime=(height-mid)/tan_theta1;
            y_prime=(height-mid)/tan_theta2;
            area1=0.5*(height-mid)*(x_prime+y_prime);
            area2=0.5*mid*(x_prime+y_prime+bc);
            if(fabs(area1-ratio*area2)==0) break;
            if(area1>ratio*area2) low=mid;
            else high=mid;

        }
        double a=height-mid;
        double ans=sqrt(sqr(a)+sqr(x_prime));
        printf("Case %d: %.10lf\n",i,ans);
    }
    return 0;
}
