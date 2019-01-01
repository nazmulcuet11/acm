#include <iostream>

using namespace std;

struct Node
{
    int data;
    Node *next;
    Node(int data = 0, Node *next = NULL) {
        this->data = data;
        this->next = next;
    }
};

void print(Node *head)
{
    Node *curr = head;
    while(curr) 
    {
        cout << curr->data << "-->";
        curr = curr->next;
    }
    cout << endl;
}

Node* insert(int data, Node *head)
{
    return new Node(data, head);
}

Node* remove(int data, Node *head)
{
    if(head == NULL)
        return NULL;

    if(head->data == data)
    {
        Node *temp = head->next;
        delete head;
        return temp;
    }

    Node *curr = head;
    while(curr && curr->next)
    {
        if(curr->next->data == data)
        {
            Node *temp = curr->next;
            curr->next = curr->next->next;
            delete temp;
            break;
        }
        curr = curr->next;
    }
    return head;
}

int main(int argc, char const *argv[])
{
    Node *head = NULL;
    head = insert(1, head);
    head = insert(2, head);
    head = insert(3, head);
    head = insert(4, head);
    head = insert(5, head);
    head = insert(6, head);
    print(head);

    head = remove(4, head);
    print(head);

    head = remove(1, head);
    print(head);

    head = remove(6, head);
    print(head);

    return 0;
}


