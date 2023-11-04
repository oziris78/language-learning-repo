


#include <stdio.h>
#include <math.h>

int main()
{
	
	int i, j, k;
	float deger1, deger2;
	float basx, basy;
	printf("Baslangic noktanizin (x,y) yerlemlerini sirasiyla giriniz:\nx=");
	scanf("%f", &basx);
	printf("y=");
	scanf("%f", &basy);
	printf("\n");
	
	printf("Kac tane nokta gireceginizi giriniz:\nKez=");
	int kez;
	scanf("%d",&kez);
	printf("\n");
	
	float X[kez];
	float Y[kez];
	
	for(i=0; i<kez; i++){
		printf("%d. noktanin yerlemlerini (x,y) giriniz:\nx_%d=",i,i);
		scanf("%f", &X[i]);
		printf("y_%d=",i);
		scanf("%f", &Y[i]);
		printf("\n");
	}
	
	float Uzun[kez];
	
	for(j=0; j<kez; j++){
		Uzun[j]= pow((pow((X[j]-basx),2)+pow((Y[j]-basy),2)),0.5);
	}
	
	int sayi;
	float enk=999999999999999999;
	
	
	for(k=0; k<kez; k++){
		if (Uzun[k]<enk) {
			enk=Uzun[k];
			sayi=k;
		}
	}
	
	printf("Ana noktaniz = (%.2f,%.2f)\n", basx,basy);
	printf("Ana noktaniza en yakin nokta = (%.2f,%.2f)\n", X[sayi], Y[sayi]);
	printf("En yakin noktanin siralamasi = %d\n", sayi);
	printf("Ana noktaniz ile en yakin nokta arasi uzunluk = %.2f\n", enk);

	return 0;
}
