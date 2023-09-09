#include <stdio.h>
#include <stdlib.h>
typedef struct node
{
    int data;
    struct node *next;
    struct node *prev;
} Node;
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
    temp->next = temp->prev=NULL;
    temp->data = val;
    if((*head)==NULL)
    {
        (*head)=temp;
        return;
    }
    temp->next=*(head);
    (*head)->prev=temp;
    (*head)=temp;
}
void insertend(Node **head, int val)
{
    Node *temp=(Node *)malloc(sizeof(Node));
    temp->data=val;
    temp->next=temp->prev=NULL;
    if((*head)==NULL)
    {
        (*head)=temp;
        return;
    }
    Node *curr=*head;
    while(curr->next!=NULL)
      curr=curr->next;
    curr->next=temp;
    temp->prev=curr;
}
void insertbeforek(Node **head, int ele, int val)
{
    Node *temp = (Node *)malloc(sizeof(Node));
    temp->data = ele;
    temp->next = NULL;
    temp->prev=NULL;
    if(!(*head))
    {
        (*head)=temp;
        return;
    }
    if((*head)->data==val)
        insertbeg(head,ele);
    Node *curr=*head;
    while(curr!=NULL&&curr->data!=ele)
        curr=curr->next;
    if(curr==NULL)
    {   free(temp);
        printf("Value not found\n");
        return;
    }
    curr->prev=temp;
    temp->next=curr;
    temp->prev=curr->prev;
    curr->prev->next=temp;
}
void insertafterk(Node **head, int ele, int val)
{
    Node *temp = (Node *)malloc(sizeof(Node));
    temp->data = ele;
    temp->next = NULL;
    temp->prev=NULL;
    if ((*head) == NULL)
    {   
        (*head) = temp;
        return;
    }
    if((*head)->data==val)
    {
        (*head)->next=temp;
        temp->prev=(*head);
        return;
    }
    Node *curr=*head;
    while(curr->next!=NULL&&curr->data!=ele)
        curr=curr->next;
    if(curr==NULL)
    {
        free(temp);
        free(curr);
        printf("Value not found\n");
        return;
    }
    temp->next=curr->next;
    curr->next->prev=temp;
    curr->next=temp;
    temp->prev=curr;
}
void deletehead(Node **head)
{
    Node *temp = *head;
    if ((*head) == NULL)
        return;
    (*head) = (*head)->next;
    if((*head)!=NULL)
        (*head)->prev=NULL;
    free(temp);
}
void deletetail(Node **head)
{
    if ((*head) == NULL){
        printf("LinkedList is Empty\n");
        return;
    }
    Node *curr = *head;
    if ((*head)->next == NULL){
        free(*head);
        *(head)=NULL;
        return;
    }
    while (curr->next->next != NULL)
        curr = curr->next;
    Node *temp = curr->next;
    curr->next = curr->next->next;
    free(temp);
}
void deletegiven(Node **head, int val)
{
    Node *curr = *head;
    if ((*head) == NULL)
        return;
    if ((*head)->data == val)
    {
        deletehead(head);
        return;
    }
    while (curr!= NULL && curr->data != val)
        curr = curr->next;
    if(curr==NULL)
    {
        printf("Value not found\n");
        free(curr);
        return;
    }
    if (curr->next == NULL)
    {
        curr->prev->next = NULL;
        free(curr);
        return;
    }
    if(curr->next!=NULL){
    curr->prev->next=curr->next;
    curr->next->prev=curr->prev;
    free(curr);
    }
}
void display(Node *head)
{   
    if(head==NULL)
    {
        printf("LinkedList is Empty\n");
        return;
    }
    struct node *curr = head;
    while (curr != NULL)
    {
        printf("%d ", curr->data);
        curr = curr->next;
    }
    printf("\n");
}