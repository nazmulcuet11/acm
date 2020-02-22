#include <iostream>

using namespace std;

#define MAX_N 200000+5

int main(int argc, char const *argv[])
{
    int n, k, q, admissible[MAX_N];
    for(int i = 0; i < MAX_N; i++) 
        admissible[i] = 0;

    cin >> n >> k >> q;
    for(int i = 0; i < n; i++) {
        int l, r;
        cin >> l >> r;
        admissible[l]++;
        admissible[r+1]--;
    }

    for(int i = 1; i < MAX_N; i++)
        admissible[i] += admissible[i-1];

    for(int i = 1; i < MAX_N; i++) {
        admissible[i] = admissible[i] >= k ? 1 : 0;
        admissible[i] += admissible[i-1];
    }

    for(int i = 0; i < q; i++) {
        int l, r;
        cin >> l >> r;
        cout << admissible[r] - admissible[l-1] << endl;
    }
    return 0;
}
