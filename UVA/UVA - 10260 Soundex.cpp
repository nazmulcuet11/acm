#include <iostream>
#include <stdio.h>
#include <queue>

using namespace std;

int main()
{
    queue<int>q;
    q.push(0);
    char ch;
    while(scanf("%c",&ch)==1)
    {
        if(ch!='\n')
        {
            if(ch=='B'||ch=='F'||ch=='P'||ch=='V')
            {
                if(q.back()!=1)
                q.push(1);
            }
            else if(ch=='C'||ch=='G'||ch=='J'||ch=='K'||ch=='Q'||ch=='X'||ch=='S'||ch=='Z')
            {
                if(q.back()!=2)
                q.push(2);
            }
            else if(ch=='D'||ch=='T')
            {
                if(q.back()!=3)
                q.push(3);
            }
            else if(ch=='L')
            {
                if(q.back()!=4)
                q.push(4);
            }
            else if(ch=='M'||ch=='N')
            {
                if(q.back()!=5)
                q.push(5);
            }
            else if(ch=='R')
            {
                if(q.back()!=6)
                q.push(6);
            }
            else
                q.push(0);
        }
        if(ch=='\n')
        {
            while(!q.empty())
            {
                if(q.front()!=0)
                    cout<<q.front();
                q.pop();
            }
            cout<<endl;
            q.push(0);
        }
    }
    return 0;
}
