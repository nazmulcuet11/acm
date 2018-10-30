#include <iostream>
#include <stdio.h>
#include <string.h>

using namespace std;

struct s
{
    char ch;
    int n;
};

int main()
{
    struct s a[26];
    int testcase,l;
    char s[10000];
    for(int j=0,i='A';i<='Z';j++,i++)
    {
       a[j].ch=i;
       a[j].n=0;
    }
    cin>>testcase;
    getchar();
    while(testcase--)
    {
        gets(s);
        l=strlen(s);
        for(int i=0;i<l;i++)
        {
            if(s[i]>='a'&&s[i]<='z')
            a[s[i]-'a'].n++;
            else if(s[i]>='A'&&s[i]<='Z')
            a[s[i]-'A'].n++;
        }
    }

    for(int i=0;i<26;i++)
    {
        for(int j=0;j<)
    }
    for(int i=0;i<26;i++)
    cout<<a[i].ch<<" "<<a[i].n<<endl;
    getchar();
    return 0;
}

