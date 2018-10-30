#include <iostream>
#include <string>

using namespace std;

int main()
{
    string s;
    while(getline(cin,s))
    {
        if(s.size()==1&&s[0]=='0')
        break;
        int l=s.size();
        int m=0;
        for(int i=0;i<l;i++)
        {
           m=m*10+s[i]-'0';
           m=m%11;
        }
        for(int i=0;i<l;i++)
            cout<<s[i];
        if(!m)
            cout<<" is a multiple of 11."<<endl;
        else
            cout<<" is not a multiple of 11."<<endl;
    }
    return 0;
}
