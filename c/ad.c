

#include <stdio.h>
#include <math.h>
#include <string.h>

// \n


void tanitici(char ad[20], char soyad[20], char yas[3]){
	
	printf("Merhaba, ben %s %s. %s yasindayim, tanistigima memnun oldum.",ad,soyad,yas);
}


int main()
{
	
	char ad[20];
	char soyad[20];
	char yas[3];
	
	printf("Adinizi giriniz=");
	gets(ad);
	printf("Soyadinizi giriniz=");
	gets(soyad);
	printf("Yasinizi giriniz=");
	gets(yas);
	
	tanitici(ad,soyad,yas);
	
	
	return 0;
}
