/**
@author: Nazmul Islam
*/
#include <bits/stdc++.h>

using namespace std;

bool isDigit(char ch) { return ch>='0'&&ch<='9'?true:false; }

int main()
{
	string str;
	while(cin>>str)
	{
		int len = str.size();
		int residue[3] = {0, 0, 0};
		int previous_residue[3] = {0, 0, 0};
		long long r = 0,ans = 0;

		for(int i = 0; i<len; i++)
		{
			if(!isDigit(str[i]))
			{
				memset(residue, 0, sizeof residue);
				memset(previous_residue, 0, sizeof previous_residue);

				r = 0;
				continue;
			}
			r = (str[i] - '0')%3;

			for(int j = 0; j<3; j++)
				residue[j] = previous_residue[(3 - r + j) % 3];

			residue[r]++;
			ans += residue[0];

			for(int j = 0; j<3; j++)
				previous_residue[j] = residue[j];
		}

		printf("%lld\n", ans);
	}
	return 0;
}