#include<stdio.h>
#include<math.h>

int main()
{
    long long int n,distance,root,prev_sqr_num,next_sqr_num,x,y;
    while(scanf("%lld",&n)==1)
    {
        if(n==0)
        break;

        root=ceil(sqrt(n));
        prev_sqr_num=(root-1)*(root-1);
        next_sqr_num=root*root;
        distance=next_sqr_num-n;

        if(root%2==0)
        {
            if(distance<root)
            {
                x=root;
                y=1+distance;
            }

            else if(distance>=root)
            {
                y=root;
                x=n-prev_sqr_num;
            }

        }

        else if(root%2!=0)
        {
            if(distance<root)
            {
                y=root;
                x=1+distance;
            }
            else if(distance>=root)
            {
                x=root;
                y=n-prev_sqr_num;
            }
        }

        printf("%lld %lld\n",x,y);
    }
    return 0;
}
