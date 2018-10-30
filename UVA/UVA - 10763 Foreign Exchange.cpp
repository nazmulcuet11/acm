#include <iostream>
#include <algorithm>
using namespace std;
long long int u[500001],v[500001];
int main()
{
    long long int n;
    while(cin>>n&&n)
    {
        bool f=true;
        for(int i=0; i<n; i++)
            cin>>u[i]>>v[i];
        sort(u,u+n);
        sort(v,v+n);
        for(int i=0; i<n; i++)
            if(u[i]!=v[i])
                f=false;
        if(f)
            cout<<"YES"<<endl;
        else
            cout<<"NO"<<endl;
    }
    return 0;
}
