#include<stdio.h>
#include<string.h>

int main()
{
    int t,i,r,n,j,count;
    char s[50000];

    scanf("%d",&t);
    getchar();

    for(i=0; i<t; i++)
    {
        count=0;
        gets(s);
        n=strlen(s);

        for(j=0; j<n; j++)
        {
            if(s[j]=='a'||s[j]=='d'||s[j]=='g'||
                    s[j]=='j'||s[j]=='m'||s[j]=='p'||
                    s[j]=='t'||s[j]=='w'||s[j]==' ')
                count=count+1;

            else if(s[j]=='b'||s[j]=='e'||s[j]=='h'||
                    s[j]=='k'||s[j]=='n'||s[j]=='q'||
                    s[j]=='u'||s[j]=='x')
                count=count+2;

            else if(s[j]=='s'||s[j]=='z')
                count=count+4;
            else
                count=count+3;
        }
        printf("Case #%d: %d\n",i+1,count);
    }
return 0;
}
