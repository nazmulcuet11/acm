#include<stdio.h>
#include<string.h>

int main()
{
    int t,i,n,j,k,z,sum;
    char s[25];
    int a[25];
    int c[25];
    int d[25];
    while(scanf("\n%d",&t)==1)
    {
        scanf("\n");
        for(z=0; z<t; z++)
        {
            scanf("\n");
            sum=0;
            gets(s);
            n=strlen(s);
            for(j=0,i=0; i<n; i++)
            {
                if(s[i]!=' ')
                {
                    a[j]=s[i]-48;
                    j++;
                }

            }


            for(k=0,i=j-1; i>=0; i=i-1,k++)
            {
                if((j-i)%2==0)
                    {
                    c[k]=a[i]*2;
                    }
                else
                    c[k]=a[i];

                if(c[k]>9)
                {
                    c[k]=(c[k]/10)+(c[k]%10);
                }

                sum=sum+c[k];

            }


            if(sum%10==0)
            printf("Valid\n");

            else
            printf("Invalid\n");

        }
    }
    return 0;
}
