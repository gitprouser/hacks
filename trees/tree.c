#include<stdio.h>
#include<stdlib.h>

struct node{
    int data;
    struct node *_left, *_right;  
}; 

void preorder(struct node* curr);
void postorder(struct node *curr);
void inorder(struct node *curr);
struct node* newNode(int data);
struct node* buildTree(int arr[], int length);

int main() {
    int arr[]= {10, 3, 4, 5, 8, 1923, 12, 45};
    struct node * root = buildTree(arr,8); 

    printf("preorder:\n");
    preorder(root); 
    printf("\npostorder:\n");
    postorder(root);
    printf("\ninorder:\n");
    inorder(root);  
}

struct node * buildTree(int arr[], int length) {
    struct node * root = newNode(arr[0]);
    int i = 0;
    while (i < length - 1) {
        root->_left = newNode(arr[i++]);
        root->_right = newNode(arr[i++]); 
    }
    return (root);
}

struct node * newNode(int data) {
    struct node * node = (struct node *) malloc(sizeof(struct node));
    node->data = data;
    node->_left = NULL;
    node->_right = NULL;
    return node;
}

void preorder(struct node *curr) {
    if (curr) {
        printf("%d ", curr->data);
        preorder(curr->_left); 
        preorder(curr->_right);
    }
}

void inorder(struct node *curr) {
    if (curr)  {
        inorder(curr->_left);
        printf("%d ",curr->data);
        inorder(curr->_right);
    }
}

void postorder(struct node *curr) {
    if (curr) {
        postorder(curr->_left);
        postorder(curr->_right);
        printf("%d ",curr->data);
    } 
}
