

#include <stdio.h>
#include <math.h>
#include <string.h>

// \n


int main()
{
	
	
	
	
	int sayi=641;
	int *s = &sayi;
	
	char harf='t';
	char *h = &harf;
	
	
	printf("Sayiniz=%d\nAdresi:%x\n",sayi,s);
	printf("Harfiniz=%c\nAdresi:%x\n",harf,h);
	

	int rakam=6;
	int *r = &rakam;
	r++; //duzgun sayi gelsin diye yaptim, amaci yok
	//62fe00 verildi
	printf("Sayiniz=%d\nAdresi:%x\n",rakam,r);
	//62fe00 'yi 4 (int degerince) arttirmak
	r++;
	printf("Sayiniz=%d\nAdresi:%x\n",rakam,r);
	//62fe04 verildi
	r=r+2; //62fe04 + 8 isteniyor
	//62fe0c gelir
	printf("Sayiniz=%d\nAdresi:%x\n",rakam,r);
	//geldi
	

	
	
	
	int sayiaa=60;
	int *saa = &sayiaa;
	
	
	printf("%x\n\n%d",saa,*saa);
	
	
	
	
	return 0;
}
