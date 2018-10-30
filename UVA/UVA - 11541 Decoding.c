#include <stdio.h>
#include <string.h>

int main()
{
    char ch,s[50000];
    int i,t,n,length,j,k;
    scanf("%d",&t);
    for(k=1; k<=t; k++)
    {
        scanf("\n");
        n=0;
        gets(s);
        length=strlen(s);
        printf("Case %d: ",k);
        for(i=0; i<length; )
        {
            if(s[i]>='A'&&s[i]<='Z')
            {
                ch=s[i];
                i++;
            }
            else
            {
            while(s[i]>='0'&&s[i]<='9')
            {
                n=n*10+s[i]-48;
                i++;
            }
            }

            if(n!=0)
            {
                for(j=0; j<n; j++)
                    printf("%c",ch);

                n=0;
            }

        }
        printf("\n");
    }
    return 0;
}
