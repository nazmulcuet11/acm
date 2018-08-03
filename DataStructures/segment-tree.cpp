#include <bits/stdc++.h>

using namespace std;

#define SZ 100005

struct Node
{
    int sum, prop;
    Node(): sum(0), prop(0) {}; 
};

int arr[SZ];
Node tree[SZ*4];

void init(int node, int l, int r)
{
    if(l == r)
    {
        tree[node].sum = 0;
        tree[node].prop = 0;
        return;
    }

    int left = node*2;
    int right = node*2+1;
    int m = (l+r)/2;
    init(left, l, m);
    init(right, m+1, r);
    tree[node].sum = tree[left].sum + tree[right].sum;
    tree[node].prop = 0;
}

void update(int node, int l, int r, int i, int j, int x)
{
    if(l > j || r < i) return;

    if(i <= l && r <= j)
    {
        tree[node].sum += (r - l + 1)*x;
        tree[node].prop += x;
        return;
    }

    int left = node*2;
    int right = node*2+1;
    int m = (l+r)/2;

    //push the propagate current node has to it's child
    tree[left].sum += (m - l + 1)*tree[node].prop;
    tree[right].sum += (r - m)*tree[node].prop;
    tree[left].prop += tree[node].prop;
    tree[right].prop += tree[node].prop;
    tree[node].prop = 0;

    update(left, l, m, i, j, x);
    update(right, m+1, r, i, j, x);

    tree[node].sum = tree[left].sum + tree[right].sum;
}

int query(int node, int l, int r, int i, int j)
{
    if(l > j || r < i) return 0;

    if(i <= l && r <= j)
    {
        return tree[node].sum;
    }

    int left = node*2;
    int right = node*2+1;
    int m = (l+r)/2;

    //push the propagate current node has to it's child
    tree[left].sum += (m - l + 1)*tree[node].prop;
    tree[right].sum += (r - m)*tree[node].prop;
    tree[left].prop += tree[node].prop;
    tree[right].prop += tree[node].prop;
    tree[node].prop = 0;

    int ret1 = query(left, l, m, i, j);
    int ret2 = query(right, m+1, r, i, j);
    
    return ret1 + ret2;
}


int main(int argc, char const *argv[])
{
    
    return 0;
}
