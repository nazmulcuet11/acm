#include<iostream>
#include<stdio.h>
#include<vector>
#include<string.h>

using namespace std;
int n,prime,result,l,tt=1,prev_num,current_num,xx;
int str[17]= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
int visit[16],ppp[35]= {0,1,1,1,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,};
vector<int>v;

void perm()
{
    int i;

    if((!v.empty()&&v[0]>1))
        return;


    if(v.size()==n)
    {
        for(l=0; l<v.size(); l++)
        {
            if(l==0)
                printf("%d",v[l]);
            else
                printf(" %d",v[l]);
        }
        printf("\n");
    }

    if((!v.empty()&&v[0]>1))
        return;

    for(i=0; i<n; i++)
    {
        if(visit[i]==0)
        {
            v.push_back(str[i]);
            visit[i]=1;
            if(v.size()>=2&&v.size()<=n)
            {
                if(v.size()==n)
                {
                    if((ppp[v[v.size()-2]+v[v.size()-1]]==1)&&(ppp[v[n-1]+v[0]]==1))
                        perm();
                }
                else
                {
                    if(ppp[v[v.size()-2]+v[v.size()-1]]==1)
                        perm();
                }

            }
            else if(v.size()==1)
            {
                perm();
            }
            visit[i]=0;
            v.pop_back();
            xx--;
        }
    }
}

int main()
{
    int test=1;

    while(scanf("%d",&n)==1)
    {
        memset(visit,0,sizeof(visit));
        v.clear();
        xx=0;
        if(test!=1)
            printf("\n");

        printf("Case %d:\n",tt);
        perm();
        tt++;
        test++;
    }
    return 0;
}
