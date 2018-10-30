#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>

using namespace std;
vector <int>v;
int main()
{
    int testcase;

    cin>>testcase;
    while(testcase--)
    {
        long long int n,sum=0;
        bool expencive=false;
        while(cin>>n&&n)
            v.push_back(n);
        sort(v.begin(),v.end());
        for(int i=v.size()-1,j=1;i>=0;i--,j++)
        {
            sum+=2*pow(v[i],j);
            if(sum>5000000)
            {expencive=true;break;}
        }
        if(expencive)
        cout<<"Too expensive"<<endl;
        else
        cout<<sum<<endl;
        v.clear();
    }
    return 0;
}
