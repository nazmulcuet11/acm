#include <iostream>
#include <cstdio>
#include <cstring>

using namespace std;

struct dna
{
    int sortedness_counter,input_serial;
    char seq[150];
};

int measure(char* s)
{
    int i,j,length,counter;
    counter=0;
    for(i=0; i<strlen(s)-1; i++)
    {
        for(j=i+1; j<strlen(s); j++)
        {
            if(s[i]>s[j])
                counter++;
        }
    }
    return counter;
}


int main()
{
    int n,m,i,j,test,k;
    dna object[150];

    cin>>test;

    for(k=0; k<test; k++)
    {
        cin>>n>>m;

        getchar();

        for(i=0; i<m; i++)
        {
            gets(object[i].seq);
            object[i].sortedness_counter = measure(object[i].seq);
            object[i].input_serial = i;
        }

        for(i=0; i<m-1; i++)
        {
            for(j=i+1; j<m; j++)
            {
                if(object[i].sortedness_counter>object[j].sortedness_counter)
                {
                    dna temp;
                    temp=object[i];
                    object[i]=object[j];
                    object[j]=temp;
                }
            }
        }

        for(i=0; i<m-1; i++)
        {
            for(j=i+1; j<m; j++)
            {
                if(object[i].sortedness_counter==object[j].sortedness_counter)
                {
                    if(object[i].input_serial>object[j].input_serial)
                    {
                        dna temp;
                        temp=object[i];
                        object[i]=object[j];
                        object[j]=temp;
                    }

                    else
                        continue;
                }
            }
        }

        for(i=0;i<m;i++)
        cout<<object[i].seq<<endl;

        if(k<test-1)
        cout<<endl;
    }
    return 0;
}
