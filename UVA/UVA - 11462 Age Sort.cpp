#include<algorithm>
#include<iostream>
#include<cstdio>

long long int arr[2000000];
using namespace std;
int main()
{
    long long int i,test;
    while(1)
    {
        cin>>test;
        if(test==0)
            break;

        for(i=0; i<test; i++)
        {
            cin>>arr[i];
        }
        std::sort(arr,arr+test);
        for(i=0; i<test-1; i++)
        {
            cout<<arr[i]<<" ";
        }
        cout<<arr[test-1];
        cout<<"\n";
    }
    return 0;
}
