#include<stdio.h>
#include<string.h>

int main()
{
    int t,i,k,n,j,m;
    char s[5000],p[5000];
    char a[5000];

    scanf("%d",&t);
    getchar();
    for(i=0; i<t; i++)
    {
        gets(s);
        gets(p);

        n=strlen(s);
        m=strlen(p);

        if(strcmp(s,p)==0)
            printf("Case %d: Yes\n",i+1);

        else
        {

            for(j=0,k=0; j<n; j++,k++)
            {
                if(s[j]==' ')
                    k=k-1;

                else
                    a[k]=s[j];

            }
            a[k]=0;

            if(strcmp(a,p)==0)
                printf("Case %d: Output Format Error\n",i+1);

            else
                printf("Case %d: Wrong Answer\n",i+1);

        }

    }
    return 0;
}
