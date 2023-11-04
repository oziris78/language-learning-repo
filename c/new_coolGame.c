

#include <stdio.h>
#include <stdbool.h>


bool hasWon(int g[10]){
	int i;
	for(i = 0; i < 10; i++)
		if(g[i] == 0)
			return false;
	return true;
}

void printCurrentPosition(int g[10]){
	int i;
	printf("Current position:\n");
	printf("\t1 2 3 4 5 6 7 8 9 10\n");
	printf("\t");
	for(i = 0; i < 10; i++)
		printf("%d ", g[i]);
	printf("\n\n");
}


int main() {
	int i, numOfMoves;
	int game[10] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	
	while(true){
		printCurrentPosition(game);
		printf("Enter an index to change:");
		scanf("%d", &i);
		printf("\n\n");
		
		if(i<1 || i>10) // if invalid then continue
			continue;

		numOfMoves++;

		game[(i+10-2) % 10]++;
		game[(i+10-2) % 10] %= 2;
		
		game[(i+10-1) % 10]++;
		game[(i+10-1) % 10] %= 2;
		
		game[(i+10-0) % 10]++;
		game[(i+10-0) % 10] %= 2;
		
		if(hasWon(game)) {
			printf("\n\n\t1 1 1 1 1 1 1 1 1 1\n\nYOU HAVE WON!\n\nTotal number of moves=%d\n\n",numOfMoves);
			return 0;
		}
	}
}
