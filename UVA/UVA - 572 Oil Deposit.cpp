#include<stdio.h>
#include<stack>

using namespace std;
int main()
{
    int i,j,p,q,c,r,counter;
    char input[101][101];
    stack <int> x;
    stack <int> y;

    while(scanf("%d%d",&r,&c)==2)
    {
        if(r==0&&c==0)
            break;

        counter=0;
        getchar();
        for(i=0; i<r; i++)
        {
            for(j=0; j<c; j++)
            {
                scanf("%c",&input[i][j]);
            }
            getchar();
        }


        for(i=0; i<r; i++)
        {
            for(j=0; j<c; j++)
            {
                if(input[i][j]=='@')
                {
                    input[i][j]='*';
                    counter++;
                    x.push(i);
                    y.push(j);

                    while(!x.empty())
                    {
                        p=x.top();
                        x.pop();
                        q=y.top();
                        y.pop();

                        if(p-1>=0&&q-1>=0&&input[p-1][q-1]=='@')
                        {
                            input[p-1][q-1]='*';
                            x.push(p-1);
                            y.push(q-1);

                        }
                        if(p-1>=0&&input[p-1][q]=='@')
                        {
                            input[p-1][q]='*';
                            x.push(p-1);
                            y.push(q);

                        }
                        if(p-1>=0&&q+1<c&&input[p-1][q+1]=='@')
                        {
                            input[p-1][q+1]='*';
                            x.push(p-1);
                            y.push(q+1);

                        }
                        if(q-1>=0&&input[p][q-1]=='@')
                        {
                            input[p][q-1]='*';
                            x.push(p);
                            y.push(q-1);

                        }
                        if(q+1<c&&input[p][q+1]=='@')
                        {
                            input[p][q+1]='*';
                            x.push(p);
                            y.push(q+1);

                        }
                        if(p+1<r&&q-1>=0&&input[p+1][q-1]=='@')
                        {
                            input[p+1][q-1]='*';
                            x.push(p+1);
                            y.push(q-1);

                        }
                        if(p+1<r&&input[p+1][q]=='@')
                        {
                            input[p+1][q]='*';
                            x.push(p+1);
                            y.push(q);

                        }
                        if(p+1<r&&q+1<c&&input[p+1][q+1]=='@')
                        {
                            input[p+1][q+1]='*';
                            x.push(p+1);
                            y.push(q+1);

                        }
                    }
                }
            }
        }
        printf("%d\n",counter);
    }
    return 0;
}
