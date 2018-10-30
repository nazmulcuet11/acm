#include <iostream>
#include <cstdio>
#include <cstring>

using namespace std;
char s[100000];
int main()
{
    long long int y4,y15,y55,y100,y400,f,l,t=0;
    while(scanf("%s",s)!=EOF)
    {
        if(t>0)
            cout<<endl;
        t++;
        y4=y15=y55=y100=y400=f=0;
        l=strlen(s);
        for(int i=0; i<l; i++)
        {
            y4=(y4*10+s[i]-'0')%4;
            y15=(y15*10+s[i]-'0')%15;
            y55=(y55*10+s[i]-'0')%55;
            y100=(y100*10+s[i]-'0')%100;
            y400=(y400*10+s[i]-'0')%400;
        }
        if((!y4&&y100)||!y400)
        {
            cout<<"This is leap year."<<endl;
            if(!y15)
                cout<<"This is huluculu festival year."<<endl;
            if(!y55)
                cout<<"This is bulukulu festival year."<<endl;
        }
        else
        {
            if(!y15)
                cout<<"This is huluculu festival year."<<endl;
            else
                cout<<"This is an ordinary year."<<endl;
        }
    }
    return 0;
}
