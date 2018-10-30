#include <stdio.h>
#include <stdlib.h>

int main()
{
    int i,j,v,test,n,save;
    scanf("%d",&test);
    for(i=1;i<=test;i++)
    {
        save=0;
        scanf("%d",&n);
        for(j=0;j<n;j++)
        {
            scanf("%d",&v);
            if(v>save)
            save=v;
        }
        printf("Case %d: %d\n",i,save);
    }
    return 0;
}
