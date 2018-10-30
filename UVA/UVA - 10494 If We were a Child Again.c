#include<stdio.h>
#include<string.h>

int main()
{
    long long int m,i,j,k,length,b,div,len2,output,c[50000],mod,ttt[50000],ddd=0,xxx=0;
    char input[50000];
    char opr,a[50000];

    while(gets(input))
    {
        mod=0;
        div=0;
        b=0;
        ddd=0;
        output=0;
        length=strlen(input);
        for(i=0; i<length; i++)
        {
            if(input[i]<'0'||input[i]>'9')
                break;

            else
                a[i]=input[i];
        }
        a[i]='\0';


        for(j=0,k=i; k<length; k++)
        {
            if(input[k]>='0'&&input[k]<='9')
            {
                b=b*10+(input[k]-48);
                j++;
            }

            else if(input[k]=='/'||input[k]=='%')
                opr=input[k];

        }

        len2=strlen(a);


        for(i=0;i<j;i++)
        {
        ddd=ddd*10+a[i]-48;
        if(i==len2-1)
        i=j;
        }

        if(j>=len2)
        {
            if(opr=='/')
            {
                if(ddd>b)
                {
                    printf("%lld\n",ddd/b);
                    continue;
                }
                else if(ddd<b)
                {
                    printf("0\n");
                    continue;
                }
                else
                {
                    printf("1\n");
                    continue;
                }
            }
            else if(opr=='%')
            {
                if(ddd>b)
                {
                    printf("%lld\n",ddd%b);
                    continue;
                }
                else if(ddd<b)
                {
                    printf("%lld\n",ddd);
                    continue;
                }
                else
                {
                    printf("0\n");
                    continue;
                }
            }

        }

        if(ddd<b)
        {
            ddd=ddd*10+a[i]-48;
            i++;
        }

        for(k=0,i;i<len2;)
        {
           if((ddd/b)>0)
           {
               output=ddd/b;
               ddd=ddd%b;
               ddd=ddd*10+a[i]-48;
                i++;
               c[k]=output;
               k++;
           }
           else
           {
               output=0;
               ddd=ddd*10+a[i]-48;
               ++i;
               c[k]=output;
               k++;
           }
           }
           output=ddd/b;
           c[k]=output;
           k++;
           ddd=ddd%b;

        if(opr=='/')
        {
            for(i=0;i<k;i++)
            printf("%lld",c[i]);
            printf("\n");
        }



        if(opr=='%')
        printf("%lld\n",ddd);
        }
return 0;
}
