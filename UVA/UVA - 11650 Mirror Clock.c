#include<stdio.h>

int main()
{
    int t,h,m,i,temp,hr,min;
    char c;
    scanf("%d",&t);

    for(i=0; i<t; i++)
    {
        scanf("%d%c%d",&h,&c,&m);
        temp=h*60+m;

        if(temp>720)
        {
            temp=780-temp;
            hr=11;
        }

        else
        {
            temp=720-temp;
            hr=temp/60;
        }

        min=temp%60;
        if(hr==0)
            hr=12;

        printf("%.2d:%.2d\n",hr,min);

    }
    return 0;
}
