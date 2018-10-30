#include <iostream>
#include <cstring>
#include <cstdio>
#include <string>
#include <vector>

using namespace std;

int N,arr[11][11],sum;
vector<int> sums;

int main()
{
    freopen("input.in","r",stdin);
    int case_no=1;
    while(scanf("%d",&N)&&N)
    {
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                scanf("%d",&arr[i][j]);
        int top_row=0,bottom_row=N-1,left_column=0,right_column=N-1;

        while(top_row<=bottom_row&&left_column<=right_column)
        {
            sum=0;
            for(int i=left_column; i<=right_column; i++)
            {
                sum+=arr[top_row][i];
                if(top_row!=bottom_row)
                    sum+=arr[bottom_row][i];
            }
            for(int i=top_row+1; i<=bottom_row-1; i++)
            {
                sum+=arr[i][left_column];
                if(left_column!=right_column)
                    sum+=arr[i][right_column];
            }
            sums.push_back(sum);
            top_row++;
            bottom_row--;
            left_column++;
            right_column--;
        }
        printf("Case %d: ",case_no++);
        for(int i=0;i<sums.size();i++)
            i==sums.size()-1?printf("%d\n",sums[i]):printf("%d ",sums[i]);
        sums.clear();
    }
    return 0;
}
