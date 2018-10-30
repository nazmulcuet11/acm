#include <iostream>
#include <string>

using namespace std;

int main()
{
    string s;
    while(getline(cin,s)&&s!="0")
    {
        int sum=0,d=0,degree=0;
        for(int i=0; i<s.length(); i++)
        {
            sum+=s[i]-'0';
            d=(d*10+s[i]-'0')%9;
        }
        if(!d)
        {
            while(sum>9)
            {
                degree++;
                int k=sum;
                sum=0;
                while(k!=0)
                {
                    sum+=k%10;
                    k/=10;
                }
            }
            cout<<s<<" is a multiple of 9 and has 9-degree "<<degree+1<<"."<<endl;
        }
        else
        cout<<s<<" is not a multiple of 9."<<endl;
    }
    return 0;
}
