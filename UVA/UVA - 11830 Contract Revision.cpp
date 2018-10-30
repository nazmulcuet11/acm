#include <iostream>
#include <queue>
#include <stdio.h>

using namespace std;

int main()
{
    int a;
    char s,ch;
    queue<char>q;
    while(1)
    {
        scanf("%d",&a);
        scanf("%c",&s);
        while(1)
        {
            scanf("%c",&ch);
            if(ch=='\n')
                break;
            else if(ch!=a+48)
                q.push(ch);
        }

        if(a==0&&q.empty()==1)
            break;

        while(!q.empty()&&q.front()<49)
            q.pop();

        if(!q.empty())
        {
            while(!q.empty())
            {
                cout<<q.front();
                q.pop();
            }
            cout<<endl;
        }

        else
            cout<<"0"<<endl;
    }
    return 0;
}
