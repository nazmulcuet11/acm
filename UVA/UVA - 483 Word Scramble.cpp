#include <iostream>
#include <stdio.h>
#include <stack>

using namespace std;

int main()
{
    char ch;
    stack<char>temp;

    while(scanf("%c",&ch)==1)
    {
     if(ch=='\n')
     {
         while(!temp.empty())
         {
             printf("%c",temp.top());
             temp.pop();
         }
         printf("\n");
     }
     else if(ch==' ')
     {
         while(!temp.empty())
         {
             printf("%c",temp.top());
             temp.pop();
         }
          printf(" ");
     }
     else
     temp.push(ch);
    }
    return 0;
}
