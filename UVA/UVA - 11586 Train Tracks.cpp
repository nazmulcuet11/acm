//Most fowl problem...
#include <iostream>
#include <cstdio>
#include <cstring>

using namespace std;

int main()
{
    int testcase,i,l,flag,mm,ff;
    char s[200];
    cin>>testcase;
    getchar();
    while(testcase--)
    {   flag=mm=ff=0;
        gets(s);
        l=strlen(s);
        for(i=0;i<l-1;i++)
        {
            if(s[i]=='M'&&s[i+1]=='M')
            mm++;
            else if(s[i]=='F'&&s[i+1]=='F')
            ff++;
            if(s[i]==' ')
            flag++;
        }
        if(mm==ff&&flag>0)
        cout<<"LOOP"<<endl;
        else
        cout<<"NO LOOP"<<endl;
    }
    return 0;
}
