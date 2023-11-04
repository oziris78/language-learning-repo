#include "../Questions.h"
#include <iostream>
#include <vector>


/*
84. Write a C++ program to check whether the sequence of the numbers in a 
given array is a "Arithmetic" or "Geometric" sequence. Return -1 if the sequenc 
is not "Arithmetic" or "Geometric". Go to the editor
From Wikipedia
In mathematics, an arithmetic progression (AP) or arithmetic sequence is a 
sequence of numbers such that the difference between the consecutive terms 
is constant. Difference here means the second minus the first. For instance, 
the sequence 5, 7, 9, 11, 13, 15, . . . is an arithmetic progression with 
common difference of 2.
In mathematics, a geometric progression, also known as a geometric sequence, 
is a sequence of numbers where each term after the first is found by multiplying 
the previous one by a fixed, non-zero number called the common ratio. For example,
the sequence 2, 6, 18, 54, ... is a geometric progression with common ratio 3. 
Similarly 10, 5, 2.5, 1.25, ... is a geometric sequence with common ratio 1/2.
Example:
Sample Input: int nums1[] = { 1, 3, 5, 7 }
Sample Output: Arithmetic sequence
Click me to see the sample solution
*/



static std::vector<int> vec = std::vector<int>();



bool is_geometric_or_arithmetic(std::vector<int>& vector) {
	bool is_arithmetic = true, is_geometric = true;
	const size_t len_of_vec = vector.size();

	// check for arithmetic
	const int diff = vector.at(1) - vector.at(0);
	for (size_t i = 0; i < len_of_vec; i++) {
		if (i != len_of_vec - 1) {
			if (vector.at(i + 1) - vector.at(i) != diff) {
				is_arithmetic = false;
				break;
			}
		}
	}

	// check for geometric
	const double ratio = (double) vector.at(1) / (double) vector.at(0);
	for (size_t i = 0; i < len_of_vec; i++) {
		if (i != len_of_vec - 1) {
			if ((double) vector.at(i + 1) / (double) vector.at(i) != ratio) {
				is_geometric = false;
				break;
			}
		}
	}

	return is_arithmetic || is_geometric;
}



template<typename ...T>
void try_sequence(T... args) {
	(vec.push_back(args), ...); // c++ 17 "fold"

	std::cout << is_geometric_or_arithmetic(vec) << std::endl;
	vec.clear();
}





void Q6::main() {
	try_sequence(10, 20, 30);           // 1, arith
	try_sequence(10, 20, 30, 40, 50);   // 1, arith
	try_sequence(10, 20, 40, 80);       // 1, geo
	try_sequence(2, 4, 8, 16, 32);      // 1, geo
	try_sequence(1, 1, 1, 1, 1);        // 1, arith
	try_sequence(10, 20, 30, 45, 50);   // 0
}



