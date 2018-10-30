#include <iostream>

using namespace std;

int main()
{
    long long int  n,result;
    while(cin>>n)
    {
       result=(n*n*(n+1)*(n+1))/4;
       cout<<result<<endl;
    }
    return 0;
}
