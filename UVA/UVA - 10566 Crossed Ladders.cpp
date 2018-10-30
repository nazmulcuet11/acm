#include <iostream>
#include <cmath>
#include <cstdio>
#include <algorithm>
#define eps 1e-7
using namespace std;

int main()
{
    double x,y,height;
    while(cin>>x>>y>>height)
    {
        double high=min(x,y),low=0,mid;
        while(high>=low+eps)
        {
            mid=(high+low)/2;
            double land=(height/tan(acos(mid/y)))+(height/tan(acos(mid/x)));
            if(land>mid)
            high=mid;
            else if(land<mid)///Angle joto komano jabe, vumi tato barbe..
            low=mid;
            else if(fabs(land-mid)<eps)
            break;
        }
        printf("%0.3lf\n",mid);
    }
    return 0;
}
