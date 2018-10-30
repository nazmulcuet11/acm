#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>

using namespace std;

bool is_vowel(char a)
{
    return a=='A'||a=='E'||a=='I'||a=='O'||a=='U'?true:false;
}

string str;
int dp[51][4][6];

inline int solve(int i,int vowel,int cons)
{
    if(vowel==3||cons==5) return 1;///1 For "BAD"
    if(i<0) return 2; ///2 For "GOOD"
    if(dp[i][vowel][cons]!=-1) return dp[i][vowel][cons];
    if(str[i]=='?')
        return dp[i][vowel][cons]=solve(i-1,vowel+1,0)|solve(i-1,0,cons+1);
    if(is_vowel(str[i]))
        return dp[i][vowel][cons]=solve(i-1,vowel+1,0);
    else
        return dp[i][vowel][cons]=solve(i-1,0,cons+1);
}

int main()
{
    int test_case,case_no=1;
    for(scanf("%d",&test_case);test_case;test_case--)
    {
        memset(dp,-1,sizeof dp);
        cin>>str;
        int ans=solve(str.size()-1,0,0);
        cout<<"Case "<<case_no++<<": ";
        if(ans==1) cout<<"BAD\n";
        else if(ans==2) cout<<"GOOD\n";
        else cout<<"MIXED\n";
    }
    return 0;
}
