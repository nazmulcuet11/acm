#include <iostream>
#include <stack>

using namespace std;

int main()
{
    int testcase,n,carry,x,y,s;
    stack<int>a,b,sum;
    cin>>testcase;
    while(testcase--)
    {
        carry=0;
        cin>>n;
        for(int i=0; i<n; i++)
        {
            cin>>x>>y;
            a.push(x);
            b.push(y);
        }
        while(!b.empty())
        {
            s=a.top()+b.top()+carry;
            sum.push(s%10);
            carry=s/10;
            a.pop();
            b.pop();
        }
        while(!sum.empty())
        {
            cout<<sum.top();
            sum.pop();
        }
        if(testcase)
        cout<<endl<<endl;
        else
        cout<<endl;
    }
    return 0;
}
