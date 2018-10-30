#include <iostream>
#include <cstring>
#include <cstdio>
#include <cmath>
using namespace std;

int main()
{
    char a[1005],b[1005];

    while(gets(a) && gets(b))
    {

        int common[26] = {0};
        int A[26] = {0};
        int B[26] = {0};
        int i,j;

        for(i = 0; i<strlen(a); i++)
            A[a[i]-97]++;
        for(i = 0; i<strlen(b); i++)
            B[b[i]-97]++;

        for(i = 0; i<26; i++)
            common[i] = min(A[i], B[i]);

        for(i=0; i<26; i++)
        {
           for(j = 0; j < common[i] ; j++ )
           printf("%c",97+i);
        }
        cout<<endl;
    }
    return 0;
}
