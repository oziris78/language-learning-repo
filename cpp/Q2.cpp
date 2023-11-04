#include "../Questions.h"
#include <iostream>
#include <string>


/*

ABBBBBBC
B      B
B      B
B      B
CBBBBBBA

fark ettiklerim:
ilk satırı yazdırırken kaydedersem tersine çevirip en sona koyabilirim
ilk ve son satır dışındakiler (height-2 satır) yalnızca başına B, ortaya (width-2) kez boşluk ve sonuna B konmuş bir str

*/



void rush(int width, int height) {
	char rows[100][100];
	// DOLDURMA
	for (int row = 0; row < height; row++) { // satırları yazdırıyorum
		if (row == 0) { // ilk satır özel
			rows[row][0] = 'A'; // ilk olan A
			for (int temp = 1; temp < width - 1; temp++) // aradakiler B
				rows[row][temp] = 'B';
			rows[row][width - 1] = 'C'; // son olan C
			rows[row][width] = '\0';
		}
		else if (row == height - 1) { // son satır özel
			rows[row][0] = 'C'; // ilk olan C
			for (int temp = 1; temp < width - 1; temp++) // aradakiler B
				rows[row][temp] = 'B';
			rows[row][width - 1] = 'A'; // son olan A
			rows[row][width] = '\0';
		}
		else { // gerisi ortadaki satırlar
			rows[row][0] = 'B'; // ilk olan B
			for (int temp = 1; temp < width - 1; temp++) // aradakiler boşluk
				rows[row][temp] = ' ';
			rows[row][width - 1] = 'B'; // son olan B
			rows[row][width] = '\0';
		}
	}

	// YAZDIRMA
	for (int i = 0; i < width; i++) {
		for (int j = 0; j < height; j++) {
			printf("%c", rows[i][j]);
		}
		printf("\n");
	}
}


void Q2::main() {
	rush(3, 3);
}

