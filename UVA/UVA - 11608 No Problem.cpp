#include <iostream>
#include <cstdio>

using namespace std;

int main()
{
    int start,have[13],requred[12],set=0;
    while((cin>>start)&&start>=0)
    {
        cout<<"Case "<<++set<<":"<<endl;
        have[0]=start;
        for(int i=1;i<13;i++)
        cin>>have[i];
        for(int i=0;i<12;i++)
        cin>>requred[i];
        for(int i=0;i<12;i++)
        {
            if(have[i]>=requred[i])
            {
                cout<<"No problem! :D"<<endl;
                have[i]-=requred[i];
            }
            else
            cout<<"No problem. :("<<endl;
            have[i+1]+=have[i];
        }
    }
    return 0;
}
