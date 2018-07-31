#include <iostream>

using namespace std;

#define max(a, b) ((a) > (b) ? (a) : (b))

struct Node
{
    int key, height;
    Node *left, *right;
    Node(int key): key(key), height(1), left(NULL), right(NULL) {}
    ~Node() {
        delete left;
        delete right;
    }
};


class AvlTree
{
private:
    Node *root;

    int height(Node *node) { return node ? node->height : 0; }
    int balance_factor(Node *node) { return node ? height(node->left) - height(node->right) : 0; }
    void update_height(Node *node) { node->height = 1 + max(height(node->left), height(node->right)); }
    
    Node* left_rotate(Node *x);
    Node* right_rotate(Node *x);
    Node* update_balance(Node *node);

    Node* __insert(Node *node, int key);
public:
    AvlTree();
    ~AvlTree();
    void insert(int key);
};

AvlTree::AvlTree()
{
    root = NULL;
}

AvlTree::~AvlTree()
{
    delete root;
}

Node* AvlTree::left_rotate(Node *x)
{
    /*
       x                               y
     /  \                            /   \ 
    s    y     Left Rotate(x)       x      z
        /  \   - - - - - - - ->    / \    / \
       t    z                     s   t  u   v
           / \
          u   v
    */
    Node *y = x->right;
    Node *t = y->left;

    x->right = t;
    y->left = x;

    update_height(x);
    update_height(y);

   return y; 
}

Node* AvlTree::right_rotate(Node *x)
{
    /*
           x                            y
         /  \                         /   \ 
        y    s   Right Rotate(x)     z      x
       /  \      - - - - - - - ->   / \    / \
      z    t                       v   u  t   s
     / \
    v   u
    */
    Node *y = x->left;
    Node *t = y->right;

    x->left = t;
    y->right = x;

    update_height(x);
    update_height(y);

   return y; 
}

Node* AvlTree::update_balance(Node *node)
{
    int balance = balance_factor(node);

    //left heavy
    if(balance > 1)
    {
        //height(node->left->left) >= height(node->left->right)
        if(balance_factor(node->left) >= 0)
        {
            node = right_rotate(node);
        }
        else
        {
            node->left = left_rotate(node->left);
            node = right_rotate(node);
        }
    }
    //right heavy
    else if(balance < -1)
    {
        //height(node->right->right) >= height(node->right->left)
        if(balance_factor(node->right) <= 0)
        {
            node = left_rotate(node);
        }
        else
        {
            node->right = right_rotate(node->right);
            node = left_rotate(node);
        }
    }

    return node;
}

Node* AvlTree::__insert(Node *node, int key) 
{
    if(node == NULL) return new Node(key);

    if(node->key == key) return node;

    if(key < node->key)
        node->left = __insert(node->left, key);
    else
        node->right = __insert(node->right, key);

    update_height(node);
    node = update_balance(node);
    
    return node;
} 

void AvlTree::insert(int key) 
{
    root = __insert(root, key);
}


int main(int argc, char const *argv[])
{
    AvlTree *tree = new AvlTree();
    tree->insert(3);
    tree->insert(2);
    tree->insert(4);
    tree->insert(5);
    tree->insert(6);
    return 0;
}
