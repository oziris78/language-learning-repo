
#include <stdio.h>
#include <math.h>
#include <string.h>

int main()
{
	int N;
	int h1,h2,h3,h4;
	printf("Gireceginiz kare matrislerin boyutunu giriniz:\nN=");
	scanf("%d",&N);
	int A[N][N], B[N][N], C[N][N];
	
	for(h1=0; h1<N; h1++){
		printf("Ilk matrisin %d. satirini sirayla giriniz:",h1+1);
		for(h2=0; h2<N; h2++){
			scanf("%d",&A[h1][h2]);
		}
		printf("\n");
	}
	
		for(h1=0; h1<N; h1++){
		printf("Ikinci matrisin %d. satirini sirayla giriniz:",h1+1);
		for(h2=0; h2<N; h2++){
			scanf("%d",&B[h1][h2]);
		}
		printf("\n");
	}
	
	int i, j, m, toplam=0;
	
	for(i=0; i<N; i++){
		for(j=0; j<N; j++){
			for(m=0; m<N; m++){
				toplam=toplam+A[i][m]*B[m][j];
			}
			C[i][j]=toplam;
			toplam=0;
		}
	}
	
	printf("A matrisi:\n");
	for(i=0; i<N; i++){
		printf("|");
		for(j=0; j<N; j++){
			if(j==N-1) printf("%d",A[i][j]);
			else printf("%d  ",A[i][j]);
		}
		printf("|");
		printf("\n");
	}
	
		printf("\n");
	
	printf("B matrisi:\n");
	for(i=0; i<N; i++){
		printf("|");
		for(j=0; j<N; j++){
			if(j==N-1) printf("%d",B[i][j]);
			else printf("%d  ",B[i][j]);
		}
		printf("|");
		printf("\n");
	}
	
		printf("\n");
	
	printf("Matrislerin carpimi:\n");
	for(i=0; i<N; i++){
		printf("|");
		for(j=0; j<N; j++){
			if(j==N-1) printf("%d",C[i][j]);
			else printf("%d  ",C[i][j]);
		}
		printf("|");
		printf("\n");
	}
	
	return 0;
}
