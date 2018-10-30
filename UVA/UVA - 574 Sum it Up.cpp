#include<cstdio>
#include<map>
#include<vector>

using namespace std;

int t, n;
int ar[20];
map<vector<int>, bool > solutions;
vector<int> v;

void search(int index, int sum)
{
    if(sum == t)
    {
        if(solutions[v] == true) return;
        solutions[v] = true;
        for(int i = 0; i < v.size(); i++)
            printf(i == v.size() - 1? "%d" : "%d+", v[i]);
        printf("\n");
        return;
    }
    if(sum > t || index == n) return;
    for(int i = index; i < n; i++)
    {
        v.push_back(ar[i]);
        search( i + 1, sum + ar[i]);
        v.pop_back();
    }
}

int main()
{
    for(;;)
    {
        scanf("%d %d", &t, &n);
        if(t == 0 && n == 0) break;
        for(int i = 0; i < n; i++)
            scanf("%d", &ar[i]);
        v.clear();
        solutions.clear();
        printf("Sums of %d:\n", t);
        search(0, 0);
        if(solutions.size() == 0) printf("NONE\n");
    }
}
