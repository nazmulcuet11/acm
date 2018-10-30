#include <stdio.h>
#include <string.h>

int main()
{
    char s1[100000],s2[100000];
    int i,j,l;
    while(scanf("%s %s",s1,s2)==2)
    {
        l=strlen(s2);
        for(i=0,j=0;j<l;j++)
            if(s2[j]==s1[i])
                i++;
        if(i==strlen(s1))
            puts("Yes");
        else
            puts("No");
    }
    return 0;
}
