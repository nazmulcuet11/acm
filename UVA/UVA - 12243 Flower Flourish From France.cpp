#include <iostream>
#include <ctype.h>
#include <string>

using namespace std;

int main()
{
    string s;
    while(getline(cin,s)&&s!="*")
    {
        char p=tolower(s[0]);
        bool tautogram=true;
        for(int i=0;i<s.length()-1;i++)
        {
            if(s[i]==' '&&tolower(s[i+1])!=p)
            {
                tautogram=false;
                break;
            }
        }
        if(tautogram)
        cout<<"Y"<<endl;
        else
        cout<<"N"<<endl;
    }
    return 0;
}
