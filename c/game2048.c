

#include <stdio.h>
#include <time.h>
#include <stdlib.h>

#define HACK_ITERATIONS 100
#define GAME_GOAL 2048*8


void process_move(int*** board_ptr, int w, int h, int dx, int dy);
void print_board(int** board, int w, int h);
int get_board_max_cell(int** board, int w, int h);
int** create_board(int w, int h);
	
	
int main() {
	srand(time(NULL));
	
	int w, h;
	printf("Enter the dimension of the whole board:\n");
	printf("Width: "); scanf("%d", &w);
	printf("Height: "); scanf("%d", &h);
	
	int** board = create_board(w, h);
	print_board(board, w, h);

	char c;
	while(get_board_max_cell(board, w, h) != GAME_GOAL) {
		fflush(stdin);
		printf("Enter move (ASDW): "); scanf("%c", &c);
		if(c == 'a') {
			process_move(&board, w, h, -1, 0);
		}
		else if(c == 's') {
			process_move(&board, w, h, 0, 1);
		}
		else if(c == 'd') {
			process_move(&board, w, h, 1, 0);
		}
		else if(c == 'w') {
			process_move(&board, w, h, 0, -1);
		}
		else if(c == 'h') {
			int i;
			for(i = 0; i < HACK_ITERATIONS; i++) {
				process_move(&board, w, h, -1, 0);
				process_move(&board, w, h, 0, 1);
				process_move(&board, w, h, 1, 0);
				process_move(&board, w, h, 0, -1);
			}
		}
		else {
			printf("Invalid input, write ASDW.\n\n");
			continue;
		}
		print_board(board, w, h);
	}
	printf("\n\n\n---------------------------------------------\n");
	printf("YOU HAVE WON THE GAME!");
	printf("\n---------------------------------------------\n\n\n");
	
	return 0;
}




int** create_board(int w, int h) {
	int i, j;
	int** board = (int**) malloc(h * sizeof(int*));
	for(i = 0; i < h; i++) {
		board[i] = (int*) malloc(w * sizeof(int));
	}

	for(i = 0; i < h; i++) {
		for(j = 0; j < w; j++) {
			
			int x = rand();
			if(x % 6 == 0 || x % 6 == 1 || x % 6 == 2)
				board[i][j] = 0;
			else if(x % 6 == 3 || x % 6 == 4)
				board[i][j] = 2;
			else if(x % 6 == 5)
				board[i][j] = 4;
		}
	}

	return board;		
}

int get_board_max_cell(int** board, int w, int h) {
	int i, j;
	int max = 0;

	for(i = 0; i < h; i++) {
		for(j = 0; j < w; j++) {
			if(board[i][j] > max) {
				max = board[i][j];
			}
		}
	}
	
	return max;
}


void print_board(int** board, int w, int h) {
	int i, j;
	for(i = 0; i < h; i++) {
		for(j = 0; j < w; j++) {
			printf("%5d ", board[i][j]);
		}
		printf("\n");
	}
}


void process_move(int*** board_ptr, int w, int h, int dx, int dy) {
    int i, j, k;
    int** board = *board_ptr;
    
    if(dx == -1) { // move left
        for(i = 0; i < h; i++) {
            for(j = 0; j < w; j++) {
                if(board[i][j] != 0) {
                    for(k = j+dx; k >= 0; k--) {
                        if(board[i][k] == 0) {
                            board[i][k] = board[i][k-dx];
                            board[i][k-dx] = 0;
                        } else if(board[i][k] == board[i][k-dx]) {
                            board[i][k] *= 2;
                            board[i][k-dx] = 0;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    } 
	else if(dx == 1) { // move right
        for(i = 0; i < h; i++) {
            for(j = w-1; j >= 0; j--) {
                if(board[i][j] != 0) {
                    for(k = j+dx; k < w; k++) {
                        if(board[i][k] == 0) {
                            board[i][k] = board[i][k-dx];
                            board[i][k-dx] = 0;
                        } else if(board[i][k] == board[i][k-dx]) {
                            board[i][k] *= 2;
                            board[i][k-dx] = 0;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    } 
	else if(dy == -1) { // move up
        for(j = 0; j < w; j++) {
            for(i = 0; i < h; i++) {
                if(board[i][j] != 0) {
                    for(k = i+dy; k >= 0; k--) {
                        if(board[k][j] == 0) {
                            board[k][j] = board[k-dy][j];
                            board[k-dy][j] = 0;
                        } else if(board[k][j] == board[k-dy][j]) {
                            board[k][j] *= 2;
                            board[k-dy][j] = 0;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    } 
	else if(dy == 1) { // move down
        for(j = 0; j < w; j++) {
            for(i = h-1; i >= 0; i--) {
                if(board[i][j] != 0) {
                    for(k = i+dy; k < h; k++) {
                        if(board[k][j] == 0) {
                            board[k][j] = board[k-dy][j];
                            board[k-dy][j] = 0;
                        } else if(board[k][j] == board[k-dy][j]) {
                            board[k][j] *= 2;
                            board[k-dy][j] = 0;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }
    
    int empty_cells = 0;

    for(i = 0; i < h; i++) {
        for(j = 0; j < w; j++) {
            if(board[i][j] == 0) {
                empty_cells++;
            }
        }
    }

    if(empty_cells == 0) return;    

    int rand_cell = rand() % empty_cells;
    int current_cell = 0;

    for(i = 0; i < h; i++) {
        for(j = 0; j < w; j++) {
            if(board[i][j] == 0) {
                if(current_cell == rand_cell) {
                    board[i][j] = (rand() % 2 + 1) * 2;
                    return;
                }
                current_cell++;
            }
        }
    }
}



