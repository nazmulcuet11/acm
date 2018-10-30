#include <iostream>
#include <stdio.h>
#include <cstring>
#include <string>

using namespace std;

int main()
{
    char input[500000];
    long long int testcase,sum=0,current;
    scanf("%lld",&testcase);
    while(testcase--)
    {
        scanf("%s",input);

        if(strcmp(input,"report")==0)
        cout<<sum<<endl;

        else
        {
            scanf("%lld",&current);
            sum+=current;
        }
    }
    return 0;
}
