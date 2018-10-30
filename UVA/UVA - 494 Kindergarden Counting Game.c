#include <stdio.h>
#include <string.h>

int main()
{
    char input[50000];
    int length,counter,i;

    while(gets(input))
    {
        length=strlen(input);
        counter=0;
        for(i=0;i<length;)
        {
            if((input[i]>=65&&input[i]<=90)||(input[i]>=97&&input[i]<=122))
            {
                while(((input[i]>=65&&input[i]<=90)||(input[i]>=97&&input[i]<=122))&&i<length)
                {i++;}
                counter++;
            }
            else
            i++;
        }
        printf("%d\n",counter);
    }
    return 0;
}
