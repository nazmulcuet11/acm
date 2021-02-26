#include <iostream>
#include <map>

using namespace std;

template <typename T>
class LinkedListNode
{
public:
    T value;
    LinkedListNode *prev;
    LinkedListNode *next;

    LinkedListNode(T value)
    {
        this->value = value;
        this->prev = NULL;
        this->next = NULL;
    }
};

template <typename T>
class LinkedList
{
private:
    int count;
    LinkedListNode<T> *head;
    LinkedListNode<T> *tail;

public:
    LinkedList()
    {
        this->count = 0;
        this->head = NULL;
        this->tail = NULL;
    }

    LinkedListNode<T> *append(T value)
    {
        LinkedListNode<T> *node = new LinkedListNode<T>(value);
        if (this->tail)
        {
            node->prev = this->tail;
            this->tail->next = node;
            this->tail = this->tail->next;
        }
        else
        {
            this->head = this->tail = node;
        }
        this->count += 1;
        return node;
    }

    LinkedListNode<T> *prepend(T value)
    {
        LinkedListNode<T> *node = LinkedListNode<T>(value);
        if (this->head)
        {
            node->next = this->head;
            this->head->prev = node;
            this->head = this->head->prev;
        }
        else
        {
            this->head = this->tail = node;
        }
        this->count += 1;
        return node;
    }

    void remove(LinkedListNode<T> *node)
    {
        if (this->head == NULL || node == NULL)
        {
            return;
        }

        if (node == this->head)
        {
            if (this->head->next)
            {
                this->head = this->head->next;
                this->head->prev = NULL;
                node->next = NULL;
            }
            else
            {
                this->head = this->tail = NULL;
            }
        }
        else if (node == this->tail)
        {
            if (this->tail->prev)
            {
                this->tail = this->tail->prev;
                this->tail->next = NULL;
                node->prev = NULL;
            }
            else
            {
                this->head = this->tail = NULL;
            }
        }
        else
        {
            LinkedListNode<T> *prev = node->prev;
            LinkedListNode<T> *next = node->next;
            prev->next = next;
            next->prev = prev;
            node->prev = NULL;
            node->next = NULL;
        }
        delete (node);
        this->count -= 1;
    }

    int getCount()
    {
        return this->count;
    }

    LinkedListNode<T> *getHead()
    {
        return this->head;
    }

    LinkedListNode<T> *getTail()
    {
        return this->tail;
    }
};

struct KeyValuePair
{
    int key;
    int value;

    KeyValuePair(int key = -1, int value = -1)
    {
        this->key = key;
        this->value = value;
    }
};

class LRUCache
{
private:
    int capacity;
    LinkedList<KeyValuePair> *valueList;
    map<int, LinkedListNode<KeyValuePair> *> keyToListNode;

    void moveNodeToLast(LinkedListNode<KeyValuePair> *node);

public:
    LRUCache(int capacity);
    int get(int key);
    void set(int key, int value);
};

LRUCache::LRUCache(int capacity)
{
    this->capacity = capacity;
    this->valueList = new LinkedList<KeyValuePair>();
    this->keyToListNode.clear();
}

void LRUCache::moveNodeToLast(LinkedListNode<KeyValuePair> *node)
{
    KeyValuePair kv = node->value;
    this->valueList->remove(node);
    LinkedListNode<KeyValuePair> *newNode = this->valueList->append(kv);
    this->keyToListNode[kv.key] = newNode;
}

int LRUCache::get(int key)
{
    LinkedListNode<KeyValuePair> *node = this->keyToListNode[key];
    if (node)
    {
        KeyValuePair kv = node->value;
        this->moveNodeToLast(node);
        return kv.value;
    }
    else
    {
        return -1;
    }
}

void LRUCache::set(int key, int value)
{
    LinkedListNode<KeyValuePair> *node = this->keyToListNode[key];
    KeyValuePair newKV = KeyValuePair(key, value);
    if (node)
    {
        node->value = newKV;
        this->moveNodeToLast(node);
    }
    else
    {
        node = this->valueList->append(newKV);
        this->keyToListNode[newKV.key] = node;
    }

    if (this->valueList->getCount() > this->capacity)
    {
        LinkedListNode<KeyValuePair> *node = this->valueList->getHead();
        KeyValuePair kvToRemove = node->value;
        this->keyToListNode[kvToRemove.key] = NULL;
        this->valueList->remove(node);
    }
}

int main(int argc, char const *argv[])
{
    LRUCache *cache = new LRUCache(1);
    cache->set(2, 1);
    cache->set(2, 2);
    cout << cache->get(2) << endl;
    cache->set(1, 1);
    cache->set(4, 1);
    cout << cache->get(2) << endl;
    return 0;
}
