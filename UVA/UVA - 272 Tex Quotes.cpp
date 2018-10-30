#include <iostream>
#include <stdio.h>

using namespace std;

int main()
{
    char ch,f;///Alturnate: bool b=1, if(...)b=(!b)/*b er man age true(1) thakala ekhn false(0) hoya jabe..;else
    f='e';
    while(scanf("%c",&ch)!=EOF)
    {
        if(ch=='"'&&f=='e')
        {
            cout<<"``";
            f='o';
        }
        else if(ch=='"'&&f=='o')
        {
            cout<<"''";
            f='e';
        }
        else
            cout<<ch;
    }
    return 0;
}
