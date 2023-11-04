

#include <stdio.h>
#include <math.h>
#include <string.h>

// \n


int boltop(int a){
	int i, j, toplam=0;
	for(i=1; i<a; i++){
		if(a%i==0) {
			toplam=toplam+i;
		}
	}
	return(toplam);
}

int main()
{
		int sayi, kez, i;
		printf("Muhtesem sayi bulucuya hosgeldiniz.\n");
		printf("Yivi kac kez kullanacaksiniz:");
		scanf("%d",&kez);
		
		for(i=1; i<=kez; i++){
		printf("\n\nSayi giriniz:");
		scanf("%d",&sayi);
		if(boltop(sayi)==sayi){
			printf("\n%d sayisi bir muhtesem sayidir.",sayi);
		}
		else printf("\n%d sayisi muhtesem sayi DEGILDIR.",sayi);
		}
	
	
	return 0;
}
