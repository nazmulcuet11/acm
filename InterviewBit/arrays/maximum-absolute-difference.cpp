/***
f(i, j) = |A[i] - A[j]| + |i - j|
can be broken down into: 
1. +(A[i] - A[j]) + (i - j) = (A[i] + i) - (A[j] + j)
2. -(A[i] - A[j]) + (i - j) = (A[j] - j) - (A[i] - i)
3. +(A[i] - A[j]) - (i - j) = (A[i] - i) - (A[j] - j)
4. -(A[i] - A[j]) - (i - j) = (A[j] + j) - (A[i] + i) 
Now we can see that 
For 1. 
(A[i] + i) - (A[j] + j) will be maximized when 
(A[i] + i) is maximum and (A[j] + j) is minumum, 
so we can calculate  all values of p[i] = A[i] + i 
and get maximum for 1. as x = max(p) - min(p).

For 2.
(A[j] - j) - (A[i] - i) will be maximized when 
(A[j] - j) is maximum and (A[i] - i) is minumum, 
so we can calculate  all values of q[i] = A[i] - i 
and get maximum for 2. as y = max(q) - min(q).

Note that 3 is essentially same as 2 and 4 is same as 1.

Finally we can get out answer by max(x, y)
***/

#include <iostream>
#include <vector>

using namespace std;

int maxArr(vector<int> A)
{
    int len = A.size();
    vector<int> p;
    vector<int> q;
    for (int i = 0; i < len; i++)
    {
        p.push_back(A[i] + i);
        q.push_back(A[i] - i);
    }

    sort(p.begin(), p.end());
    sort(q.begin(), q.end());

    int x = p[len - 1] - p[0];
    int y = q[len - 1] - q[0];
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
