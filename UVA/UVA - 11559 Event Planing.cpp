#include <iostream>
#include <vector>

using namespace std;
vector<int>seat_available[20];
int main()
{
    int no_of_person,budget,no_of_hotel,weak,seat_rent[20];
    while(cin>>no_of_person>>budget>>no_of_hotel>>weak)
    {
        long long int min=500005;
        for(int i=1; i<=no_of_hotel; i++)
        {
            cin>>seat_rent[i];
            for(int j=1; j<=weak; j++)
            {
                int n;
                cin>>n;
                seat_available[i].push_back(n);
            }
        }
        for(int i=1;i<=no_of_hotel;i++)
        {
            for(int j=0;j<seat_available[i].size();j++)
            {

                if(seat_available[i][j]>=no_of_person)
                {
                   long int cost=seat_rent[i]*no_of_person;
                   if(cost<=budget&&cost<min)
                   min=cost;
                }
            }
        }
        if(min!=500005)
        cout<<min<<endl;
        else
        cout<<"stay home"<<endl;
        int i=20;
        while(i--)
        seat_available[i].clear();
    }
    return 0;
}
