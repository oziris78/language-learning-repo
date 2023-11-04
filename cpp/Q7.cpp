#include "../Questions.h"
#include <iostream>
#include <string>
#include <sstream>
#include <algorithm>
#include <iterator>


/*

  *
 ***
  *

1 1 1
0 3 0
1 1 1

  * 
 ***
*****
 ***
  *

2 1 2
1 3 1
0 5 0
1 3 1
2 1 2
	 
*/


void print_step(int max_len, int i) {
	const int space_len = max_len - i;
	std::string space_on_each_side = std::string(space_len / 2, ' ');
	std::string stars_in_the_middle = std::string(i, '*');
	std::cout << space_on_each_side << stars_in_the_middle << space_on_each_side << std::endl;
}

void Q7::main() {

	// needs to be odd
	const int max_len = 17;

	// UPPER
	for (int i = 1; i <= max_len; i += 2) {
		print_step(max_len, i);
	}

	// LOWER
	for (int i = max_len - 2; i >= 1; i -= 2) {
		print_step(max_len, i);
	}

}

