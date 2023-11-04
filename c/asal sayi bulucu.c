

#include <stdio.h>

void asalbulur(int sayi){
	int i, tutacak=0;
	for (i=2; i<sayi; i++){
		if(sayi%i==0) {
		printf("%d bir asal sayi degildir.\n\n",sayi);
		tutacak=1;
		break;
		}
	}
	if (tutacak==0){
		printf("%d bir asal sayidir.\n\n",sayi);
	}
}

int main()
{
	int kez, i1, sayi;
	printf("Yivi kac kez kullanmak istediginizi giriniz:");
	scanf("%d",&kez);
	printf("\n");
	
	for (i1=1; i1<=kez; i1++){
		printf("Pozitif bir tam sayi giriniz:");
		scanf("%d", &sayi);
		if (sayi==1) {printf("1 bir asal sayi degildir.\n\n"); continue;}
		if (sayi<0 || sayi==0) {printf("Lutfen arti imli sayi giriniz.\n\n"); continue;}
		printf("\n");
		asalbulur(sayi);
	}
	
	
	
	return 0;
}
