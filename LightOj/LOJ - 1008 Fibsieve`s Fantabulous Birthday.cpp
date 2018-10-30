#include <iostream>
#include <cmath>

using namespace std;

int main()
{
    long long int s,test_case;
    cin>>test_case;
    for(int i=1;i<=test_case;i++)
    {
        cin>>s;
        long long int co_ord_X=0,co_ord_Y=0;
        long long int root=ceil(sqrt(s));
        if(s==root*root)
        {
            if(s%2) {co_ord_X=1;co_ord_Y=root;}
            else    {co_ord_X=root;co_ord_Y=1;}
        }
        else
        {
            long long int upper_squire=root*root;
            long long int lower_squire=(root-1)*(root-1);
            long long int diff1=upper_squire-s;
            long long int diff2=s-lower_squire;
            if(diff2<diff1)
            {
                if(lower_squire%2){co_ord_X=diff2;co_ord_Y=root;}
                else              {co_ord_X=root;co_ord_Y=diff2;}
            }
            else if(diff1<diff2)
            {
                if(upper_squire%2){co_ord_X=diff1+1;co_ord_Y=root;}
                else              {co_ord_X=root;co_ord_Y=diff1+1;}
            }
            else {co_ord_X=root;co_ord_Y=root;}
        }
        cout<<"Case "<<i<<": "<<co_ord_X<<" "<<co_ord_Y<<endl;
    }
    return 0;
}
