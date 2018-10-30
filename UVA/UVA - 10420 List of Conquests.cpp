#include <iostream>
#include <map>
#include <string>

using namespace std;

int main()
{
    string s1,s2;
    map<string,int>mp;
    int test_case;
    cin>>test_case;
    while(test_case--)
    {
        cin>>s1;
        mp[s1]++;
        getline(cin,s2);
    }
    for(map<string,int>::iterator ita=mp.begin(); ita!=mp.end(); ita++)
        cout<<ita->first<<" "<<ita->second<<endl;
    return 0;
}
