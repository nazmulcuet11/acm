#include <iostream>
#include <queue>

using namespace std;

struct compare
{
  bool operator()(const int& l, const int& r)
  {
      return l > r;
  }
};

int main()
{
    long long int t,n,sum,a,b,c,ans;
    priority_queue<int,vector<int>, compare > pq;
    while((cin>>t)&&t)
    {
        ans=0;
        while(t--)
        {
            cin>>n;
            pq.push(n);
        }
        while(!pq.empty())
        {
            a=pq.top();
            pq.pop();
            b=pq.top();
            pq.pop();
            sum=a+b;
            ans+=sum;
            if(!pq.empty())
            pq.push(sum);
        }
        cout<<ans<<endl;
    }
    return 0;
}
