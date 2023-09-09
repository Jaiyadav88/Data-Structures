#include <stdio.h>
#include <stdlib.h>
typedef struct node
{
    int data;
    struct node *next;
    struct node *prev;
} Node; // Circular Doubly LinkedList.
void insertend(Node **, int);
void insertbeg(Node **, int);
void insertbeforek(Node **, int, int);
void insertafterk(Node **, int, int);
void deletehead(Node **);
void deletetail(Node **);
void deletegiven(Node **, int);
void display(Node *);
int main()
{
    int a, ch, b;
    Node *head = NULL;
    do
    {
        printf("1.Insert at the end\n");
        printf("2.Insert at the beginning\n");
        printf("3.Insert before a given node\n");
        printf("4.Insert after a given node\n");
        printf("5.Delete the head of LinkedList\n");
        printf("6.Delete tail of a LinkedList\n");
        printf("7.Delete a node of your choice\n");
        printf("8.To display the linkedlist\n");
        printf("Any Other key to exit\n");
        scanf("%d", &ch);
        switch (ch)
        {
        case 1:
            printf("Enter the value to be inserted\n");
            scanf("%d", &a);
            insertend(&head, a);
            break;

        case 2:
            printf("Enter the value to be inserted at the beginning\n");
            scanf("%d", &a);
            insertbeg(&head, a);
            break;

        case 3:
            printf("Enter the element and the value where element is inserted before value:\n");
            scanf("%d %d", &a, &b);
            insertbeforek(&head, a, b);
            break;

        case 4:
            printf("Enter the element and the value where element is inserted after value:\n");
            scanf("%d %d", &a, &b);
            insertafterk(&head, a, b);
            break;

        case 5:
            deletehead(&head);
            break;

        case 6:
            deletetail(&head);
            break;

        case 7:
            scanf("%d", &a);
            deletegiven(&head, a);
            break;

        case 8:
            display(head);
            break;
        default:
            exit(0);
        }
    } while (ch >= 1 && ch <= 8);
    printf("You have exited the program\n");
    return 0;
}
void insertbeg(Node **head, int val)
{
    Node *temp = (Node *)malloc(sizeof(Node));
    temp->next = temp->prev = temp;
    temp->data = val;
    if ((*head) == NULL)
    {
        (*head) = temp;
        return;
    }
    // insert the node after head
    temp->next = (*head)->next;
    (*head)->next = temp;
    temp->prev = *(head);
    temp->next->prev = temp;

    // copy data of the nodes:O(1)

    int t = (*head)->data;
    (*head)->data = temp->data;
    temp->data = t;
}
void insertend(Node **head, int val)
{
    Node *temp = (Node *)malloc(sizeof(Node));
    temp->data = val;
    temp->next = temp->prev = temp;
    if ((*head) == NULL)
    {
        (*head) = temp;
        return;
    }
    Node *curr = *head;
    while (curr->next != *(head))
        curr = curr->next;
    curr->next = temp;
    temp->prev = curr;
    (*head)->prev = temp;
    temp->next = (*head);
}
void insertbeforek(Node **head, int ele, int val)
{
    Node *temp = (Node *)malloc(sizeof(Node));
    temp->data = ele;
    temp->next = NULL;
    temp->prev = NULL;
    if (!(*head))
    {
        (*head) = temp;
        temp->next = temp;
        temp->prev = temp;
        return;
    }
    if ((*head)->data == val)
    { // if the head is the value
        insertbeg(head, ele);
        return;
    }
    Node *curr = *head;
    while (curr != NULL && curr->data != val)
        curr = curr->next;
    if (curr == NULL)
    {
        free(temp);
        printf("Value not found\n");
        return;
    }
    temp->next = curr;
    temp->prev = curr->prev;
    curr->prev->next = temp;
    curr->prev = temp;
}
void insertafterk(Node **head, int ele, int val)
{
    if (*head == NULL)
    {
        printf("List is empty. Cannot insert.\n");
        return;
    }
    Node *temp = (Node *)malloc(sizeof(Node));
    temp->data = ele;
    temp->next = temp->prev = NULL;
    Node *curr = *head;
    while (curr->next != *head)
    {
        if (curr->data == val)
        {
            temp->prev = curr;
            temp->next = curr->next;
            curr->next->prev = temp;
            curr->next = temp;
            return;
        }
        curr = curr->next;
    }
    if (curr->data == val)
    {
        temp->prev = curr;
        temp->next = curr->next;
        curr->next->prev = temp;
        curr->next = temp;
        return;
    }
    free(temp);
    printf("Value not found\n");
}
void deletehead(Node **head)
{
    struct node *temp = *head;
    if ((*head) == NULL)
        return;
    if ((*head)->next == *head)
    {
        free(temp);
        (*head) = NULL;
        return;
    }
    (*head)->prev->next = (*head)->next;
    (*head)->next->prev = (*head)->prev;
    (*head) = (*head)->next;
    free(temp);
}
void deletetail(Node **head)
{
    if (*head == NULL)
        return;
    if ((*head)->next == *head)
    {
        free(*head);
        *head = NULL;
    }
    Node *t = (*head)->prev;
    Node *sl = t->prev;
    sl->next = *head;
    (*head)->prev = sl;
    free(t);
}
void deletegiven(Node **head, int val)
{
    if (*head == NULL)
    {
        printf("List is empty.Cannot delete.\n");
        return;
    }
    Node *curr = *head;
    do
    {
        if (curr->data == val)
        {
            if (curr == *head)
            {
                *head = curr->next;
            } // if the current node is the node to be deleted.
            curr->prev->next = curr->next;
            curr->next->prev = curr->prev;
            free(curr);
            return;
        }
        curr = curr->next;
    } while (curr != *head);
    printf("Value not found\n"); // value not found.
}

void display(Node *head)
{
    if (head == NULL)
    {
        printf("LinkedList is Empty\n");
        return;
    }
    struct node *curr = head;
    do
    {
        printf("%d ", curr->data);
        curr = curr->next;
    } while (curr != head);
    printf("\n");
}