// #include <bits/stdc++.h>
#include <iostream> 
#include <algorithm>
#include <vector>


using namespace std;

#define MAX_N 100005

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);

    int test_case, n, arr[MAX_N];
    scanf("%d", &test_case);
    while(test_case--) {
        scanf("%d", &n);
        for(int i = 0; i < n; i++)
        {
            scanf("%d", &arr[i]);
        }

        sort(arr, arr + n);

        vector<int> ans;
        int l, r;
        if(n % 2 == 0) {
            r = n / 2;
            l = r - 1;
        } else {
            int mid_index = n / 2;
            ans.push_back(arr[mid_index]);
            l = mid_index - 1;
            r = mid_index + 1; 
        }

        while(l >= 0 && r < n)
        {
            ans.push_back(arr[l]);
            ans.push_back(arr[r]);
            l--;
            r++;
        }
        
        for(int i = 0; i < n; i++) {
            printf("%d ", ans[i]);
        }
        printf("\n");
    }
    return 0;
}