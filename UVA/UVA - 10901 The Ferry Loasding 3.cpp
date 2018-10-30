#include<iostream>
#include<string.h>
#include<stdio.h>
#include<queue>

using namespace std;

int main()
{
    int test_case,n,t,m,arriving_time,total_time,num_of_line,counter,start,first;
    int i,j,k;
    char ferry_now_in,bank[10];
    queue<int>ar_time_left;
    queue<int>crossing_time_left;
    queue<int>ar_time_rigth;
    queue<int>crossing_time_right;
    queue<char>ri_bank_left;
    queue<char>ri_bank_rigth;
    queue<char>input_sequence;

    scanf("%d",&test_case);
    for(i=0; i<test_case; i++)
    {
        //if(i>0)
        //printf("\n");

        total_time=0;
        ferry_now_in='l';
        scanf("%d %d %d",&n,&t,&m);
        for(j=0; j<m; j++)
        {
            scanf("%d %s",&arriving_time,bank);

            input_sequence.push(bank[0]);
            if(j==0)
                first=arriving_time;

            if(bank[0]=='l')
            {
                ar_time_left.push(arriving_time);
                ri_bank_left.push(bank[0]);
            }
            else
            {
                ar_time_rigth.push(arriving_time);
                ri_bank_rigth.push(bank[0]);
            }
        }

        total_time=total_time+first;
        while(m>0)
        {
            if(ferry_now_in=='l')
            {
                counter=0;
                if(ar_time_left.front()<=total_time&&!ar_time_left.empty())
                {

                    counter=0;
                    for(k=0; k<n; k++)
                    {
                        if(ar_time_left.front()<=total_time&&!ar_time_left.empty())
                        {
                            counter++;
                            ar_time_left.pop();
                            ri_bank_left.pop();
                            m--;
                        }
                    }

                    total_time=total_time+t;
                    ferry_now_in='r';
                }

                else if(ar_time_left.front()>total_time&&(ar_time_left.front()<=ar_time_rigth.front()||ar_time_rigth.empty()))
                {
                    total_time=ar_time_left.front();

                    counter=0;
                    for(k=0; k<n; k++)
                    {
                        if(ar_time_left.front()<=total_time&&!ar_time_left.empty())
                        {
                            counter++;
                            ar_time_left.pop();
                            ri_bank_left.pop();
                            m--;
                        }
                    }

                    total_time=total_time+t;
                    ferry_now_in='r';
                }

                else if((ar_time_left.front()>total_time||ar_time_left.empty())&&((ar_time_left.front()>ar_time_rigth.front()||ar_time_left.empty())&&!ar_time_rigth.empty()))
                {

                    if(ar_time_rigth.front()>total_time)
                    {

                        total_time=ar_time_rigth.front();
                    }

                    total_time=total_time+t;
                    ferry_now_in='r';
                }
                for(k=0; k<counter; k++)
                {
                    crossing_time_left.push(total_time);

                }
            }

            else
            {
                counter=0;
                if(ar_time_rigth.front()<=total_time&&!ar_time_rigth.empty())
                {

                    counter=0;
                    for(k=0; k<n; k++)
                    {
                        if(ar_time_rigth.front()<=total_time&&!ar_time_rigth.empty())
                        {
                            counter++;
                            ar_time_rigth.pop();
                            ri_bank_rigth.pop();
                            m--;
                        }
                    }

                    total_time=total_time+t;
                    ferry_now_in='l';
                }
                else if(ar_time_rigth.front()>total_time&&(ar_time_rigth.front()<ar_time_left.front()||ar_time_left.empty()))
                {

                    total_time=ar_time_rigth.front();

                    counter=0;
                    for(k=0; k<n; k++)
                    {
                        if(ar_time_rigth.front()<=total_time&&!ar_time_rigth.empty())
                        {
                            counter++;
                            ar_time_rigth.pop();
                            ri_bank_rigth.pop();
                            m--;
                        }
                    }

                    total_time=total_time+t;
                    ferry_now_in='l';
                }

                else if((ar_time_rigth.front()>total_time||ar_time_rigth.empty())&&((ar_time_rigth.front()>=ar_time_left.front()||ar_time_rigth.empty())&&!ar_time_left.empty()))
                {
                    if(ar_time_left.front()>total_time)
                    {

                        total_time=ar_time_left.front();
                    }

                    total_time=total_time+t;
                    ferry_now_in='l';
                }

                for(k=0; k<counter; k++)
                {
                    crossing_time_right.push(total_time);

                }

            }
        }
        if(i>0)
        printf("\n");
        while(!input_sequence.empty())
        {
            if(input_sequence.front()=='l')
            {
                printf("%d\n",crossing_time_left.front());
                crossing_time_left.pop();
            }
            else
            {
                printf("%d\n",crossing_time_right.front());
                crossing_time_right.pop();
            }
            input_sequence.pop();
        }
    }
    return 0;
}

