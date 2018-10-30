#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

#define SIZE 1050

ll a[SIZE],b[SIZE];

int main()
{

	//freopen("input.in", "r", stdin);
	int m, n;
	while(scanf("%d %d",&n, &m)==2)
	{
		for(int i = 0; i<n; i++)
			scanf("%lld %lld",&a[i], &b[i]);

		for(int i = 0; i<m; i++)
		{
			ll x, y, t;
			scanf("%lld %lld %lld",&x, &y, &t);
			ll cnt = 0;

			for(int j = 0; j<n; j++)
			{
				ll M = 2*(b[j]-a[j]);
				ll temp = (t % M) + a[j];
				if(temp>b[j])
					temp = 2*b[j] - temp;

				if(x<=temp&&temp<=y)
					cnt++;
			}

			printf("%lld\n",cnt);
		}
	}
	return 0;
}
