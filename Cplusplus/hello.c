#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node* left;
    struct Node* right;
} Node;

Node* createNode(int value) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    if (!newNode)
    {
        printf("Memory allocation error\n");
        return NULL;
    }
    newNode-> data = value;
    newNode-> left = NULL;
    newNode-> right = NULL;
    return newNode;
    
}
