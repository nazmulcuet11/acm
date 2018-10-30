#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <algorithm>
#include <cstdio>
using namespace std;
int r;
string s,ans;
vector<char> v;
void combination(int start)
{
    if(ans.size()==r)
    {
        cout<<ans<<endl;
        return;
    }
    for(int i=start; i<s.size(); i++)
    {
        ans.push_back(s[i]);
        combination(i+1);
        ans.erase(ans.end()-1);
        while(s[i]==s[i+1]) i++;
    }
}
int main()
{
    while(cin>>s>>r)
    {
        ans.clear();
        sort(s.begin(),s.end());
        combination(0);
    }
    return 0;
}
