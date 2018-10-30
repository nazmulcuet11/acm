#include<stdio.h>
#include<string.h>

int main()
{
    int t,i,j,m,n,k,l;

    char a[5000];
    char b[5000];

    scanf("%d",&t);
    getchar();

    for(i=0; i<t; i++)
    {
        gets(a);
        gets(b);

        m=strlen(a);
        n=strlen(b);

        if(m!=n)
            printf("No\n");
        else
        {
            for(l=0,j=0; j<m; j++)
            {
                if(a[j]=='a'||a[j]=='e'||a[j]=='i'||a[j]=='o'||a[j]=='u')
                {
                    if(b[j]=='a'||b[j]=='e'||b[j]=='i'||b[j]=='o'||b[j]=='u')
                        l=j;

                    else
                        break;

                }

                else
                {
                    if(a[j]==b[j])
                        l=j;

                    else
                        break;
                }

            }
            if((l+1)==m)
                printf("Yes\n");

            else
                printf("No\n");
        }
    }
    return 0;
}
