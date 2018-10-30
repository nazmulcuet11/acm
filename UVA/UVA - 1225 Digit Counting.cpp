#include <iostream>
#include <string.h>

using namespace std;

int main()
{
    int s[10];
    int n,t;
    cin>>t;
    while(t--)
    {
        memset(s,0,sizeof s);
        cin>>n;
        for(int i=1; i<=n; i++)
        {
            int j=i;
            while(j>9)
            {
                s[j%10]++;
                j=j/10;
            }
            s[j]++;
        }
        for(int i=0; i<=9; i++)
        {
            if(i!=0)
                cout<<" ";
            cout<<s[i];
        }
        cout<<endl;
    }
    return 0;
}
