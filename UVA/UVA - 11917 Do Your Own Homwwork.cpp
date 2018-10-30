#include <iostream>
#include <map>
#include <string>

using namespace std;

int main()
{
    int test_case,c=1;
    cin>>test_case;
    while(test_case--)
    {
        int n,t,d;
        map<string,int>mp;
        string s;
        cin>>n;
        while(n--)
        {
            cin>>s>>t;
            mp[s]=t;
        }
        cin>>d;
        cin>>s;
        if(mp.find(s)==mp.end())
        cout<<"Case "<<c++<<": Do your own homework!"<<endl;
        else if(mp[s]>(d+5))
        cout<<"Case "<<c++<<": Do your own homework!"<<endl;
        else if(mp[s]>d&&mp[s]<=d+5)
        cout<<"Case "<<c++<<": Late"<<endl;
        else if(mp[s]<=d)
        cout<<"Case "<<c++<<": Yesss"<<endl;
    }
    return 0;
}
