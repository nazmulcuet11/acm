#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    long long int test_case,a[10050],book1,book2,dif,ans,budget;
    while(cin>>test_case)
    {
        for(int i=0; i<test_case; i++)
            cin>>a[i];
        sort(a,a+test_case);
        ans=9999999;
        cin>>budget;
        for(int i=0;i<test_case;i++)
        {
            if(a[i]<budget&&a[i]<=budget-a[i])
            {
                if(binary_search(a,a+test_case,budget-a[i]))
                {
                    dif=(budget-a[i])-a[i];
                    if(dif<ans)
                    {
                        book1=a[i];
                        book2=budget-a[i];
                    }
                }
            }
        }
        cout<<"Peter should buy books whose prices are "<<book1<<" and "<<book2<<"."<<endl<<endl;
    }
    return 0;
}
