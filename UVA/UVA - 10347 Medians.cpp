#include <stdio.h>
#include <math.h>
int main()
{
    double u,v,w,s, area, a;
    while(scanf("%lf %lf %lf", &u, &v, &w)==3)
    {
        s=(u+v+w)/2.0;
        area=(4.0/3.0)*(sqrt(s*(s-u)*(s-v)*(s-w)));
        if(area>0)
            printf("%.3lf\n", area);
        else
        {   area=-1;
            printf("%.3lf\n", area);
        }
    }
    return 0;
}
