#include<stdio.h>
#include<string.h>

int main()
{
    int i,n;
    char s[31];
    char p[31];
    while(gets(s))
    {

        n=strlen(s);
        for(i=0;i<n;i++)
        {
        if(s[i]=='A'||s[i]=='B'||s[i]=='C')
        p[i]='2';
        else if(s[i]=='D'||s[i]=='E'||s[i]=='F')
        p[i]='3';
        else if(s[i]=='G'||s[i]=='H'||s[i]=='I')
        p[i]='4';
        else if(s[i]=='J'||s[i]=='K'||s[i]=='L')
        p[i]='5';
        else if(s[i]=='M'||s[i]=='N'||s[i]=='O')
        p[i]='6';
        else if(s[i]=='P'||s[i]=='Q'||s[i]=='R'||s[i]=='S')
        p[i]='7';
        else if(s[i]=='T'||s[i]=='U'||s[i]=='V')
        p[i]='8';
        else if(s[i]=='W'||s[i]=='X'||s[i]=='Y'||s[i]=='Z')
        p[i]='9';
        else
        p[i]=s[i];
        }
        p[i]='\0';

        puts(p);
        }

        return 0;
}
