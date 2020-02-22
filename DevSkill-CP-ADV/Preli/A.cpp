#include <iostream>

using namespace std;
typedef long long ll;

int get_row_length(int i, int n) {
    return i < n ? i + 1 : 2*n - 1 - i;
}

int main()
{
    freopen("input.txt", "r", stdin);

    int t, n;
    ll a[500][500];
    scanf("%d",&t);
    for(int case_no = 1; case_no <= t; case_no++)
    {
        scanf("%d", &n);
        for(int i = 0; i < 2*n - 1; i++) {
            int row_length = get_row_length(i, n);
            for(int j = 0; j < row_length; j++)
                scanf("%lld", &a[i][j]);
        }

        for(int i = 1; i < 2*n - 1; i++) {
            int row_length = get_row_length(i, n);
            for(int j = 0; j < row_length; j++) {
                int j_prime = i < n ? j - 1: j + 1;
                int prev_row_length = get_row_length(i-1, n);
                ll candiadate_one = (j_prime < 0 || j_prime >= prev_row_length) ? 0 : a[i-1][j_prime];
                ll candiadate_two = (j < 0 || j >= prev_row_length) ? 0: a[i-1][j];
                a[i][j] += max(candiadate_one, candiadate_two);
            }
        }
        printf("Case %d: %lld\n", case_no, a[2*n-2][0]);
    }
}
