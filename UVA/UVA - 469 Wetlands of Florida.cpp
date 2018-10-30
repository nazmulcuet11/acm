#include <iostream>
#include <stdio.h>
#include <stack>
#include <string.h>

using namespace std;

int area_cal(int,int);
char input[100][100];
int row,column;

stack<int>x;
stack<int>y;

int main()
{
    int i,j,r,c,area,test,ww,k,len;
    scanf("%d",&test);

    for(ww=0; ww<test; ww++)
    {
        for(i=0;; i++)
        {
            scanf("%s",input[i]);

            if(input[i][0]!='L'&&input[i][0]!='W')
            {
                r=input[i][0]-48;
                k=1;
                len=strlen(input[i]);
                while(k<len)
                {
                    r= r*10+(input[i][k]-48);
                    k++;
                }
                scanf("%d",&c);
                break;
            }
        }

        row=i;
        column=strlen(input[0]);

        if(ww!=0)
            printf("\n");
        area=area_cal(int (r-1),int (c-1));
        cout<<area<<endl;

        for(i=0; i<row; i++)
        {
            for(j=0; j<row; j++)
            {
                if(input[i][j]=='X')
                    input[i][j]='W';
            }
        }

        while(scanf("%d %d",&r,&c)==2)
        {
            area=area_cal(int (r-1),int (c-1));
            cout<<area<<endl;

            for(i=0; i<row; i++)
            {
                for(j=0; j<row; j++)
                {
                    if(input[i][j]=='X')
                        input[i][j]='W';
                }
            }
        }
    }
    return 0;
}

int area_cal(int r,int c)
{
    int i,j,p,q,counter=0;

    if(r<row&&c<column)
    {
        input[r][c]='X';
        counter++;
        x.push(r);
        y.push(c);

        while(!x.empty())
        {
            p=x.top();
            x.pop();
            q=y.top();
            y.pop();

            if(p-1>=0&&q-1>=0&&input[p-1][q-1]=='W')
            {
                input[p-1][q-1]='X';
                x.push(p-1);
                y.push(q-1);
                counter++;
            }
            if(p-1>=0&&input[p-1][q]=='W')
            {
                input[p-1][q]='X';
                x.push(p-1);
                y.push(q);
                counter++;
            }
            if(p-1>=0&&q+1<column&&input[p-1][q+1]=='W')
            {
                input[p-1][q+1]='X';
                x.push(p-1);
                y.push(q+1);
                counter++;
            }
            if(q-1>=0&&input[p][q-1]=='W')
            {
                input[p][q-1]='X';
                x.push(p);
                y.push(q-1);
                counter++;
            }
            if(q+1<column&&input[p][q+1]=='W')
            {
                input[p][q+1]='X';
                x.push(p);
                y.push(q+1);
                counter++;
            }
            if(p+1<row&&q-1>=0&&input[p+1][q-1]=='W')
            {
                input[p+1][q-1]='X';
                x.push(p+1);
                y.push(q-1);
                counter++;
            }
            if(p+1<row&&input[p+1][q]=='W')
            {
                input[p+1][q]='X';
                x.push(p+1);
                y.push(q);
                counter++;
            }
            if(p+1<row&&q+1<column&&input[p+1][q+1]=='W')
            {
                input[p+1][q+1]='X';
                x.push(p+1);
                y.push(q+1);
                counter++;
            }
        }
    }
    return counter;
}
