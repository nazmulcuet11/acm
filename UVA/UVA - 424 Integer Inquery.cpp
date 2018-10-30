#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

string convert(int n)
{
    char ch;
    string s="";
    ch=n+'0';
    return s+ch;
}
int main()
{
    string num1,num2,num;
    cin>>num1;
    int sum,carry,i;
    while(cin>>num2&&num2!="0")
    {
        sum=carry=0;
        num="";
        if(num1.size()<num2.size())
        {
            int l=num2.size()-num1.size();
            for(int i=0; i<l; i++)
                num1="0"+num1;
        }
        else
        {
            int l=num1.size()-num2.size();
            for(int i=0; i<l; i++)
                num2="0"+num2;
        }

        for(int i=num1.size()-1; i>=0; i--)
        {
            sum=(num1[i]-'0'+num2[i]-'0'+carry);
            carry=sum/10;
            sum=sum%10;
            string p=convert(sum);
            num=p+num;
        }
        if(carry>0)
        num="1"+num;
        num1=num;
    }
    cout<<num<<endl;
    return 0;
}
