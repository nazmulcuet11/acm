#include <stdio.h>
main()
{
    long low,max,count,i,t=1;
    while(scanf("%ld%ld",&low,&max))
    {
        if(low<0 && max<0)
        {
            break;
        }
        count=1;
        i=low;
        while(i!=1)
        {

            if(i%2==0)
            {
                i=i/2;
            }
            else
            {
                i=(3*i)+1;
            }
            if(i>max)
            {
                break;
            }
            count++;
        }
        printf("Case %ld: A = %ld, limit = %ld, number of terms = %ld\n",t,low,max,count);
        t++;
    }
    return 0;
}
