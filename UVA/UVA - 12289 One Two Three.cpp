#include <iostream>
#include <stdio.h>
#include <string.h>

using namespace std;

int main()
{
    int test_case;
    char ch[6];
    cin>>test_case;
    getchar();
    while(test_case--)
    {
        gets(ch);
        if(strlen(ch)>3)
        cout<<'3'<<endl;
        else
        {
            int count=0;
           if(ch[0]!='o')count++;
           if(ch[1]!='n')count++;
           if(ch[2]!='e')count++;

           if(count>1)
           cout<<'2'<<endl;
           else
           cout<<'1'<<endl;
        }
    }
    return 0;
}

