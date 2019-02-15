#include <iostream>
#include <vector>

using namespace std;

int maxSubArray(const vector<int> &A) {
    int curr_sum = 0 , max_sum = A.size() > 0 ? A[0] : 0;
    for(int i = 1; i < A.size(); i++) {
        max_sum = max(max_sum, curr_sum + A[i]);
        curr_sum = max(curr_sum + A[i], 0);
    }
    return max_sum;
    
    /*
    // Fastest Solution
    int curr_sum = A.size() > 0 ? A[0] : 0 , max_sum = A.size() > 0 ? A[0] : 0;
    for(int i = 1; i < A.size(); i++) {
        curr_sum = max(curr_sum + A[i], A[i]);
        max_sum = max(max_sum, curr_sum);
    }
    return max_sum;
    */
}

int main(int argc, char const *argv[])
{
    int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
    vector<int> a(arr, arr+9);
    cout << maxSubArray(a) << endl;

    a.clear();
    a.push_back(-500);
    cout << maxSubArray(a) << endl;
    return 0;
}
