#include <iostream>
#include <cmath>
#include <string>
using namespace std;

int main()
{
    string s;
    while(getline(cin,s))
    {
        int max_space=0;
        for(int i=0;i<s.length();i++)
        {
            int count=0;
            if(s[i]==' ')
            while(s[i]==' ')
            {
                count++;
                i++;
            }
            if(count>max_space)
            max_space=count;
        }
        cout<<ceil(log2(max_space))<<endl;
    }
    return 0;
}
