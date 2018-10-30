#include <iostream>
#include <cmath>
#include <algorithm>

using namespace std;

int main()
{
    int prime1[8]= {2, 3, 5, 7, 13, 17, 19, 31};
    int prime2[11]= {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
    int n;
    while(cin>>n&&n)
    {
        if(binary_search(prime1,prime1+8,n))
        {
            long long int l=(pow(2,n-1))*(pow(2,n)-1);
            cout<<"Perfect: "<<l<<"!"<<endl;
        }
        else if(binary_search(prime2,prime2+11,n))
            cout<<"Given number is prime. But, NO perfect number is available."<<endl;
        else
            cout<<"Given number is NOT prime! NO perfect number is available."<<endl;
    }
    return 0;
}
