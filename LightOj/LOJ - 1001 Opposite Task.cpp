#include <iostream>
#include <stdio.h>

using namespace std;

int main()
{
    int testcase,a;
    cin>>testcase;
    while(testcase--)
    {
    cin>>a;
    if(a>10)
    cout<<a-10<<" "<<10<<endl;
    else
    cout<<0<<" "<<a<<endl;
    }
    return 0;
}
