#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);

    int sides[6];
    for(int i = 0; i < 6; i++)
        cin >> sides[i];

    long long ans = 0;
    long long cnt = 2*sides[0] + 1;
    for(int i = 0; i < sides[1]; i++)
    {
        ans += cnt;
        cnt += 2;
    }
    cnt -= 2;

    for(int i = 0; i < sides[2]; i++)
    {
        ans += cnt;
        cnt -= 2;
    }

    cout << ans << endl;

    return 0;
}
