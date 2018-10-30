#include <stdio.h>

int main()
{
    int day;
    double U, D, H, F,distance_climbed,height_after_climbing,height_after_sliding,initial_height;

    while(scanf("%lf %lf %lf %lf", &H, &U, &D, &F)==4)
    {
        if(H==0)
            break;
        F=F/100;
        distance_climbed=U;
        day=0;
        height_after_sliding=0;
        height_after_climbing=0;
        initial_height=0;
        while(1)
        {
            if(distance_climbed<0)
                distance_climbed=0;

            day++;
            height_after_climbing=initial_height+distance_climbed;
            height_after_sliding=height_after_climbing-D;

            if(height_after_climbing>H)
            {
                printf("success on day %d\n", day);
                break;
            }

            if(height_after_sliding<0)
            {
                printf("failure on day %d\n", day);
                break;
            }

            initial_height=height_after_sliding;
            distance_climbed=distance_climbed-(F*U);
        }
    }
    return 0;
}
