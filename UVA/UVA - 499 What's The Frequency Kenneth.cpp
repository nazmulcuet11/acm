#include <iostream>
#include <algorithm>
#include <map>
#include <string>
#include <cstdio>

using namespace std;

bool my_sort(pair<int,int>x,pair<int,int>y)
{
    if(x.second>y.second)
    return true;
    if(x.second==y.second&&x.first<y.first)
    return true;
    return false;
}

int main()
{
    string s;
    while(getline(cin,s))
    {
        int l=s.size();
        map<char,int>mp;
        pair<int,int>pr[100];
        for(int i=0;i<l;i++)
        {
            if((s[i]>='a'&&s[i]<='z')||(s[i]>='A'&&s[i]<='Z'))
                mp[s[i]]++;
        }
        int i=0,max=0;
        for(map<char,int>::iterator ita=mp.begin();ita!=mp.end();ita++,i++)
        {
            pr[i].first=ita->first;
            pr[i].second=ita->second;
            if(ita->second>max)
            max=ita->second;
        }
        int size_of_pr=i;
        sort(pr,pr+size_of_pr,my_sort);
        for(int i=0;i<size_of_pr;i++)
        {
            if(pr[i].second==max)
            printf("%c",pr[i].first);
            else
            break;
        }
        cout<<" "<<max<<endl;
    }
    return 0;
}
