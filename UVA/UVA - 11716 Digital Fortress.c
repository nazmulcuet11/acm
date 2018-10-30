#include<stdio.h>
#include<string.h>
#include<math.h>

int main()
{
    long int z,i,k,m,u,t,p,y;
    char s[10000];
    scanf("%d",&z);
    getchar();

    for(y=0; y<z; y++)
    {
        gets(s);
        i=strlen(s);
        k=sqrt(i);
        m=k*k;

        if(i!=m)
        printf("INVALID\n");

        else
        {
            char a[k][k],b[i];
            p=0;

            for(u=0; u<k; u++)
            {
                for(t=0; t<k; t++)
                {
                    a[u][t]=s[p];
                    p++;
                }
            }

            for(u=0; u<k; u++)
            {
                for(t=0; t<k; t++)
                {
                    printf("%c",a[t][u]);
                }
            }
            printf("\n");
        }
    }

    return 0;
}
