#include <iostream>
#include <string>
#include <cstdio>
using namespace std;
string s[4]= {"shata","hajar","lakh","kuti"};
int divider[4]= {10,100,100,100};
void bangla_number(long long int n,int pos)
{
    if(!n)
        return;
    bangla_number(n/divider[pos],(pos+1)%4);
    int t=n%divider[pos];
    if(t)
        cout<<" "<<t<<" "<<s[pos];
    else if(pos==3)
        cout<<" "<<s[pos];
}
int main()
{
    long long int n,c=1;
    while(cin>>n)
    {
        printf("%4lld.",c++);
        bangla_number(n/100,0);
        if(n/100==0||n%100!=0)
            cout<<" "<<n%100;
        cout<<endl;
    }
}
