#include <stdio.h>

int main()
{
    int bf,af;
    double angle;
    while(scanf("%d:%d",&bf,&af)==2)
    {
        angle=0.00;
        if(bf==0&&af==0)
            break;

        else
        {
            angle=(bf*30.00-af*6.00+0.5*af);

            if(angle<0)
                angle=angle*-1;

            if(angle>180)
                angle=abs(360-angle);

            printf("%0.3lf\n",angle);
        }
    }
    return 0;
}
