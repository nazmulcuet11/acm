#include <iostream>

using namespace std;

int main()
{
    long long int n,s;
    while(cin>>n&&n)
    {
        s=(n*(n+1)*(2*n+1))/6;
        cout<<s<<endl;
    }
    return 0;
}
