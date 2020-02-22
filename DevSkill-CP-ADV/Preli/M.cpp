#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;
#define MAX_N 1000000+5
#define MAX_VAL 1000000+5

bool visited[MAX_VAL];
int representative[MAX_VAL];

int find_representative(int x) {
    if(representative[x] == x)
        return x;
    return representative[x] = find_representative(representative[x]);
}

void join(int a, int b) {
    int x = find_representative(a);
    int y = find_representative(b);
    if(x != y) {
        representative[x] = y;
    }
}

void factor(int a) {
    int val = a;
    for(int d = 2; d * d <= val; d++) {
        if(val % d == 0) {
            while(val % d == 0) {
                val /= d;
            }
            join(a, d);
        }
    }

    if (val > 1) {
        join(a, val);
    }
}

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);

    int t, n, arr[MAX_N];
    scanf("%d", &t);
    for(int case_no = 1; case_no <= t; case_no++) {
        scanf("%d", &n);
        for(int i = 0; i < n; i++) {
            scanf("%d", &arr[i]);
        }

        for(int i = 0; i < MAX_VAL; i++) {
            visited[i] = false;
            representative[i] = i;
        }

        for(int i = 0; i < n; i++) {
            factor(arr[i]);
        }
        
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == 1) {
                ans++;
                continue;
            }

            int r = find_representative(arr[i]);
            if(!visited[r]) {
                ans++;
                visited[r] = true;
            }
        }
        printf("Case %d: %d\n", case_no, ans);
    }
    return 0;
}
