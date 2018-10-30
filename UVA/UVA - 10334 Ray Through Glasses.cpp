#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

string fibonumber[5001];

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

string fibonacci(int index)
{
    if (fibonumber[index].empty())
        fibonumber[index] = add(fibonacci(index-1), fibonacci(index-2));
    return fibonumber[index];
}

int main()
{
    fibonumber[0] = "1";
    fibonumber[1] = "2";
    int n;
    while(cin>>n)
        cout<<fibonacci(n)<< endl;
    return 0;
}
