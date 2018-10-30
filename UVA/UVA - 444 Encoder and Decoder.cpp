#include <iostream>
#include <string>

using namespace std;

void decode(string s)
{
    int sum=0;
    for(int i=s.size()-1; i>=0; i--)
    {
        sum=sum*10+s[i]-'0';
        if((sum>='A'&&sum<='Z')||(sum>='a'&&sum<='z')||sum==32||sum==33||sum==44||sum==46||sum==58||sum==59||sum==63)
        {
            cout<<(char)sum;
            sum=0;
        }
    }
}

void encode(string s)
{
    for(int i=s.size()-1; i>=0; i--)
    {
        int k=(int)s[i];
        while(k!=0)
        {
            cout<<k%10;
            k/=10;
        }
    }
}

int main()
{
    string s;
    while(getline(cin,s))
    {
        if(s[0]>='0'&&s[0]<='9')
            decode(s);
        else
            encode(s);
        cout<<endl;
    }
    return 0;
}
