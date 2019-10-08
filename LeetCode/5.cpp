#include <iostream>
#include <string>

using namespace std;

class Solution {
public:
    string longestPalindrome(string str) {
        string ans = "";
        int len = str.size();
        int mx_len = 0;
        int st, nd;
        for(int i = 0; i < len; i++)
        {
            int p_len = 0, j, k;
            for(j = i, k = i+1; j >= 0 && k < len && str[j] == str[k]; j--, k++)
            {
                p_len += 2;
            }
            if(p_len > mx_len)
            {
                mx_len = p_len;
                st = j+1;
                nd = k-1;
            }

            p_len = 1;
            for(j = i-1, k = i+1; j >= 0 && k < len && str[j] == str[k]; j--, k++)
            {
                p_len += 2;
            }
            if(p_len > mx_len)
            {
                mx_len = p_len;
                st = j+1;
                nd = k-1;
            }
        }

        for(int i = st; i <= nd; i++)
        {
            ans += str[i];
        }

        return ans;
    }
};

int main(int argc, char const *argv[])
{
    string s;
    cin >> s;
    cout << Solution().longestPalindrome(s) << endl;
    return 0;
}
