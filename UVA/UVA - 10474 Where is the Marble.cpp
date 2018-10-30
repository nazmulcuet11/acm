#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    int n,q,a[10005],p,c=1;
    while(cin>>n>>q&&(n||q))
    {
        cout<<"CASE# "<<c++<<":"<<endl;
        for(int i=0; i<n; i++)
            cin>>a[i];
        sort(a,a+n);
        while(q--)
        {
            bool found=false;
            cin>>p;
            for(int i=0; i<n&&a[i]<=p;i++)
                if(a[i]==p)
                {
                    found=true;
                    cout<<p<<" found at "<<i+1<<endl;
                    break;
                }
            if(!found)
            cout<<p<<" not found"<<endl;
        }
    }
    return 0;
}
