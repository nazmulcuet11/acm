#include <iostream>
#include <cstdio>
#include <queue>

using namespace std;

int main()
{
    int n,sum,c,set=1,move;
    queue<int>q;
    while(scanf("%d",&n)==1&&n!=0)
    {
        move=0;
        sum=0;
        for(int i=0;i<n;i++)
        {
            cin>>c;
            q.push(c);
            sum+=c;
        }
        sum=sum/n;
        while(!q.empty())
        {
            if(q.front()>sum)
            move+=q.front()-sum;
            q.pop();
        }
        cout<<"Set #"<<set<<endl;
        cout<<"The minimum number of moves is "<<move<<"."<<endl<<endl;
        set++;
    }
    return 0;
}
