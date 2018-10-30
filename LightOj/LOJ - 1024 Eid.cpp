#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>
#include <algorithm>
#include <cmath>
#include <vector>
#include <ctime>

using namespace std;

struct data
{
    int base,power;
    data(int b=0,int p=0)
    {
        this->base=b;
        this->power=p;
    }
};

bool flag[10000+8];
vector <int> prime;
vector <data> PF[10000+8];
int Factor[10000+8];
string result;

void sieve(int N)
{
    memset(flag,true,sizeof flag);
    for(int i=2; i<sqrt(N)+1; i++)
        if(flag[i])
            for(int j=i+i; j<=N; j+=i)
                flag[j]=false;
    for(int i=2; i<N; i++)
        if(flag[i])
            prime.push_back(i);
}

void prime_factorizer(int N)
{
    int index=N;
    for(int i=0; prime[i]<sqrt(index)+1; i++)
    {
        if(N%prime[i]==0)
        {
            data object;
            object.base=prime[i];
            object.power=0;
            while(N%prime[i]==0)
            {
                N/=prime[i];
                object.power++;
            }
            PF[index].push_back(object);
        }
    }
    if(N>1) PF[index].push_back(data(N,1));
}

string multiply( string a, int b )
{
    // a contains the biginteger in reversed form
    int carry = 0;
    for( int i = 0; i < a.size(); i++ )
    {
        carry += (a[i] - 48) * b;
        a[i] = ( carry % 10 + 48 );
        carry /= 10;
    }
    while( carry )
    {
        a += ( carry % 10 + 48 );
        carry /= 10;
    }
    return a;
}

int main()
{
    sieve(10008);
    //double start=clock();
    for(int i=1; i<10001; i++)
        prime_factorizer(i);
    //double end=clock();
    //cout<<(end-start)/CLOCKS_PER_SEC<<endl;
    int test_case,case_no=1,n,x;
    for(scanf("%d",&test_case); test_case; test_case--)
    {
        memset(Factor,0,sizeof Factor);
        int max_factor=0;
        result="1";
        for(scanf("%d",&n); n; n--)
        {
            scanf("%d",&x);
            for(int i=0; i<PF[x].size(); i++)
            {
                data d=PF[x][i];
                if(Factor[d.base]<d.power) Factor[d.base]=d.power;
                if(max_factor<d.base) max_factor=d.base;
            }
        }
        for(int i=0; i<prime.size()&& prime[i]<=max_factor; i++)
        {
            if(Factor[prime[i]]>0)
            {
                int temp=1;
                for(int j=0; j<Factor[prime[i]]; j++) temp*=prime[i];
                result=multiply(result,temp);
            }
        }
        reverse(result.begin(),result.end());
        //start=clock();
        cout<<"Case "<<case_no++<<": "<<result<<"\n";
        //end=clock();
        //cout<<(end-start)/CLOCKS_PER_SEC<<endl;
    }
    return 0;
}
