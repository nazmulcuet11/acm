#include<stdio.h>
#include<string.h>
#include<ctype.h>

int isvowel(char ch)
{
    if(ch=='a'|| ch=='A'||ch=='e'|| ch=='E'||ch=='i'|| ch=='I'||ch=='u'|| ch=='U'||ch=='o'|| ch=='O')
        return 1;

    else
        0;
}

int main()
{
    char input,temp;
    while(input=getchar())
    {
        if(input==EOF)
            break;

        else
        {
            if(isalpha(input))
            {
                if(isvowel(input)==1)
                {
                    while(isalpha(input))
                    {
                        printf("%c",input);
                        input=getchar();
                    }
                    printf("ay");
                }

                else
                {
                    temp=input;
                    input=getchar();
                    while(isalpha(input))
                    {
                        printf("%c",input);
                        input=getchar();
                    }
                    printf("%cay",temp);
                }
            }
        }
        printf("%c",input);
    }
    return 0;
}
