#include <bits/stdc++.h>

using namespace std;

struct List
{
private:
    struct Node
    {
        int data;
        Node *next, *prev;
        Node(int data) 
        {
            this->data = data;
            prev = next = NULL;
        }
    };

    Node *head, *tail;
public:
    List() { head = tail = NULL;}
    void insert(int data);
};

void List::insert(int data)
{
    if(head == NULL)
    {
        head = tail = new Node(data);
        return;
    }

    tail->next = new Node(data);
    tail = tail->next;
}