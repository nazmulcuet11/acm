/*
    A knight is placed in the first block of a chessboard, moving according the rules of chess, must visit one position exactly once.
*/

#include <iostream>

using namespace std;

#define N 5

int board[N][N];
int moves_x[] = { 1, 2,-1, 2,-2, 1,-1,-2};
int moves_y[] = { 2, 1, 2,-1, 1,-2,-2,-1};
int solution_cnt;

void print_board() 
{
    cout << "Solution number: " << ++solution_cnt << endl;
    for(int i = 0; i < N; i++)
    {
        for(int j = 0; j < N; j++)
        {
            cout << board[i][j] << " ";
        }
        cout << endl;
    }
    cout << "*************************" << endl << endl;
}

// generates all possible solution
void kt(int ux, int uy, int move_count) 
{
    if (move_count == N*N)
    {
        print_board();
        return;
    }

    for(int i = 0; i < 8; i++)
    {
        int vx = ux + moves_x[i];
        int vy = uy + moves_y[i];

        if(vx < 0 || vx >= N || vy < 0 || vy >= N || board[vx][vy] != -1) 
            continue;

        board[vx][vy] = move_count;
        kt(vx, vy, move_count + 1);
        board[vx][vy] = -1;
    }
}

int main(int argc, char const *argv[])
{
    // clear board
    for(int i = 0; i < N; i++)
    {
        for(int j = 0; j < N; j++)
        {
            board[i][j] = -1;
        }
    }

    // reset solution count
    solution_cnt = 0;
    
    // call knight tour
    board[0][0] = 0;
    kt(0, 0, 1);

    return 0;
}
