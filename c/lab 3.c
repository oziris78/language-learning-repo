

#include <stdio.h>

int main()
{
	
	int s,k,t,yildiz,giris,sayi,bosluk;
	printf("Giris:");
	scanf("%d", &giris);
	yildiz=1;
	bosluk=giris-1;
	
		
	for (k=0; k<giris; k++) {
		
		for(t=0; t<bosluk; t++) 
			printf(" ");
		for(s=0; s<yildiz; s++) {
			printf("*");
		}
			printf("\n");
			yildiz++;
			bosluk--;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	return 0;
}
