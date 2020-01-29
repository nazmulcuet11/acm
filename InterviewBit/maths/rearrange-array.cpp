#include <iostream>
#include <vector>

using namespace std;

int dfs(int x, vector<int> &A) 
{
    if(A[x] < 0)
        return A[x];

    int t = A[x];
    A[x] = -A[x];
    int next = t == A.size() ? 0: t;
    A[x] = dfs(next, A);
    return -t;
}

class Solution {
    public:
    void arrange(vector<int> &A);
};

void Solution::arrange(vector<int> &A) {
    int N = A.size();
    for(int i = 0; i < N; i++) 
        if(A[i] == 0)
            A[i] = N;
        

    for(int i = 0; i < N; i++)
        if(A[i] > 0)
            dfs(i, A);

    for(int i = 0; i < N; i++) 
    {
        A[i] = -A[i];
        if(A[i] == N)
            A[i] = 0;
    }
}

int main(int argc, char const *argv[])
{
    cout << "Hello World" << endl;
    vector<int> vec;
    vec.push_back(4);
    vec.push_back(0);
    vec.push_back(2);
    vec.push_back(1);
    vec.push_back(3);

    Solution().arrange(vec);
    for(int i = 0; i < vec.size(); i++) 
    {
        cout << vec[i] << endl;
    }

    return 0;
}
