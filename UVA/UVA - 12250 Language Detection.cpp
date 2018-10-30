#include <iostream>
#include <stdio.h>
#include <string.h>

using namespace std;

int main()
{
    int c=1;
    char s[15];
    while(scanf("%s",s)==1)
    {
        if(s[0]=='#')
        break;

        if(strcmp(s,"HELLO")==0)
        cout<<"Case "<<c<<":"<<" ENGLISH"<<endl;
        else if(strcmp(s,"HOLA")==0)
        cout<<"Case "<<c<<":"<<" SPANISH"<<endl;
        else if(strcmp(s,"HALLO")==0)
        cout<<"Case "<<c<<":"<<" GERMAN"<<endl;
        else if(strcmp(s,"BONJOUR")==0)
        cout<<"Case "<<c<<":"<<" FRENCH"<<endl;
        else if(strcmp(s,"CIAO")==0)
        cout<<"Case "<<c<<":"<<" ITALIAN"<<endl;
        else if(strcmp(s,"ZDRAVSTVUJTE")==0)
        cout<<"Case "<<c<<":"<<" RUSSIAN"<<endl;
        else
        cout<<"Case "<<c<<":"<<" UNKNOWN"<<endl;

        getchar();
        c++;
    }
    return 0;
}
