#include <iostream>
#include <string.h>
#include <stdio.h>

using namespace std;

int main()
{
    int n,testcase,l,h;
    char s[210];
    cin>>testcase;
    getchar();
    while(testcase--)
    {
        h=0;
        int alpha[27]={0};
        gets(s);
        l=strlen(s);
        for(int i=0;i<l;i++)
        {
            if(s[i]>='A'&&s[i]<='Z')
            {
               alpha[s[i]-64]++;
               if(alpha[s[i]-64]>h)h=alpha[s[i]-64];
            }
            else if(s[i]>='a'&&s[i]<='z')
            {
               alpha[s[i]-96]++;
              if(alpha[s[i]-96]>h)h=alpha[s[i]-96];
            }
        }
        for(int i=0;i<27;i++)
        {
            if(alpha[i]==h)
            printf("%c",i+96);
        }
        cout<<endl;
    }
    return 0;
}
