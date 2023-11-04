
#include <stdio.h>
#include <math.h>
#include <string.h>


void getMatrixFromUser(int N, int mat[N][N], int matNum){
	int i, j;
	for(i = 0; i < N; i++){
		for(j = 0; j < N; j++){
			printf("mat%d[%d][%d]: ", matNum, i+1, j+1);
			scanf("%d", &mat[i][j]);
			printf("\n");
		}
	}
	printf("\n");
}

void printMatrix(int N, int mat[N][N]){
	int i, j;
	printf("\n");
	for(i = 0; i < N; i++){
		for(j = 0; j < N; j++){
			printf("%6d", mat[i][j]);	
		}
		printf("\n");
	}
	printf("\n");
}

void multiplyMatrices(int N, int A[N][N], int B[N][N], int C[N][N]){
	int i, j, k;
	int sum;
	for(i = 0; i < N; i++){
		for(j = 0; j < N; j++){
			sum = 0;
			for(k=0; k < N; k++)
				sum += A[i][k] * B[k][j];
			C[i][j] = sum;
		}
	}
}

int main() {
	int N;
	printf("Enter dimension of your square matrices: \nN = ");
	scanf("%d", &N);
	int A[N][N], B[N][N], C[N][N];
	
	getMatrixFromUser(N, A, 1);
	getMatrixFromUser(N, B, 2);
	
	multiplyMatrices(N, A, B, C);
	
	printf("A:\n");
	printMatrix(N, A);
	
	printf("B:\n");
	printMatrix(N, B);

	printf("A*B:\n");
	printMatrix(N, C);
	
	return 0;
}
