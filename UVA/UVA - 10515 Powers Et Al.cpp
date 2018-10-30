#include <iostream>
#include <string>
#include <cmath>
using namespace std;

int myPow(int m, int n)
{
    if (m == 0)
        return 0; //base 0
    if (n == 0) //powe 0
        return 1;
    int total = m;
    for (int i = 1; i < n; ++i)
    {
        total = total * m;
        total = total % 10;
    }
    return total;
}

int main()
{
    string m, n;
    int _m, _n, temp;

    while (cin >> m >> n&&(m!="0"||n!="0"))
    {
        _m = m[m.size()-1] - 48;
        if (n.size() >= 2)  // we need n's last two digit
        {
            temp = n[n.size()-1] - 48;
            _n = (n[n.size()-2]-48) * 10 + temp;
        }
        else
            _n = n[n.size()-1]-48;

        if (_n == 0)  //last two digit zero then
        {
            temp = myPow(_m, 100);
        }
        else
            temp = myPow(_m, _n) % 10;
        cout << temp << endl;

    }
    return 0;
}
