#include "../Questions.h"
#include <iostream>
#include <string>


void reverse_string(char* str) {
	size_t len = std::strlen(str);
	for (int i = 0; i < len / 2; i++)
		std::swap(str[i], str[len - i - 1]);
}



void Q3::main() {
	const int SIZE = 50;
	char str[SIZE];
	std::cin.getline(str, SIZE);
	reverse_string(str);
	std::cout << str << std::endl;
}



