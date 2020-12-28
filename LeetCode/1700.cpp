#include <iostream>
#include <queue>

using namespace std;

class Solution
{
public:
    int countStudents(vector<int> &students, vector<int> &sandwiches)
    {
        queue<int> sand_q;
        queue<int> stud_q;

        for (auto s : sandwiches)
            sand_q.push(s);

        for (auto s : students)
            stud_q.push(s);

        int pass_without_taking = 0;
        while (!stud_q.empty())
        {
            if (pass_without_taking > stud_q.size())
                return stud_q.size();

            if (stud_q.front() == sand_q.front())
            {
                stud_q.pop();
                sand_q.pop();
                pass_without_taking = 0;
            }
            else
            {
                int t = stud_q.front();
                stud_q.pop();
                stud_q.push(t);
                pass_without_taking++;
            }
        }
        return 0;
    }
};