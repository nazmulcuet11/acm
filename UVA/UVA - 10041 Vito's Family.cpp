#include <iostream>
#include <queue>

using namespace std;

int mod(int a)
{
    if(a<0)
    return -a;
    else
    return a;
}

int main()
{
    int testcase,r,n,sum,s[501];
    priority_queue<int>pq;
    cin>>testcase;
    while(testcase--)
    {
        cin>>r;
        sum=0;
        for(int i=0;i<r;i++)
        {
            cin>>n;
            pq.push(n);
        }
        for(int i=0,j=0;i<r;i++)
          {s[i]=pq.top();
          pq.pop();}
        for(int i=0;i<r;i++)
        sum+=mod(s[r/2]-s[i]);

    cout<<sum<<endl;
    }
    return 0;
}
