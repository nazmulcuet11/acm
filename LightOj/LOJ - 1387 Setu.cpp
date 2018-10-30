#include <iostream>
#include <string>

using namespace std;

int main()
{
    int tc,n,amount,sum;
    string str;
    cin>>tc;
    for(int c=1;c<=tc;c++)
    {
        sum=0;
        cin>>n;
        cout<<"Case "<<c<<":"<<endl;
        while(n--)
        {
            cin>>str;
            if(str=="donate")
            {
                cin>>amount;
                sum+=amount;
            }
            else
            cout<<sum<<endl;
        }
    }
    return 0;
}
