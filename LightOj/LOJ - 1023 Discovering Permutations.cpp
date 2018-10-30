#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
using namespace std;
int main()
{
    int test_case;
    cin>>test_case;
    for(int case_no=1; case_no<=test_case; case_no++)
    {
        int n,k;
        string s;
        cin>>n>>k;
        for(int i=0; i<n; i++)
            s.push_back('A'+i);
        int count=0;
        cout<<"Case "<<case_no<<":"<<endl;
        do
        {
            if(count>=k) break;
            cout<<s<<endl;
            count++;
        }
        while(next_permutation(s.begin(),s.end()));
    }
}
