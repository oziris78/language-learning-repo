#if 1


#include <stdio.h>
#include <stdlib.h>

void myFunction() {
	printf("bbbbbbbbb\n");
}

int main() {
	printf("aaaaaaaaa\n");

	atexit(myFunction);
	printf("ccccccccc\n");
	exit(0);
	printf("ddddddd\n");

	return 0;
}


#endif