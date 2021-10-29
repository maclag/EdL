#include <stdio.h>
#include <stdlib.h>

// Lista encadeada - [1, 2, 3, 4]

typedef struct Node {
    int x;
    struct Node* next;
} Node;

int main () {
    Node root;

    // [1]
    root.x = 1;
    root.next = malloc(sizeof(Node));

    // [1, 2]
    root.next->x = 2;
    root.next->next = malloc(sizeof(Node));

    // [1, 2, 3]
    root.next->next->x = 3;
    root.next->next->next = malloc(sizeof(Node));

    // [1, 2, 3, 4]
    root.next->next->next->x = 4;
    root.next->next->next->next = NULL;

    printf("First: %d\n", root.x);
    printf("Second: %d\n", root.next->x);
    printf("Third: %d\n", root.next->next->x);
    printf("Fourth: %d\n", root.next->next->next->x);

    free(root.next);
    free(root.next->next);
    free(root.next->next->next);

    return 0;
}
