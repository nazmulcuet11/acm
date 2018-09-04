#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
    //freopen("input.txt", "r", stdin);
    int n, col[105], row[105];
    char room[105][105];
    
    cin >> n;
    for(int i = 0; i < n; i++)
        for(int j = 0; j < n; j++)
            cin >> room[i][j];

    bool row_possible = true;
    for(int i = 0; i<n && row_possible; i++)
    {
        row[i] = -1;
        for(int j = 0; j <n && row[i] == -1; j++)
            if(room[j][i] != 'E')
                row[i] = j;
        row_possible = row[i] != -1;
    }

    if(row_possible)
    {
        for(int i = 0; i<n; i++)
            cout << row[i] + 1 << " " << i + 1  << endl;
        return 0;
    }


    bool col_possible = true;
    for(int i = 0; i<n && col_possible; i++)
    {
        col[i] = -1;
        for(int j = 0; j <n && col[i] == -1; j++)
            if(room[i][j] != 'E')
                col[i] = j;
        col_possible = col[i] != -1;
    }

    if(col_possible)
    {
        for(int i = 0; i<n; i++)
            cout << i + 1 << " " << col[i] + 1 << endl;
        return 0;
    }

    cout << "-1";
    return 0;
}
