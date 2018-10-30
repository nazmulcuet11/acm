#include <iostream>
#include <cstdio>
#include <algorithm>
#include <vector>
using namespace std;
void copier(int n,int *a,int *b){for(int i=0;i<n;i++)a[i]=b[i];}
bool check_wining(int *a,int *b)
{
    int win=0;
    for(int i=0; i<3; i++)
        if(a[i]<b[i]) win++;
    if(win>=2) return true;
    return false;
}
bool search(int j,int *a,int *b)
{
    for(int i=0; i<3; i++) if(a[i]==j) return true;
    if(b[0]==j||b[1]==j) return true;
    return false;
}
int main()
{
    int a[3],b[3],c[3],d[3];
    vector<int> ans;
    while(cin>>a[0]>>a[1]>>a[2]>>b[0]>>b[1]&&a[0]&&a[1]&&a[2]&&b[0]&&b[1])
    {
        bool all_combination_possible;
        for(int i=1; i<53; i++)
        {
            copier(3,c,a);copier(2,d,b);
            if(!search(i,a,b))
            {
                d[2]=i;sort(c,c+3);sort(d,d+3);
                all_combination_possible=true;
                do
                {
                    do
                    {
                        if(!check_wining(c,d)) all_combination_possible=false;
                    }
                    while(next_permutation(c,c+3));

                }
                while(next_permutation(d,d+3));
                if(all_combination_possible)
                    ans.push_back(i);
            }
        }
        if(ans.size()==0)cout<<"-1"<<endl;
        else cout<<ans[0]<<endl;
        ans.clear();
    }
    return 0;
}
