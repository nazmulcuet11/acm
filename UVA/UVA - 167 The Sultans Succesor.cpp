#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

ll testCase,caseNo = 1,board[9][9],ans = 0;
vector<ll> v;

bool check(ll row,ll col)
{
    for(ll i=0; i<v.size(); i++)
        if(v[i]==col)       ///Same Column
            return false;

    for(ll i=0; i<v.size(); i++)
        if(i-v[i]==row-col) ///Forward Diagonal '\'
            return false;

    for(ll i=0; i<v.size(); i++)
        if(i+v[i]==row+col) ///Reverse Diagonal '/'
            return false;


    return true;
}


void eightQueen(ll row)
{
    if(row==8)
    {
        ll temp = 0;
        for(ll i=0; i<v.size(); i++)
            temp+=board[i][v[i]];
        ans = max(ans,temp);
        return;
    }

    for(ll col=0; col<8; col++)
    {
        if(check(row,col))
        {
            v.push_back(col);
            eightQueen(row+1);
            v.pop_back();
        }
    }
}

int main()
{
    cin>>testCase;
    while(testCase--)
    {
        for(ll i=0; i<8; i++)
            for(ll j=0; j<8; j++)
                cin>>board[i][j];

        ans = 0;
        eightQueen(0);
        printf("%5lld\n",ans);
    }
    return 0;
}
