

#include <stdio.h>
#include <math.h>
#include <string.h>

// \n


int main()
{
	
	int uzunluk=0;
	int i;
	char ad[10];
	printf("Adi girin:");
	gets(ad);
	
	for(i=0; i<20; i++){
		if(ad[i]!='\0'){
			uzunluk++;
		}
		else continue;
	}
	
	printf("fonksiyon ile %d geliyor.\n",strlen(ad));
	printf("elle %d geliyor",uzunluk-1);
	
	
	
	
	
	return 0;
}
