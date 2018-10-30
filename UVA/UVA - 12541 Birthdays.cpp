#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

struct person
{
    string name;
    int date,month,year;
};
bool my_sort(person a,person b)
{
    if(a.year<b.year)
    return true;
    else if(a.year==b.year)
    return a.month<b.month;
    else if(a.year==b.year&&a.month==b.month)
    return a.date<b.date;
    return false;
}
int main()
{
    int test_case;
    person p[105];
    cin>>test_case;
    for(int i=0;i<test_case;i++)
    {
        cin>>p[i].name>>p[i].date>>p[i].month>>p[i].year;
    }
    sort(p,p+test_case,my_sort);
    cout<<p[test_case-1].name<<endl<<p[0].name<<endl;
    return 0;
}
