#include "../Questions.h"
#include <iostream>
#include <string>

// Pointers


// a' = a + b
// b' = abs(b - a)
void f(int* a, int* b) {
	*a += *b;
	*b = 2 * *b - *a;
	if (*b < 0)
		*b *= -1;
}


void Q5::main() {
	int a = 2; // => 0
	int b = -2; // => 4

	std::cout << "a: " << a << " b: " << b << std::endl;
	f(&a, &b);
	std::cout << "a: " << a << " b: " << b << std::endl;
}







