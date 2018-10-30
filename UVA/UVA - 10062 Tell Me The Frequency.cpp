#include <iostream>
#include <string>
#include <algorithm>
#include <map>

using namespace std;

struct tell_me_frequency
{
    int aschii,frequency;
};
bool better(tell_me_frequency x,tell_me_frequency y)
{
    if(x.frequency<y.frequency)
        return true;
    else if(x.frequency==y.frequency&&x.aschii>y.aschii)
        return true;
    return false;
}
int main()
{
    bool first=true;
    string s;
    map<char,int> mp;
    tell_me_frequency t[1000];
    while(getline(cin,s))
    {
        if(!first)
        cout<<endl;
        for(int i=0; i<s.size(); i++)
            mp[s[i]]++;
        int i=0;///i k porer line a for er moddhe init kora jabe na,cs i int bt ita itaretor type variable same type hole hoto
        for(map<char,int>::iterator ita=mp.begin();ita!=mp.end();ita++,i++)
        {
            t[i].aschii=ita->first;
            t[i].frequency=ita->second;
        }
        int size_of_t=i;
        sort(t,t+size_of_t,better);
        for(int i=0;i<size_of_t;i++)
        cout<<t[i].aschii<<" "<<t[i].frequency<<endl;
        first=false;
        mp.clear();
    }
}
