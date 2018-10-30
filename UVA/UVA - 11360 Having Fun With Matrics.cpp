#include <iostream>
#include <string>
using namespace std;
int a[10][10],n;
void print();
void transpose();
void row_ab(int,int);
void col_ab(int,int);
void inc();
void dec();
int main()
{
    int test_case,o,c=1;
    string s,p;
    cin>>test_case;
    while(test_case--)
    {
        cin>>n;
        cout<<"Case #"<<c++<<endl;
        for(int i=0; i<n; i++)
            {
                cin>>p;
                for(int j=0;j<n;j++)
                a[i][j]=p[j]-'0';
            }
        cin>>o;
        while(o--)
        {
            cin>>s;
            if(s=="transpose")
                transpose();
            else if(s=="row")
            {
                int a,b;
                cin>>a>>b;
                row_ab(a,b);
            }
            else if(s=="col")
            {
                int a,b;
                cin>>a>>b;
                col_ab(a,b);
            }
            else if(s=="inc")
                inc();
            else if(s=="dec")
                dec();
        }
        print();
        cout<<endl;
    }
    return 0;
}
void print()
{
    for(int i=0; i<n; i++)
    {
        for(int j=0; j<n; j++)
            cout<<a[i][j];
        cout<<endl;
    }
}
void transpose()
{
    for(int i=0; i<n; i++)
        for(int j=i; j<n; j++)
        {
            int t=a[i][j];
            a[i][j]=a[j][i];
            a[j][i]=t;
        }
}
void row_ab(int x,int y)
{
    for(int i=0; i<n; i++)
    {
        int t=a[x-1][i];
        a[x-1][i]=a[y-1][i];
        a[y-1][i]=t;
    }
}
void col_ab(int x,int y)
{
    for(int i=0; i<n; i++)
    {
        int t=a[i][x-1];
        a[i][x-1]=a[i][y-1];
        a[i][y-1]=t;
    }
}
void inc()
{
    for(int i=0; i<n; i++)
        for(int j=0; j<n; j++)
            a[i][j]=(a[i][j]+1)%10;
}
void dec()
{
    for(int i=0; i<n; i++)
        for(int j=0; j<n; j++)
        {
            a[i][j]=a[i][j]-1;
            if(a[i][j]<0)
                a[i][j]=9;
        }
}
