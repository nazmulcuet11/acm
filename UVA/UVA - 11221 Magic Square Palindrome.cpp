#include <iostream>
#include <stdio.h>
#include <string.h>
#include <math.h>

using namespace std;

int main()
{
    int testcase,side,l,flag,i,j,k,p;
    char s[10005],a[10005],inv[10005],rev_s[10005],rev_inv[10005];
    cin>>testcase;
    getchar();
    for(p=1;p<=testcase;p++)
    {
        cout<<"Case #"<<p<<":"<<endl;
        flag=0;
        gets(a);
        l=strlen(a);
        for(i=0,j=0;i<l;i++)
        {
            if(a[i]>='a'&&a[i]<='z')
                s[j++]=a[i];
        }
        s[j]='\0';
        side=sqrt(strlen(s));
        if(side*side==strlen(s))
        {
            k=0;
            for(i=0;i<side;i++)
            {
                for(j=0;j<side;j++)
                    inv[k++]=s[j*side+i];
            }
           inv[k]='\0';
           l=strlen(s);
           for(i=l-1,j=0,k=0;i>=0;i--)
           {
               rev_s[j++]=s[i];
               rev_inv[k++]=inv[i];
           }
           rev_s[j]='\0';
           rev_inv[k]='\0';
           if(strcmp(rev_s,s)==0&&strcmp(rev_inv,inv)==0&&strcmp(inv,s)==0)
           {
               cout<<side<<endl;
           }
           else
           cout<<"No magic :("<<endl;
        }
        else
        {
        cout<<"No magic :("<<endl;
        }
    }
    return 0;
}
