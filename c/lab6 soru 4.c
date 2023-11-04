

#include <stdio.h>
#include <math.h>

void cember(float a, float b) {
	
	if (pow(a-1,2)+pow(b-2,2)==1) {
		printf("Noktaniz cemberin uzerindedir.");
	}
	
	if (pow(a-1,2)+pow(b-2,2)<1) {
		printf("Noktaniz cemberin icindedir.");
	}
	
	if (pow(a-1,2)+pow(b-2,2)>1) {
		printf("Noktaniz cemberin disindadir.");
	}
}


int main()
{
	
	float x,y;
	printf("P(x,y) noktanizin yerlemlerini sirasiyla giriniz:");
	scanf("%f%f",&x,&y);
	cember(x,y);
	
	return 0;
}
