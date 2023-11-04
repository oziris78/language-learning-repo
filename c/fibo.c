
#include <stdio.h>
#include <math.h>
#include <string.h>
#define k 20

// \n

void fibo(int kez){
	int i,j;
	int tutacak;
	int fibo[kez];
	fibo[0]=1;	
	fibo[1]=1;	
	
	for(i=2; i<kez; i++){
		fibo[i]=fibo[i-1]+fibo[i-2];
	}
	
	printf("%d %d",fibo[0],fibo[1]);
	for(j=2; j<kez; j++){
		printf(" %d",fibo[j]);
	}
}


int main()
{
	fibo(k);

	return 0;
}
