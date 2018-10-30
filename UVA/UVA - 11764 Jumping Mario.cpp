#include <iostream>

using namespace std;

int main()
{
    int testcase,n,a,high,low,flag,prev;
    cin>>testcase;
    for(int i=1; i<=testcase; i++)
    {
        cin>>n;
        flag=0;
        high=0;
        low=0;
        while(n--)
        {
            cin>>a;
            if(flag==0)
            prev=a;

            else if(flag>0)
            {
                if(a>prev)high++;
                else if(a<prev) low++;
                prev=a;
            }

            flag++;
        }
        cout<<"Case "<<i<<":"<<" "<<high<<" "<<low<<endl;
    }
    return 0;
}
