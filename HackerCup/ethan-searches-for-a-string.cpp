#include <bits/stdc++.h>

using namespace std;

bool ethans_algorithm(string a, string b)
{
    int i = 0, j = 0;
    
    while(true)
    {
        if(i >= a.size()) return true;
        if(j >= b.size()) return false;

        if(a[i] == b[j])
        {
            i++;
            j++;
        }
        else if(i == 0)
            j++;
        else
            i = 0;
    }
}


int main(int argc, char const *argv[])
{
    freopen("ethan_searches_for_a_string.txt", "r", stdin);
    freopen("ethan_searches_for_a_string-output.txt", "w", stdout);

    int test_case, case_no = 1;

    cin >> test_case;
    while(test_case--)
    {
        string a, b = "";
        cin >> a;
    
        for(int i = 0; i < a.size(); i++)
        {
            if(i > 0 && a[i] == a[0])
                break;
            b += a[i];
        }
        
        b += a;

        printf("Case #%d: ", case_no++);
        if(ethans_algorithm(a, b))
            cout << "Impossible" << endl;
        else
            cout << b << endl;
    }

    return 0;
}
