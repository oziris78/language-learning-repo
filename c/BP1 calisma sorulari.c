

#include <stdio.h>
#define h(x) 5*x*x+2

int main()
{

//BP1 CALISMA//
//Soru1: 5x2+2 fonksiyonun x=4.8 noktasýndaki deðerini hesaplayýnýz.//	

float a;
printf("5*x*x+2 fonksiyonuna vermek istediginiz x degerini giriniz:");
scanf("%f", &a);
a=h(a);
printf("Girdiginiz x degeri icin ciktiniz:%.3f", a);
printf("\n \n");

//Soru 2: Yarýçapý 7 olan olan bir dairenin alanýný ve çevresini hesaplayýnýz//

	float pi;
	pi=3.141592;
	float yaricap1, yaricap2;
	printf("Alanini bulmak istediginiz dairenin ve cevresini bulmak istediginiz cemberin yaricaplarini sirasiyla giriniz:");
	scanf("%f %f", &yaricap1, &yaricap2);
	float alan1, cevre1;
	alan1=pi*yaricap1*yaricap1;
	cevre1=2*pi*yaricap2;
	printf("\n\n");
	printf("Dairenizin alani=%.8f, Cemberinizi cevresi=%.8f", alan1, cevre1);
	printf("\n\n");
	
	
	
	
	
	
	
	return 0;
}

