#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>
#include <algorithm>

using namespace std;

int main()
{
    long long int test_case,case_no=1,n;
    string name,ans;
    for(scanf("%lld",&test_case);test_case;test_case--)
    {
        cin>>n>>name;
        if(name=="Alice")
            ans=(n-1)%3==0?"Bob":"Alice";
        else if(name=="Bob")
            ans=n%3==0?"Alice":"Bob";
        cout<<"Case "<<case_no++<<": "<<ans<<"\n";
    }
    return 0;
}
