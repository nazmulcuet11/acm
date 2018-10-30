#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main()
{
    long long int n,i=0,a[100000];
    vector<int>v;
    while(cin>>n)
    {
     v.push_back(n);
     sort(v.begin(),v.end());
     if(v.size()%2)
     cout<<v[(v.size()/2)]<<endl;
     else
     cout<<((v[v.size()/2])+(v[v.size()/2-1]))/2<<endl;
    }
    return 0;
}
