#include <bits/stdc++.h>

using namespace std;

#define eps 1e-10

int main()
{
    int testCase, n;
    string s;
    cin>>testCase;

    while(testCase--)
    {
        cin>>n>>s;

        double ans = 0.00, p;
        for(int i = 0; i<n; i++)
        {
            cin>>p;

            if(p == 0)
                continue;

            p/=100.00;
            ans += -p*log(p);
        }

        if(s=="bit")
            ans /= log(2.00);
        else if(s=="dit")
            ans /= log(10.00);

        printf("%.12lf\n", ans);
    }
    return 0;
}
