#include<stdio.h>

int main()
{
    int time1,time2;
    int h1,h2,m1,m2;

    while(scanf("%d%d%d%d",&h1,&m1,&h2,&m2)==4)
    {
        if(h1==0&&h2==0&&m1==0&&m2==0)
            break;
        else
        {

        if(h2==0&&h1>0)
        h2=24;

            time1=h1*60+m1;
            time2=h2*60+m2;

            if(time2>time1)
            printf("%d\n",time2-time1);

            else
            printf("%d\n",1440+time2-time1);

        }
    }

}

