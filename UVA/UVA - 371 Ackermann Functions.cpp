#include <iostream>
#include <cstring>

using namespace std;

long long int acekerman(long long int n)
{
    if(n==1)
        return 0;
    if(n%2==0)
        return acekerman(n/2)+1;
    else if(n%2!=0)
        return acekerman(n*3+1)+1;
}

void swap(long long int &a,long long int &b)
{
    long long int t=a;a=b;b=t;
}
int main()
{
    long long int a,b,max,index;
    while((cin>>a>>b)&&(a&&b))
    {
        max=0,index=0;
        if(a>b)
        swap(a,b);
        for(long long int i=a; i<=b; i++)
        {
            if(i==1)
            {
                max=3;index=1;
            }
            long long int l=acekerman(i);
            if(max<l)
                {
                    index=i;
                    max=l;
                }
        }
        cout<<"Between "<<a<<" and "<<b<<", "<<index<<" generates the longest sequence of "<<max<<" values."<<endl;
    }
    return 0;
}
