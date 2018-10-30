#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
#include <cstring>
#include <string>
using namespace std;
string s1,s2;
int dp[350][350];
vector <string> seq;
int rec(int i,int j)
{
    if(i>=s1.size()||j>=s2.size()) return 0;
    if(dp[i][j]!=-1) return dp[i][j];
    int ret=0;
    if(s1[i]==s2[j]) ret=rec(i+1,j+1)+1;
    return dp[i][j]=ret;
}
int main()
{
    int test_case=0;
    while(getline(cin,s1)&&getline(cin,s2))
    {
        if(test_case!=0)
        {
            cout<<endl;
            s1=s2;
            getline(cin,s2);
        }
        int max_len=0;
        memset(dp,-1,sizeof dp);
        for(int i=0; i<s1.size(); i++)
        {
            for(int j=0; j<s2.size(); j++)
            {
                max_len=max(max_len,rec(i,j));
            }
        }
        if(!max_len) cout<<"No common sequence."<<endl;
        else
        {
            for(int i=0; i<s1.size(); i++)
            {
                for(int j=0; j<s2.size(); j++)
                {
                    if(dp[i][j]==max_len)
                    {
                        string s;
                        for(int k=i; k<i+max_len; k++)
                            s.push_back(s1[k]);
                        seq.push_back(s);
                    }
                }
            }
            sort(seq.begin(),seq.end());
            cout<<seq[0]<<endl;
            for(int i=1; i<seq.size(); i++)
                if(seq[i]!=seq[i-1])
                    cout<<seq[i]<<endl;
            seq.clear();
        }
        test_case++;
    }
    return 0;
}
