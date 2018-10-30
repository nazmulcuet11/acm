#include <iostream>
#include <stdio.h>
#include <string.h>

using namespace std;

int main()
{
    int prime[1100]= {0},length;
    char input[21];

    for(int i=1; i<1100; i+=2)
        prime[i]=i;

    prime[2]=2;

    for(int i=3; i<34; i+=2)
        for(int j=i*3; j<1100; j+=i)
            prime[j]=0;

    while(gets(input))
    {
        int sum =0;
        length=strlen(input);
        for(int i=0;i<length;i++)
        {
            if(input[i]>='a'&&input[i]<='z')
            {
                sum+=(input[i]-'a'+1);
            }
            else if(input[i]>='A'&&input[i]<='Z')
            {
                sum+=(input[i]-'A'+27);
            }
        }

        if(prime[sum]>0)
        cout<<"It is a prime word."<<endl;

        else
        cout<<"It is not a prime word."<<endl;
    }
    return 0;
}
