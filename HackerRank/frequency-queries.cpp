/*
  _   _                           _ 
 | \ | | __ _ _____ __ ___  _   _| |
 |  \| |/ _` |_  / '_ ` _ \| | | | |
 | |\  | (_| |/ /| | | | | | |_| | |
 |_| \_|\__,_/___|_| |_| |_|\__,_|_|
                                    
*/

#include <iostream>
#include <stdio.h>
#include <map>

using namespace std;
typedef long long ll;

#define SIZE 1000005

int main() {
  freopen("input.txt", "r", stdin);
  freopen("output.txt", "w", stdout);

  ll q, c, n;
  map<ll, ll> number_map;
  ll freq_map[SIZE];

  for(int i = 0; i < SIZE; i++)
    freq_map[i] = 0;

  scanf("%lld", &q);
  for (int i = 0; i < q; i++) {
    scanf("%lld %lld", &c, &n);

    if (c == 1) {
      ll prev_freq = number_map[n];
      if (freq_map[prev_freq] > 0)
        freq_map[prev_freq]--;
      freq_map[prev_freq + 1]++;
      number_map[n]++;
    }
    if (c == 2) {
      ll prev_freq = number_map[n];
      if (prev_freq > 0) {
        // there is no need to count 0 frequency elements
        if (prev_freq - 1 > 0)
          freq_map[prev_freq - 1]++;
        number_map[n]--;
        freq_map[prev_freq]--;
      }
    }
    if (c == 3) {
      int ans = n < SIZE ? freq_map[n] > 0 : 0;
      printf("%d\n", ans);
    }
  }
}
