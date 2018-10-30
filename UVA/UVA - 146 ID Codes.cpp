#include <iostream>
#include <algorithm>
#include <cstring>
#include <cstdio>

using namespace std;

int main()
{
    char s[51];
    while(gets(s)&&s[0]!='#')
    {
        if(next_permutation(s,s+strlen(s)))
            puts(s);
        else
        cout<<"No Successor"<<endl;
    }
}
