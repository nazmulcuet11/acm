#include <iostream>

using namespace std;

int main()
{
    int test_case,c=1,a,reasson,given;
    while(cin>>test_case&&test_case)
    {
        reasson=given=0;
        while(test_case--)
        {
            cin>>a;
            if(a==0)
            given++;
            else
            reasson++;
        }
        cout<<"Case "<<c++<<": "<<reasson-given<<endl;
    }
    return 0;
}
