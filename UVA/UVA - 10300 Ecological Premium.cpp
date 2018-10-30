#include <iostream>

using namespace std;

int main()
{
    long long int ans,test_case,farmer,land,animal,premium;
    for(cin>>test_case;test_case;test_case--)
    {
        ans=0;
        for(cin>>farmer;farmer;farmer--)
        {
            cin>>land>>animal>>premium;
            ans+=land*premium;
        }
        cout<<ans<<endl;
    }
    return 0;
}
