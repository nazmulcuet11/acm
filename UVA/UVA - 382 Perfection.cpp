#include<iostream>
#include<cstdio>

using namespace std;
int main()
{
    int N;
    cout<<"PERFECTION OUTPUT\n";
    while(cin>>N&&N)
    {
        int sum=0;
        for(int i=1; i<=N/2; i++)
        {
            if(N%i==0)
                sum+=i;
            if(sum>N)
            {
                printf("%5d  ABUNDANT\n",N);
                break;
            }
        }
        if(sum==N)
            printf("%5d  PERFECT\n",N);
        else if(sum<N)
            printf("%5d  DEFICIENT\n",N);
    }
    cout<<"END OF OUTPUT\n";
    return 0;
}
