#include "../Questions.h"
#include <iostream>
#include <string>

/*

print something like this with an int input:

for input=7

7 7 7 7 7 7 7
7 6 6 6 6 6 7
7 6 5 5 5 6 7
7 6 5 4 5 6 7
7 6 5 5 5 6 7
7 6 6 6 6 6 7
7 7 7 7 7 7 7

for input=6

6 6 6 6 6 6
6 5 5 5 5 6
6 5 4 4 5 6
6 5 4 4 5 6
6 5 5 5 5 6
6 6 6 6 6 6

*/


void solve(int input) {
	if (input > 9) return;
	int arr[9][9];
	int repeatCount = (input % 2 == 0) ? input / 2 : (input / 2) + 1;

	// FILL THE ARRAY
	for (int j = 0; j < repeatCount; j++) {
		for (int i = j; i < input - j; i++) {
			arr[j][i] = input - j;
			arr[input - 1 - j][i] = input - j;
			arr[i][j] = input - j;
			arr[i][input - 1 - j] = input - j;
		}
	}

	// PRINT THE ARRAY
	for (int i = 0; i < input; i++) {
		for (int j = 0; j < input; j++) {
			std::cout << arr[i][j] << " ";
		}
		std::cout << std::endl;
	}

	std::cout << std::endl;
}


void Q1::main() {
	for (int i = 1; i < 10; i++)
		solve(i);
}

