#include<cstdio>
#include<iostream>

using namespace std;

int save[50001][3];

int main()
{
    int i,j,k,testcase,sum,n;

    for(i=0; i*i<=50000; i++)
        for(j=i; i*i+j*j<=50000; j++)
            for(k=j; i*i+j*j+k*k<=50000; k++)
            {
                sum = i*i+j*j+k*k;
                if(save[sum][0]==0 && save[sum][1]==0 && save[sum][2]==0)
                {
                    save[sum][0]=i;
                    save[sum][1]=j;
                    save[sum][2]=k;
                }
            }

    scanf("%d",&testcase);

    while(testcase--)
    {
        scanf("%d",&n);

        if( save[n][0]==0 && save[n][1]==0 && save[n][2]==0 )
        cout<<"-1"<<endl;
        else
        cout<<save[n][0]<<" "<<save[n][1]<<" "<<save[n][2]<<endl;
    }
    return 0;
}
