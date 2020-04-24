#include <iostream>
#include <map>
#include <string>

using namespace std;
typedef long long ll;

#define MAX_N 2005
string digits_map[] = {
    "1110111", 
    "0010010", 
    "1011101", 
    "1011011", 
    "0111010", 
    "1101011", 
    "1101111", 
    "1010010", 
    "1111111", 
    "1111011"
};
int converted_digits[10];
int bit_cnt_digits[10]; 
string input[MAX_N];
int converted_input[MAX_N];
int bit_cnt_input[MAX_N];
ll mem[MAX_N][MAX_N], n, k;
int final_digits[MAX_N];

int cnt_bit(string s) {
    int c = 0;
    for(int i = 0; i < s.size(); i++)
        if(s[i] == '1')
            c++;
    return c;
}

int convert(string s) {
    int r = 0;
    for(int i = 0; i < 7; i++) {
        if(s[i] == '1') {
            r |= 1 << i;
        }
    }
    return r;
}

bool is_poossible(int i, int r) {
    if(i >= n) {
        return mem[i][r] = r == 0;;
    }

    if(mem[i][r] != -1) 
        return mem[i][r];
    
    bool found_one_way = false;
    for(int j = 9; j >=0; j--) {
        int ci = converted_input[i];
        int cd = converted_digits[j];
        // cd must contain all digits of ci
        if((ci & cd) != ci) continue;
        int cost = bit_cnt_digits[j] - bit_cnt_input[i];
        // we don't have enough light to chage 
        if(cost > r) continue;
        if(is_poossible(i + 1, r - cost)) {
            final_digits[i] = j;
            found_one_way = true;
            break;
        }
     }
     return mem[i][r] = found_one_way;
}

int main(int argc, char const *argv[])
{
    for(int i = 0; i < 10; i++) {
        converted_digits[i] = convert(digits_map[i]);
        bit_cnt_digits[i] = cnt_bit(digits_map[i]);
    }
        
    freopen("input.txt", "r", stdin);
    string str;
    cin >> n >> k;
    for(int i = 0; i < n; i++) {
        cin >> input[i];
        converted_input[i] = convert(input[i]);
        bit_cnt_input[i] = cnt_bit(input[i]);
    }

    for(int i = 0; i < n + 5; i++)
        for(int j = 0; j < k + 5; j++)
            mem[i][j] = -1;

    bool possible = is_poossible(0, k);
    if(possible) {
        for(int i = 0; i < n; i++) {
            cout << final_digits[i];
        }
        cout << "\n";
    } else {
        cout << "-1" << endl;
    }

    return 0;
}
