#include <iostream>
#include <cstdio>

using namespace std;

int main()
{
    unsigned long long int a,b,c;
    while(scanf("%llu %llu",&a,&b)!=EOF)
    {
        c=a^b;
        cout<<c<<endl;
    }
    return 0;
}
