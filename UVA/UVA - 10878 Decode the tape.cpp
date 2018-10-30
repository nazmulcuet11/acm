#include <stdio.h>
#include<string.h>

char ch[20];
char ch1[100000];
long j=0,l;

int main()
{
	gets(ch);
	while (gets(ch)&&ch[0]=='|')
	{
		long i;
		long n=0;
        for(i=1;ch[i]!='|';i++)
		{
			if(ch[i]=='o')
				n=n*2+1;
			if(ch[i]==' ')
				n=n*2;
		}
        ch1[j]=n;
		j++;
	}
	ch1[j]='\0';
	printf("%s",ch1);
	return 0;
}
