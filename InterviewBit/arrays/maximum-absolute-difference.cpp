#include <iostream>
#include <vector>

using namespace std;

int maxArr(vector<int> A) {
    int len = A.size();
    vector<int> p;
    vector<int> q;
    for(int i = 0; i < len; i++) {
        p.push_back(A[i] + i);
        q.push_back(A[i] - i);
    }

    sort(p.begin(), p.end());
    sort(q.begin(), q.end());

    int x = p[len-1] - p[0];
    int y = q[len-1] - q[0];
    return max(x, y);
}

int main(int argc, char const *argv[])
{
    int arr[] = {55, -8, 43, 52, 8, 59, -91, -79, -18, -94};

    int n = sizeof(arr) / sizeof(arr[0]);
    vector<int> v;
    for (int i = 0; i < n; i++)
    {
        v.push_back(arr[i]);
    }
    

    int ans = maxArr(v);
    cout << ans << endl;
    
    return 0;
}
