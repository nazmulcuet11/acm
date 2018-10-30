#include <stdio.h>

int main()
{
    int i,j,m,n,flag=1;
    char input[101][101];
    char output[101][101];
    while(scanf("%d%d",&m,&n)==2)
    {
        getchar();
        if(m==0&&n==0)
            break;

        else
        {
            scanf("\n");
            for(i=0; i<m; i++)
            {
                for(j=0; j<n; j++)
                {
                    scanf("\n%c",&input[i][j]);
                }
            }

            for(i=0;i<m;i++)
            {
                for(j=0;j<n;j++)
                {
                    output[i][j]='0';
                }
            }

            for(i=0; i<m; i++)
            {
                for(j=0; j<n; j++)
                {
                    if(input[i][j]=='*'&&i>0&&j>0)
                    {
                        if(output[i-1][j-1]!='*')
                        output[i-1][j-1]=output[i-1][j-1]+1;

                        if(output[i-1][j]!='*')
                        output[i-1][j]=output[i-1][j]+1;

                        if(output[i-1][j+1]!='*')
                        output[i-1][j+1]=output[i-1][j+1]+1;

                        if(output[i][j-1]!='*')
                        output[i][j-1]=output[i][j-1]+1;

                        output[i][j]='*';

                        if(output[i][j+1]!='*')
                        output[i][j+1]=output[i][j+1]+1;

                        if(output[i+1][j-1]!='*')
                        output[i+1][j-1]=output[i+1][j-1]+1;

                        if(output[i+1][j]!='*')
                        output[i+1][j]=output[i+1][j]+1;

                        if(output[i+1][j+1]!='*')
                        output[i+1][j+1]=output[i+1][j+1]+1;
                    }

                    else if(input[i][j]=='*'&&i==0&&j==0)
                    {
                        output[i][j]='*';

                        if(output[i][j+1]!='*')
                        output[i][j+1]=output[i][j+1]+1;

                        if(output[i+1][j]!='*')
                        output[i+1][j]=output[i+1][j]+1;

                        if(output[i+1][j+1]!='*')
                        output[i+1][j+1]=output[i+1][j+1]+1;
                    }
                    else if(input[i][j]=='*'&&i==0&&j>0)
                    {
                        if(output[i][j-1]!='*')
                        output[i][j-1]=output[i][j-1]+1;

                        output[i][j]='*';

                        if(output[i][j+1]!='*')
                        output[i][j+1]=output[i][j+1]+1;

                        if(output[i+1][j-1]!='*')
                        output[i+1][j-1]=output[i+1][j-1]+1;

                        if(output[i+1][j]!='*')
                        output[i+1][j]=output[i+1][j]+1;

                        if(output[i+1][j+1]!='*')
                        output[i+1][j+1]=output[i+1][j+1]+1;
                    }
                    else if(input[i][j]=='*'&&i>0&&j==0)
                    {
                        if(output[i-1][j]!='*')
                        output[i-1][j]=output[i-1][j]+1;

                        if(output[i-1][j+1]!='*')
                        output[i-1][j+1]=output[i-1][j+1]+1;

                        output[i][j]='*';

                        if(output[i][j+1]!='*')
                        output[i][j+1]=output[i][j+1]+1;

                        if(output[i+1][j]!='*')
                        output[i+1][j]=output[i+1][j]+1;

                        if(output[i+1][j+1]!='*')
                        output[i+1][j+1]=output[i+1][j+1]+1;
                    }

                }
            }

            if(flag!=1)
            printf("\n");

            printf("Field #%d:\n",flag);
            flag++;

            for(i=0; i<m; i++)
            {
                for(j=0; j<n; j++)
                {
                    printf("%c",output[i][j]);
                }
                printf("\n");
            }

        }
    }
    return 0;
}
