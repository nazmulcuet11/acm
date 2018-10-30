#include <iostream>
#include <cstring>
#include <algorithm>
#include <cstdio>
#include <ctype.h>

using namespace std;

bool my_sort(char a,char b)
{
    if(tolower(a)<tolower(b))
    return true;
    else if(tolower(a)==tolower(b))
    {
        if(a<b)
        return true;
        else
        return false;
    }
    else
    return false;
}

int main()
{
    char s[1000000];
    int testcase;
    cin>>testcase;
    getchar();
    while(testcase--)
    {
        gets(s);
        sort(s,s+strlen(s));
        do
        {
            puts(s);
        }while(next_permutation(s,s+strlen(s))!=0);
    }
    return 0;
}
