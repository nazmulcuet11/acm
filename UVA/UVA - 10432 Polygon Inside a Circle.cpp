#include <iostream>
#include <cstdio>
#include <cmath>

#define pi 2*acos(0.0)
using namespace std;

int main()
{
    double r,n,s;
    while(cin>>r>>n)
    {
        s=(n*r*r*sin((2*pi)/n))/2;
        printf("%.3lf\n",s);
    }
    return 0;
}
