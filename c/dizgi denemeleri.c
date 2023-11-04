


#include <stdio.h>
#include <math.h>
#include <string.h>
#include <ctype.h>

int main()
{

	char dzg1[10];
	char dzg2[10]; 
	printf("Bir dizgi giriniz:");
	gets(dzg1);
	printf("Ikinci bir dizgi giriniz:");
	gets(dzg2);
	
	printf("\ndizgi 1:");
	puts(dzg1);
	printf("\ndizgi 2:");
	puts(dzg2);
	
	printf("\ndizgi 1 uzunlugu=%d\ndizgi 2 uzunlugu=%d\n", strlen(dzg1),strlen(dzg2));
	printf("dizgilerin toplam uzunlugu=%d\n", strlen(dzg1)+strlen(dzg2));

	if(strcmp(dzg2,dzg1)!=0){
		if(strcmp(dzg2,dzg1)>0) printf("1. dizgi 2. dizgiden degerce uzundur.");
		else printf("2. dizgi 1. dizgiden degerce uzundur.");
	}
	else printf("iki dizgi de degerce esit uzunluktadir.");
	
	printf("\n");

	if(strstr(dzg2,dzg1)==0) printf("1. dizgi 2. dizginin icinde YOK.");
	else printf("1. dizgi 2. dizginin icinde VAR.");

	
	printf("\n");
	
	strcat(dzg2,dzg1); 
	printf("%s",dzg2);





	
	return 0;
}
