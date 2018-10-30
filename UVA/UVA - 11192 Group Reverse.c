#include<stdio.h>
#include<string.h>

int main()
{
    char t,s[200],temp[200],final[200];
    int length,i,j,k,g,m;

    while(scanf("%d",&g)==1)
    {
        if(g==0)
        break;

        getchar();
        gets(s);
        length=strlen(s);
        k=length/g;
        m=k;
        for(i=0; i<length;)
        {
            for(j=k-1; j>(i-1); j--)
            {
                t=s[j];
                printf("%c",s[j]);
            }
            i=k;
            k=k+m;
        }
        printf("\n");
    }
    return 0;
}
