#include <iostream>
#include <vector>

using namespace std;

int main()
{
    long long int m,n;
    vector<long long int>v;
    while(cin>>m>>n)
    {
        bool first=true,flag=true;
        do
        {
            if(n<2||m<2||m%n!=0)
            {
                flag=false;
                break;
            }
            v.push_back(m);
            m/=n;
        }while(m!=1);
        v.push_back(1);
        if(!flag)
            cout<<"Boring!";
        else
            for(long long int i=0; i<v.size(); i++)
            {
                if(!first)
                    cout<<" ";
                first=false;
                cout<<v[i];
            }
        cout<<endl;
        v.clear();
    }
    return 0;
}
