#include<stdio.h>
#include<stdlib.h>

struct node{
    char data;
    struct node *_left, *_right;  
}; 

void preorder(struct node* curr);
void postorder(struct node *curr);
void inorder(struct node *curr);
struct node* newNode(char data);
struct node* buildTree(char arr[], int length);

int main() {
    char arr[]= {'+','6','4'};
    struct node * root = buildTree(arr,3); 

    printf("preorder:\n");
    preorder(root); 
    printf("\npostorder:\n");
    postorder(root);
    printf("\ninorder:\n");
    inorder(root);  
}

struct node * buildTree(char arr[], int length) {
    struct node * root = newNode(arr[0]);
    int i = 0;
    root->_left = newNode(arr[i+1]);
    root->_right = newNode(arr[i+2]); 
    
    return (root);
}

struct node * newNode(char data) {
    struct node * node = (struct node *) malloc(sizeof(struct node));
    node->data = data;
    node->_left = NULL;
    node->_right = NULL;
    return node;
}

void preorder(struct node *curr) {
    if (curr) {
        printf("%c ", curr->data);
        preorder(curr->_left); 
        preorder(curr->_right);
    }
}

void inorder(struct node *curr) {
    if (curr)  {
        inorder(curr->_left);
        printf("%c ",curr->data);
        inorder(curr->_right);
    }
}

void postorder(struct node *curr) {
    if (curr) {
        postorder(curr->_left);
        postorder(curr->_right);
        printf("%c ",curr->data);
    } 
}
