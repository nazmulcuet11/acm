#include <iostream>
#include <algorithm>

using namespace std;

int a[6];

bool is_possible(int i, int n) {
    if(i >= 5) {
        return n == 23;
    }

    return is_possible(i + 1, n + a[i]) || is_possible(i + 1, n - a[i]) || is_possible(i + 1, n * a[i]); 
}

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);

    while(true) {
        int s = 0;
        for(int i = 0; i < 5; i++) {
            cin >> a[i];
            s += a[i];
        }

        if(s == 0)
            break;

        sort(a, a+5);
        bool possible = false;
        do {
            possible = is_possible(1, a[0]); 
            if(possible) 
                break;
        } while (next_permutation(a, a+5));
        
        if(possible) {
            cout << "Possible" << endl;
        } else {
            cout << "Impossible" << endl;
        }
    }
    return 0;
}
