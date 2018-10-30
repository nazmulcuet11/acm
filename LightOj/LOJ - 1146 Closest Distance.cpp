#include <cstdio>
#include <cmath>
#include <iostream>
#define sqr(a) (a*a)
#define eps 1e-7
using namespace std;
struct P{double x,y;P(double x=0,double y=0){this->x=x;this->y=y;}void scan(){cin>>x>>y;}};
P MV(P a,P b){return P(b.x-a.x,b.y-a.y);}
double DP(P a,P b){return a.x*b.x+a.y*b.y;}
double DIST(P a,P b){return sqrt(sqr(MV(a,b).x)+sqr(MV(a,b).y));}
P a,b,c,d;
double calculate_distance(double l)
{
    P x=P(a.x+l*MV(a,b).x,a.y+l*MV(a,b).y);///Jehetu 0 theke 1 length dhore nisi sehetu allready unit vector a ase...eijnno agin ABS(MV(a,b)) dia vag dea jabe na..
    P y=P(c.x+l*MV(c,d).x,c.y+l*MV(c,d).y);
    return DIST(x,y);
}
double ternary_search()
{
    double low=0,high=1,left,right;
    for(int i=0;i<200;i++)
    {
        left=(2*low+high)/3;
        right=(low+2*high)/3;
        if(calculate_distance(left)<calculate_distance(right))
            high = right;
        else low = left;
    }
    return calculate_distance((high+low)/2);
}
int main() {
	int test_case;
	cin>>test_case;
	for(int i = 1; i<= test_case; i++) {
		a.scan();b.scan();c.scan(); d.scan();
		printf("Case %d: %.10lf\n", i, ternary_search());
	}
	return 0;
}
