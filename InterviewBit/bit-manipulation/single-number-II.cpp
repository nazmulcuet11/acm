#include <iostream>

using namespace std;

class Solution {
public:
    int singleNumber(int nums[], int n) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                int num = nums[j];
                if((num & (1 << i)) > 0) 
                    count++;
            }

            if (count % 3 == 1) {
                ans |= 1 << i;
            } 
        }

        if((ans & 1 << 31) > 0) 
            return -1 * ~ans;

        return ans;
    }
};

int main() {
    int a[] = {-2, -2, 1, 1, -3, 1, -3, -3, -4, -2};
    int ans = Solution().singleNumber(a, 10);
    cout << ans << endl;
}