#include<stdio.h>
#include<stack>

using namespace std;
int main()
{
    int i,j,p,q,c,n,counter,image_number=1;
    char input[101][101];
    stack <int> x;
    stack <int> y;

    while(scanf("%d",&n)==1)
    {
        counter=0;
        for(i=0; i<n; i++)
        {
            scanf("%s",input[i]);
        }


        for(i=0; i<n; i++)
        {
            for(j=0; j<n; j++)
            {
                if(input[i][j]=='1')
                {
                    input[i][j]='0';
                    counter++;
                    x.push(i);
                    y.push(j);

                    while(!x.empty())
                    {
                        p=x.top();
                        x.pop();
                        q=y.top();
                        y.pop();

                        if(p-1>=0&&q-1>=0&&input[p-1][q-1]=='1')
                        {
                            input[p-1][q-1]='0';
                            x.push(p-1);
                            y.push(q-1);

                        }
                        if(p-1>=0&&input[p-1][q]=='1')
                        {
                            input[p-1][q]='0';
                            x.push(p-1);
                            y.push(q);

                        }
                        if(p-1>=0&&q+1<n&&input[p-1][q+1]=='1')
                        {
                            input[p-1][q+1]='0';
                            x.push(p-1);
                            y.push(q+1);

                        }
                        if(q-1>=0&&input[p][q-1]=='1')
                        {
                            input[p][q-1]='0';
                            x.push(p);
                            y.push(q-1);

                        }
                        if(q+1<n&&input[p][q+1]=='1')
                        {
                            input[p][q+1]='0';
                            x.push(p);
                            y.push(q+1);

                        }
                        if(p+1<n&&q-1>=0&&input[p+1][q-1]=='1')
                        {
                            input[p+1][q-1]='0';
                            x.push(p+1);
                            y.push(q-1);

                        }
                        if(p+1<n&&input[p+1][q]=='1')
                        {
                            input[p+1][q]='0';
                            x.push(p+1);
                            y.push(q);

                        }
                        if(p+1<n&&q+1<n&&input[p+1][q+1]=='1')
                        {
                            input[p+1][q+1]='0';
                            x.push(p+1);
                            y.push(q+1);

                        }
                    }
                }
            }
        }
        printf("Image number %d contains %d war eagles.\n",image_number,counter);
        image_number++;
    }
    return 0;
}
