#include <iostream>
#include <cstdio>

using namespace std;

int main()
{
    unsigned long long int diff,n;
    while(1)
    {
        cin>>diff;
        if(diff==0)
        break;
        n=(diff*10)/9;
        if(((n-1)-(n-1)/10)==diff)
        cout<<n-1<<" ";
        cout<<n<<endl;
    }
    return 0;
}
