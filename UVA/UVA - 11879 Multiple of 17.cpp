#include <iostream>
#include <string>

using namespace std;

int main()
{
    string s;
    while(getline(cin,s)&&s!="0")
    {
        int l=s.size();
        int m=0;
        for(int i=0;i<l;i++)
        {
           m=m*10+s[i]-'0';
           m=m%17;
        }
        if(!m)
            cout<<"1"<<endl;
        else
            cout<<"0"<<endl;
    }
    return 0;
}
