/*
    Place n-queen in chessboard such that no queen attack each other
*/

#include <iostream>

using namespace std;

#define N 6

int board[N][N];
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

bool is_safe(int row, int col)
{
    // check left side of this row
    for(int i = 0; i < col; i++)
        if(board[row][i] == 1)
            return false;

    // check upper diagonal on the left side
    for(int i = row, j = col; i >= 0 && j >= 0; i--, j--)
        if(board[i][j] == 1)
            return false;

    // check lower diagonal on the left side
    for(int i = row, j = col; i < N && j >= 0; i++, j--)
        if(board[i][j] == 1)
            return false;

    return true;
}

void nq(int col)
{
    if(col == N)
    {
        print_board();
        return;
    }

    for(int row = 0; row < N; row++)
    {
        if(is_safe(row, col))
        {
            board[row][col] = 1;
            nq(col + 1);
            board[row][col] = 0;
        }
    }
}

int main(int argc, char const *argv[])
{
    // reset board
    for(int i = 0; i < N; i++)
    {
        for(int j = 0; j < N; j++)
        {
            board[i][j] = 0;
        }
    }

    // reset solution count
    solution_cnt = 0;

    // call n queen
    nq(0);
    return 0;
}
