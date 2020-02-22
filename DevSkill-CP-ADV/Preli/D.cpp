#include <iostream>
#include <cmath>

#define eps 1e-11

using namespace std;

int main()
{
    freopen("input.txt", "r", stdin);

    int t;
    double ab, ac, bc, ratio;
    cin >> t;
    for(int i=1; i<=t; i++)
    {
        cin >> ab >> ac >> bc >> ratio;

        double s = (ab + ac + bc) / 2;
        double areaABC = sqrt(s*(s-ab)*(s-ac)*(s-bc));

        double low = 0, high = ab;
        while(low+eps < high)
        {
            double ad = (low + high)/2;
            double ae = (ad / ab) * ac;
            double de = (ad / ab) * bc;
            
            s = (ad + ae + de) / 2;
            double areaADE = sqrt(s*(s-ad)*(s-ae)*(s-de));
            double areaBDEC = areaABC - areaADE;
            double r = areaADE / areaBDEC;

            if(r > ratio) {
                high = ad;
            } else {
                low = ad;
            }
        }
        printf("Case %d: %.10lf\n", i, low);
    }
    return 0;
}
