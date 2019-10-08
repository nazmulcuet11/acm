#include <iostream>
#include <string>

using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int len = s.size();
        int mx_cnt = 0, cnt = 0, last_index[257], st = 0;
        for(int i = 0; i < 257; i++)
            last_index[i] = -1;

        for(int i = 0; i < len; i++)
        {
            if(last_index[s[i]] != -1 && st <= last_index[s[i]])
            {
                cnt = max(0, i - last_index[s[i]]);
                st = last_index[s[i]] + 1;
            }
            else 
            {
                cnt++;
            }

            last_index[s[i]] = i;
            mx_cnt = max(mx_cnt, cnt);
        }

        return mx_cnt;
    }
};

int main(int argc, char const *argv[])
{
    cout << Solution().lengthOfLongestSubstring("wobgrovw") << endl;
    cout << Solution().lengthOfLongestSubstring("bbbbb") << endl;
    cout << Solution().lengthOfLongestSubstring("pwwkew") << endl;
    cout << Solution().lengthOfLongestSubstring("abba") << endl;
    cout << Solution().lengthOfLongestSubstring("zwnigfunjwz") << endl;
    cout << Solution().lengthOfLongestSubstring("abba") << endl;
    cout << Solution().lengthOfLongestSubstring("abba") << endl;
    return 0;
}
