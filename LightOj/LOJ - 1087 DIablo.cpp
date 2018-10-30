#include <iostream>
#include <cstdio>
#include <algorithm>
#include <vector>
using namespace std;
int main()
{
    int test_case,n,q,index,x;
    char command;
    scanf("%d",&test_case);
    for(int case_no=1; case_no<=test_case; case_no++)
    {
        scanf("%d %d",&n,&q);
        vector <int> army;
        for(int i=0; i<n; i++)
        {
            scanf("%d",&x);
            army.push_back(x);
        }
        printf("Case %d:\n",case_no);
        for(int i=0; i<q; i++)
        {
            getchar();
            scanf("%c %d",&command,&index);
            if(command=='a')
                army.push_back(index);
            else
            {
                if(army.size()<index)
                    printf("none\n");
                else
                {
                    printf("%d\n",army[index-1]);
                    army.erase(army.begin()+(index-1));
                }
            }
        }
    }
    return 0;
}
