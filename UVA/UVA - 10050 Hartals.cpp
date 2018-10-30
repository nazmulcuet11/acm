#include <iostream>

using namespace std;

int main()
{
    int testcase,number_of_days,number_of_pp,hartal_parameter[105],count;
    cin>>testcase;
    while(testcase--)
    {
        count=0;
        cin>>number_of_days;
        cin>>number_of_pp;
        for(int i=0; i<number_of_pp; i++)
            cin>>hartal_parameter[i];
        for(int i=1; i<=number_of_days; i++)
        {
            for(int j=0; j<number_of_pp; j++)
                if(i%hartal_parameter[j]==0&&i%7!=0&&(i+1)%7!=0)
                {
                    count++;
                    break;
                }
        }
        cout<<count<<endl;
    }
    return 0;
}
