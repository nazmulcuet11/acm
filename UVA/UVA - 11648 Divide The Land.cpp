#include <iostream>
#include <cmath>
#include <cstdio>
#define sqr(a) (a*a)
#define eps 1e-7
#define EPSILON 1e-7
using namespace std;
bool CompareDoubles2 (double A, double B){ return fabs(A-B)<EPSILON;}
int main()
{
    double test_case,AB,CD,AD,BC;
    cin>>test_case;
    for(int i=1;i<=test_case;i++)
    {
        cin>>AB>>CD>>AD>>BC;
        double d=AB-CD;
        double x=(sqr(AD)-sqr(BC)+sqr(d))/(2*d);
        double y=(sqr(BC)-sqr(AD)+sqr(d))/(2*d);
        double h=sqrt(sqr(AD)-sqr(x));
        double tan_theta1=h/x;
        double tan_theta2=h/y;
        double high=h,low=0,mid,AE,BF,x_p,y_p;
        double area=0.5*(AB+CD)*h;
        int j=0;
        while(high>=low+eps)
        {
            mid=(high+low)/2;
            x_p=mid/tan_theta1;
            y_p=mid/tan_theta2;
            double EF=AB-x_p-y_p;
            double area1=0.5*(AB+EF)*mid;
            if(area<2*area1) high=mid;
            else if(area>2*area1) low=mid;
            if(CompareDoubles2(area,2*area1))
                break;
        }
        AE=sqrt(sqr(x_p)+sqr(mid));
        BF=sqrt(sqr(y_p)+sqr(mid));
        printf("Land #%d: %lf %lf\n",i,AE,BF);
    }
    return 0;
}
