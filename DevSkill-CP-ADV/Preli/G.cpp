#include <iostream>

using namespace std;
typedef long long ll;

#define MAX_N 500005

ll a[MAX_N], b[MAX_N];

ll merge(int s, int mid, int e) {
    ll res = 0;
    int i = s, j = mid + 1, k = 0;
    while(i <= mid && j <= e) {
        if(a[i] <= a[j]) {
            b[k++] = a[i++];
        } else {
            res += mid - i + 1;
            b[k++] = a[j++];
        }
    }

    while(i <= mid)
        b[k++] = a[i++];
    
    while(j <= e)
        b[k++] = a[j++];
    
    for(i = s; i <= e; i++) {
        a[i] = b[i-s];
    }

    return res;
}

ll merge_sort(int s, int e) {
    if(s >= e) {
        return 0;
    }

    int mid = (s + e) / 2;
    ll ret1 = merge_sort(s, mid);
    ll ret2 = merge_sort(mid+1, e);
    return ret1 + ret2 + merge(s, mid, e);
}

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);

    int n;
    while(scanf("%d", &n), n) {
        for(int i = 0; i <n; i++) {
            scanf("%lld", &a[i]);
        }
        ll ans = merge_sort(0, n-1);
        printf("%lld\n", ans);
    }
    return 0;
}
