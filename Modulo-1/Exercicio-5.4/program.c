#include <stdio.h>
#include <stdlib.h>

int main() {
    int n, sum = 0;
    printf("Enter number of elements: ");
    scanf("%d", &n);

    // Dynamically allocated array
    int *pointer = (int*) malloc(n * sizeof(int));

    // In case memory cannot be allocated
    if (pointer == NULL) {
        printf("Error! Memory not allocated.");
        exit(0);
    }

    for (int i = 0; i < n; ++i) {
        printf("Enter element[%d]: ", i);
        scanf("%d", pointer + i);
        sum += *(pointer + i);
    }
    
    printf("Sum = %d", sum);
    
    free(pointer);
    return 0;
}

