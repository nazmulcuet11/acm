#include <iostream>
#include <string.h>
#include <stdio.h>

using namespace std;

int main()
{
    int h=11;
    int l=0;
    int n;
    char statement[50];
    while(scanf("%d",&n)==1&&n!=0)
    {
        getchar();
        gets(statement);
        if(strcmp(statement,"too high")==0)
        {
            if(n<h)
                h=n;
        }
        else if(strcmp(statement,"too low")==0)
        {
            if(n>l)
                l=n;
        }
        else if(strcmp(statement,"right on")==0)
        {
            if(n>l&&n<h)
                cout<<"Stan may be honest"<<endl;
            else
                cout<<"Stan is dishonest"<<endl;

            h=11;
            l=0;
        }
    }
    return 0;
}
