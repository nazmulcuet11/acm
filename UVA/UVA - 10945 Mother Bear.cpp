#include <iostream>
#include <string.h>
#include <stdio.h>

using namespace std;

int main()
{
    int l,i,j,k;
    char ch,s[100000],a[100000],b[100000];
    while(gets(s)&&strcmp(s,"DONE"))
    {
        l=strlen(s);
        for(i=0,j=0,k=0; i<l; i++)
        {
            if(s[i]>='a'&&s[i]<='z')
                a[j++]=s[i]-'a'+'A';
            if(s[i]>='A'&&s[i]<='Z')
                a[j++]=s[i];
            if(s[l-1-i]>='a'&&s[l-1-i]<='z')
                b[k++]=s[l-1-i]-'a'+'A';
            if(s[l-1-i]>='A'&&s[l-1-i]<='Z')
                b[k++]=s[l-1-i];

        }
        a[j]='\0';
        b[k]='\0';
        if(!strcmp(a,b))
            cout<<"You won't be eaten!"<<endl;
        else
            cout<<"Uh oh.."<<endl;
    }
    return 0;
}
