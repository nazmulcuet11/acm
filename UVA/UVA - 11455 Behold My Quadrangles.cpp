#include <iostream>
#include <queue>

using namespace std;

int main()
{
    long long int n,test_case,a,b,c,d;
    priority_queue<int>pq;
    cin>>test_case;
    while(test_case--)
    {
        for(int i=0;i<4;i++)
        {
            cin>>n;
            pq.push(n);
        }
        a=pq.top();pq.pop();
        b=pq.top();pq.pop();
        c=pq.top();pq.pop();
        d=pq.top();pq.pop();

        if(a<b+c+d)
        {
            if(a==b&&b==c&&c==d)
            cout<<"square"<<endl;
            else if(a==b&&c==d)
            cout<<"rectangle"<<endl;
            else
            cout<<"quadrangle"<<endl;
        }
        else
        cout<<"banana"<<endl;
    }
    return 0;
}
