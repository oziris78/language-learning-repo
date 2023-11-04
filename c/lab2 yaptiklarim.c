

#include <stdio.h>
#include <math.h>

int main()
{
	
	// lab 2, fonksiyon sorusu a //
	
	
	float x;
	printf("f(x) gondermesine girmek istediginiz x degerini giriniz:");
	scanf("%f", &x);
	
	if (x<=0) {
	printf("f(%f)=0", x);
	}
	
	if (x>0 && x<=8) {
		float y_1;
		y_1=2/(pow((pow(x,5)+4),0.5));
		printf("f(%f)=%.3f", x,y_1);
	}
	
	if (x>8) {
		float y_2;
		y_2=sin(x)+pow(x,3);
		printf("f(%f)=%.3f", x,y_2);
	}
	
	
	printf("\n\n");
	
	// lab 2, fonksiyon sorusu b //
	
	
	float a,b,c;
	printf("f(a) gondermesine girmek istediginiz a degerini giriniz:");
	scanf("%f", &a);
	b=2/(pow((pow(a,5)+4),0.5));
	c=sin(a)+pow(a,3);
	
	if (x<=8) {
		if (x<=8 && x>0) printf("f(%f)=%.3f",a,b);
		else printf("f(%f)=0");
	}
	else printf("f(%f)=%.3f",a,c);
	
	
	
	
	
	
	return 0;
}
