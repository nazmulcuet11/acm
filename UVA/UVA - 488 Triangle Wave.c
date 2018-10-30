#include <stdio.h>

int main()
{
    long long int frequency;
    int amplitude,i,j,k,test_case,t;

    scanf("%d",&test_case);

    for(t=1; t<=test_case; t++)
    {
        if(t!=1)
        printf("\n");

        scanf("%d",&amplitude);
        scanf("%lld",&frequency);

        for(k=1; k<=frequency; k++)
        {
            if(k!=1)
                printf("\n");

            for(i=1; i<=amplitude; i++)
            {
                for(j=1; j<=i; j++)
                {
                    printf("%d",i);
                }
                printf("\n");
            }

            for(i=i-2; i>=1; i--)
            {
                for(j=1; j<=i; j++)
                {
                    printf("%d",i);
                }
                printf("\n");
            }
        }
    }
    return 0;
}
