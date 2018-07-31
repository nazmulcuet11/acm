#include <bits/stdc++.h>

using namespace std;

#define SZ 55
typedef long long ll;

int main(int argc, char const *argv[])
{
    //freopen("tourist.txt", "r", stdin);
    //freopen("tourist-output.txt", "w", stdout);

    int test_case, case_no = 1, n, k;
    ll v;
    string campuses[55];

    cin >> test_case;

    while (test_case--)
    {
        cin >> n >> k >> v;

        for (int i = 0; i < n; i++)
        {
            cin >> campuses[i];
        }

        int x = ((v - 1) * k) % n;
        int will_visit[SZ] = {0};

        for (int i = 0; i < k; i++)
        {
            will_visit[x % n] = 1;
            x++;
        }

        printf("Case #%d:", case_no++);

        for (int i = 0; i < n; i++)
        {

            if (will_visit[i])
            {
                cout << " " << campuses[i];
            }
        }
        cout << endl;
    }
    return 0;
}
