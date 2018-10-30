#include <iostream>

using namespace std;

int main()
{
    int tc,sum,n,dust;
    cin>>tc;
    for(int c=1;c<=tc;c++)
    {
        sum=0;
        cin>>n;
        while(n--)
        {
            cin>>dust;
            if(dust>0)
            sum+=dust;
        }
        cout<<"Case "<<c<<": "<<sum<<endl;
    }
    return 0;
}
