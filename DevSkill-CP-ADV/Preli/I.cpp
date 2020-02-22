#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

typedef long long ll;

#define sqr(a) ((a)*(a))
#define MAX_N 1000+5

struct Point {
    double x, y;
    Point(double x = 0, double y = 0) {
        this->x = x;
        this->y = y;
    }
};

bool comp(Point a, Point b) {
    if(a.x == b.x) 
        return a.y < b.y;
    return a.x < b.x;
}

Point points[MAX_N];
int main(int argc, char const *argv[])
{
    //freopen("input.txt", "r", stdin);

    int t;
    cin >> t;
    for(int case_no = 1; case_no <= t; case_no++) {
        int n;
        cin >> n;
        for(int i = 0; i < n; i++)
            cin >> points[i].x >> points[i].y;

        vector<Point> vec;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                double mid_x = (points[i].x + points[j].x) / 2;
                double mid_y = (points[i].y + points[j].y) / 2;
                vec.push_back(Point(mid_x, mid_y));
            }
        }

        sort(vec.begin(), vec.end(), comp);
        ll ans = 0, cnt = 1;
        for(int i = 1; i <= vec.size(); i++) {
            if(i <vec.size() && vec[i].x == vec[i-1].x && vec[i].y == vec[i-1].y) {
                cnt++;
            } else {
                ans += (cnt*(cnt-1))/2;
                cnt = 1;
            }
        }
        cout << "Case " << case_no << ": " << ans << endl;
    }
    return 0;
}
