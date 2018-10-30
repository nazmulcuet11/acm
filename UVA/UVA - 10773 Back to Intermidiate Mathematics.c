# include <stdio.h>
# include <math.h>
int main()
{
    int t,i;
    double min_time,min_distance,d,v,u;
    scanf("%d",&t);
    for(i=1; i<=t; i++)
    {
        scanf("%lf %lf %lf",&d,&v,&u);
        if(u==0||v==0||v>=u)
            printf("Case %d: can't determine\n",i);
        else
        {
            min_time = d/u;
            min_distance = d/sqrt(u*u-v*v);
            printf("Case %d: %.3lf\n",i, (min_distance-min_time));
        }
    }
    return 0;
}
