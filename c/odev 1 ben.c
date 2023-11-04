
#include <stdio.h>


void Numeric2Char(char A[], int numeric){
	int m, d=10000000, i;
	printf("Donusturmek istediginiz 8 basamakli sayiyi giriniz:");
	scanf("%d",&numeric);
	for (i=0; i<8; i++){
		m= numeric/d;
		A[i]=m+'0';
		numeric = numeric - m*d;
		d=d/10;
	}
}

int Char2Numeric(char A[]){
	int numeric=0, i, m, n, d=10000000;
	for (i=0; i<8; i++){
		n = A[i] - '0';
		m=n*d;
		numeric= numeric+m;
		d=d/10;
	}
	return (numeric);
	
}


int main()
{
	char A[9];
	int secim, numeric;
	printf("Menu:\n1. Sayidan yaziya donusturme\n2. Yazidan sayiya donusturme\nLutfen birini seciniz:");
	scanf("%d",&secim);
	
	if (secim!=1 && secim!=2) {printf("Yanlis secim, program kapatiliyor."); return 0;}
	if (secim==1) {
		A[8]='\0';
		Numeric2Char(A,numeric);
		printf("Char= %s", A);
		return 0;
	}
	if (secim==2) {
		printf("Donusturmek istediginiz 8 haneli yaziyi giriniz:");
		scanf("%s", A);
		int basmalik;
		basmalik=Char2Numeric(A);
		printf("Sayi gosteriminiz: %d", basmalik);
		return 0;
	}
	
	return 0;
}
