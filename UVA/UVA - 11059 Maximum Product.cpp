#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    int n,a[19],c=1;
    while(cin>>n)
    {
        for(int i=0; i<n; i++)
            cin>>a[i];
        long long int m=0;
        for(int i=0;i<n;i++)
        {
            long long int product=1;
            for(int j=i;j<n;j++)
            {
                product*=a[j];
                m=max(m,product);
            }
        }
        cout << "Case #" <<c++<< ": The maximum product is " << m << "." << endl << endl;
    }
}
