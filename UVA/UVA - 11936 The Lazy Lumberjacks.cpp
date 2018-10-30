#include <iostream>
#include <queue>

using namespace std;

int main()
{
    int testcase,n,a,b,c;
    priority_queue<int>pq;
    cin>>testcase;
    while(testcase--)
    {
        for(int i=0; i<3; i++)
        {
            cin>>n;
            pq.push(n);
        }
        a=pq.top();
        pq.pop();
        b=pq.top();
        pq.pop();
        c=pq.top();
        pq.pop();

        if(a<(b+c))
        cout<<"OK"<<endl;
        else
        cout<<"Wrong!!"<<endl;
    }
    return 0;
}
