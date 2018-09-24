#include <iostream>

using namespace std;

#define SZ 105
int n, arr[SZ], mem[SZ][4];

int get_possible_activity(int current_activity, int last_activity)
{
    if(current_activity == 0) return 0;
    if(current_activity == 3) return current_activity ^ last_activity;
    return last_activity != current_activity ? current_activity : 0;
}

int solve(int i, int last_activity) 
{
    if(i == n)
        return 0;

    if(mem[i][last_activity] != -1)
        return mem[i][last_activity];

    int possible_activity = get_possible_activity(arr[i], last_activity);
    //whatever the schedule is, take rest ;p
    int ans = solve(i + 1, 0) + 1;
    //check if sports is possible
    if(possible_activity & 1)
        ans = min(ans, solve( i + 1, 1));
    //check if coding is possible
    if(possible_activity & (1 << 1))
        ans = min(ans, solve( i + 1, 2));

    return mem[i][last_activity] = ans;
}

int main(int argc, char const *argv[])
{
    freopen("input.txt", "r", stdin);
    memset(mem, -1, sizeof mem);

    cin >> n;
    for(int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    //last day I rested fulll day ;p
    cout << solve(0, 0) << endl;
    
    return 0;
}
