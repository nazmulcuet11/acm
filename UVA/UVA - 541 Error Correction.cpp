#include <iostream>
#include <cstdio>
#include <cstring>

using namespace std;

int data[101][101];

int main()
{
    int N;
    while(scanf("%d",&N)==1&&N)
    {
        int row,column,no_of_row_corrupt=0,no_of_column_corrupt=0,count;
        for(int i=0; i<N; i++)
        {
            count=0;
            for(int j=0; j<N; j++)
            {
                scanf("%d",&data[i][j]);
                if(data[i][j]==1)
                    count++;
            }
            if(count%2==1)
            {
                row=i;
                no_of_row_corrupt++;
            }
        }
        for(int i=0; i<N; i++)
        {
            count=0;
            for(int j=0; j<N; j++)
            {
                if(data[j][i]==1)
                    count++;
            }
            if(count%2==1)
            {
                column=i;
                no_of_column_corrupt++;
            }
        }
        if(!no_of_row_corrupt&&!no_of_column_corrupt)
            printf("OK\n");
        else if(no_of_row_corrupt==1&&no_of_column_corrupt==1)
            printf("Change bit (%d,%d)\n",row+1,column+1);
        else
            printf("Corrupt\n");
    }
    return 0;
}
