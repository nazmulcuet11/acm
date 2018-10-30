#include<stdio.h>
#include<math.h>

int main()
{
    int t,i;
    double l,w,r,a_t,a_r,a_g;
    scanf("%d",&t);

    for(i=0; i<t; i++)
    {
        scanf("%lf",&l);
        w=0.6*l;
        r=0.2*l;

        a_t=l*w;
        a_r=acos(-1)*r*r;
        a_g=a_t-a_r;

        printf("%.2lf %.2lf\n",a_r,a_g);
    }
    return 0;
}
