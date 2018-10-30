#include <iostream>
#include <string>
#include <algorithm>
#include <cstdio>

using namespace std;

string add(string a, string b)
{
    reverse(a.begin(), a.end());
    reverse(b.begin(), b.end());
    string maxnum;
    string ans;
    int carry=0;
    int minlen;

    if (a.length() > b.length())
    {
        maxnum = a ;
        minlen = b.length();
    }
    else
    {
        maxnum = b;
        minlen = a.length();
    }

    for(int i=0; i<minlen; i++)
    {
        int result=carry + (a[i] - '0') + (b[i] - '0');

        if (result > 9)
        {
            result %= 10;
            carry = 1;
        }
        else
            carry = 0;
        ans.push_back( (char) (result + '0') );
    }

    for(int i=minlen; i<maxnum.length(); i++)
    {
        int result=carry + (maxnum[i] - '0');

        if (result > 9)
        {
            result %= 10;
            carry = 1;
        }
        else
            carry = 0;
        ans.push_back( (char) (result + '0'));
    }

    if (carry == 1)
        ans.push_back('1');

    reverse(ans.begin(), ans.end());
    return ans;
}

int main()
{
    int test_case;
    cin>>test_case;
    getchar();
    while(test_case--)
    {
        string a,b;
        cin>>a>>b;
        reverse(a.begin(),a.end());
        reverse(b.begin(),b.end());
        string s=add(a,b);
        reverse(s.begin(),s.end());
        int i=0;
        while(s[i]=='0')
            i++;
        for(int j=i; j<s.size(); j++)
            cout<<s[j];
        cout<<endl;
    }
    return 0;
}
