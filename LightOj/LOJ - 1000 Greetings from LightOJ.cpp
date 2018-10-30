#include <iostream>
#include <stdio.h>

using namespace std;

int main()
{
    int test_case,a,b;
    cin>>test_case;
    for(int i=1;i<=test_case;i++)
    {
        cin>>a;
        cin>>b;
        cout<<"Case "<<i<<": "<<a+b<<endl;
    }
    return 0;
}
