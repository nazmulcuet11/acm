#include<stdio.h>
#include<math.h>

int main()
{
    int n,count=1;

    while(scanf("%d",&n)==1)
    {
        if(n==0)
            break;
        else
        {
            double a,b,c,dis,acc;
            scanf("%lf%lf%lf",&a,&b,&c);


            if(n==1)
            {
                acc=(b-a)/c;
                dis=a*c+0.5*acc*c*c;
                }

            else if(n==2)
            {
                acc=(b-a)/c;
                dis=a*acc+0.5*c*acc*acc;
                }

            else if(n==3)
            {
                dis=(sqrt(a*a+2*b*c));
                acc=(dis-a)/b;
                }

            else if(n==4)
            {
                dis=(sqrt(a*a-2*b*c));
                acc=(a-dis)/b;
            }

            printf("Case %d: %.3lf %.3lf\n",count,dis,acc);
            count++;
        }
    }
    return 0;
}
