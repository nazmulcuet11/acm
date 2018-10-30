#include <iostream>
#include <algorithm>

using namespace std;
int myfn(int n){if(n<0)return n+100;return n;}
int main()
{
    int a,b,x,y;
    while(cin>>a>>b&&a!=-1&&b!=-1)
    {
        x=myfn(a-b);
        y=myfn(b-a);
        cout<<min(x,y)<<endl;
    }
    return 0;
}
