#include<iostream>
#include<string>
#include<map>
#include<queue>
using namespace std;
map<string,int> mp;
void BFS(void)
{
    int count=1;
    queue<string> q;
    for(char i='a';i<='z';i++)
        q.push(string(1,i));
    while(!q.empty())
    {
        string s=q.front();q.pop();
        mp[s]=count++;
        for(char t=s[s.size()-1]+1;t<='z'&&s.size()<5;t++)
            q.push(s+t);
    }
}
int main()
{
    string s;
    BFS();
    while(getline(cin,s))
    {
        map<string,int>::iterator ita;
        for(ita=mp.begin();ita!=mp.end();ita++)
        {
            if(ita->first==s){cout<<ita->second<<endl;break;}
        }
        if(ita==mp.end())
        cout<<"0"<<endl;
    }
}
