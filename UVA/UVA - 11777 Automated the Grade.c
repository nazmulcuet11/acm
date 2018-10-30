#include<stdio.h>
int main()
{
    int t,i;
    while(scanf("%d",&t)==1)
    {
        for(i=1; i<=t; i++)
        {
            int a,b,c,d,e,f,g,marks,temp;
            scanf("%d%d%d%d%d%d%d",&a,&b,&c,&d,&e,&f,&g);

            if(e>=f&&e>=g)
            {
                if(f>=g)
                    temp=(e+f)/2;
                else
                    temp=(e+g)/2;
            }

            else if(f>=g)
            {
                if(e>=g)
                    temp=(f+e)/2;
                else
                    temp=(f+g)/2;
            }
            else
            {
                if(e>=f)
                    temp=(g+e)/2;
                else
                    temp=(g+f)/2;
            }

            marks=a+b+c+d+temp;

            if(marks>=90)
                printf("Case %d: A\n",i);
            else if(marks>=80&&marks<90)
                printf("Case %d: B\n",i);
            else if(marks>=70&&marks<80)
                printf("Case %d: C\n",i);
            else if(marks>=60&&marks<70)
                printf("Case %d: D\n",i);
            else if(marks<60)
                printf("Case %d: F\n",i);

        }
    }
}
