#include <iostream>
#include <stdio.h>
#include <queue>
#include <string.h>

using namespace std;

int main()
{
    int n,i,t;
    queue<int> card;

    while(scanf("%d",&n)==1)
    {
        if(n==0)
            break;
        if(n==1)
        {
            cout<<"Discarded cards:"<<endl;
            cout<<"Remaining card: 1"<<endl;
            continue;
        }

        for(i=1; i<=n; i++)
        {
            card.push(i);
        }

        printf("Discarded cards: ");
        for(i=1; i<n-1; i++)
        {
            printf("%d, ",card.front());
            card.pop();
            t=card.front();
            card.pop();
            card.push(t);
        }
        printf("%d\n",card.front());
        card.pop();
        printf("Remaining card: %d\n",card.front());
        card.pop();
    }
    return 0;
}
