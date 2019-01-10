#include <iostream>

using namespace std;

#define MAX_N (int)(1e5+5)
#define CHAR_SET 26

int trie[MAX_N][CHAR_SET];
int finished[MAX_N];
int node_count = 0;

int new_node()
{
    finished[node_count] = 0;
    for(int i = 0; i < CHAR_SET; i++)
    {
        trie[node_count][i] = -1;
    }
    return node_count++;
}

void init()
{
    node_count = 0;
    new_node();
}

void insert(char s[], int len)
{
    int curr = 0;
    for(int i = 0; i < len; i++)
    {
        int char_index = s[i] - 'a';
        if(trie[curr][char_index] == -1)
            trie[curr][char_index] = new_node();
        curr = trie[curr][char_index];
    }
    finished[curr] = 1;
}

int find(char s[], int len)
{
    int curr = 0;
    for(int i = 0; i < len; i++)
    {
        int char_index = s[i] - 'a';
        if(trie[curr][char_index] == -1)
            return 0;
        cout << curr << endl;
        curr = trie[curr][char_index];
    }
    return finished[curr];
}

int main(int argc, char const *argv[])
{
    char apple[] = "apple";
    char application[] = "application";
    insert(apple, 5);
    insert(application, 11);

    cout << find(apple, 5) << endl;
    // cout << find(application, 11) << endl;
    
    char abcd[] = "abcd";
    // cout << find(abcd, 4) << endl;

    return 0;
}
