#if 0

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {
	int a = 1;
	int b = 2;
	int c = 3;

	printf("a address: %p\n", &a);
	printf("b address: %p\n", &b);
	printf("c address: %p\n", &c);

	int* pa = (int*) malloc(sizeof(int));
	int* pb = (int*) malloc(sizeof(int));
	int* pc = (int*) malloc(sizeof(int));
	if (!pa || !pb || !pc)
		return -1;
	*pa = 10;
	*pb = 20;
	*pc = 30;

	printf("-------------------\n");
	printf("a address: %p\n", pa);
	printf("b address: %p\n", pb);
	printf("c address: %p\n", pc);

	return 0;
}

#endif