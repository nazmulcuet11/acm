#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>
#include <cctype>

using namespace std;

int main ()
{
    int testCases;
    scanf ("%d", &testCases);
    int cases = 0;

    while ( testCases-- )
    {
        char input [20];
        int a = 0;
        int b = 0;
        double result = 0;

        scanf("%d",&a);
        scanf ("%s", input);

        int len = strlen(input);

        printf ("Case %d: ", ++cases);

        for ( int i = 1; i < len; i++ )
        {
            if ( isdigit(input [i]) )
            {
                b = input [i] - '0';
                break;
            }
        }
        result = a * .50;
        result += b * .05;
        cout<<result<<endl;
    }

    return 0;
}
