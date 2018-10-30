#include<iostream>
#include<cstdio>
#include<string.h>

using namespace std;
char input[100000];

int main()
{
    gets(input);
    int length = strlen(input);

    char pressed[] = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ`1234567890-=[]\\;',./";
    char ac_output[] = "  czaqsdfyghjbvui w etx  r  czaqsdfyghjbvui w etx  r   `1234567890op[klnm,";

    int pressed_length = strlen(pressed);

    for(int i = 0; i < length; i++)
    {
        for(int j = 0; j < pressed_length; j++)
        {
            if(pressed[j] == input[i])
            {
                printf("%c", ac_output[j]);
                break;
            }
        }
    }
    printf("\n");
}
