#include <iostream>
#include <string>
#include <string.h>
#include <cstdio>
using namespace std;
bool prime[2005];
void prime_generator()
{
    for(long long int i=3; i<2005; i+=2)
        prime[i]=true;
    prime[2]=true;
    for(long long int i=3; i<45; i+=2)
    {
        for(long long int j=i*3; j<2005; j=j+i)
            prime[j]=false;
    }
    return;
}
int main()
{
    prime_generator();
    string s;
    int test_case,p[200];
    cin>>test_case;
    getchar();
    for(int i=1; i<=test_case; i++)
    {
        bool empty=true;
        memset(p,0,sizeof p);
        getline(cin,s);
        for(int j=0; j<s.size(); j++)
            p[s[j]]++;
        cout<<"Case "<<i<<": ";
        for(int j='0'; j<='z'; j++)
            if(prime[p[j]])
                {cout<<(char)j;empty=false;}
        if(empty)
        cout<<"empty";
        cout<<endl;
    }
    return 0;
}
