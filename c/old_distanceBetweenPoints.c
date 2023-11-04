

#include <math.h>
#include <stdio.h>


int main()
{
	int kez,i,j;
	float x1,x2,y1,y2;
	printf("Bu yivi kac kez kullanmak istediginizi giriniz:");
	scanf("%d", &kez);
	printf("\n");
	
	for(i=1; i<=kez; i++){
		
		printf("A(x1,y1) kertiginin yerlemlerini sirasiyla giriniz:");
		printf("\n");
		printf("x1=");
		scanf("%f",&x1);
		printf("y1=");
		scanf("%f",&y1);
		printf("\n");
		
		printf("B(x1,y1) kertiginin yerlemlerini sirasiyla giriniz:");
		printf("\n");
		printf("x2=");
		scanf("%f",&x2);
		printf("y2=");
		scanf("%f",&y2);
		printf("\n");
		
		float ara, uzunluk;
		ara = (pow((x1-x2),2)+pow((y1-y2),2));
		uzunluk = pow(ara,0.5);
		
		printf("A(%.2f,%.2f) ile B(%.2f,%.2f) arasindaki uzaklik %f birimdir.", x1, y1, x2, y2, uzunluk);
		printf("\n---------------------------------------------------------\n");
	}
	
	
	return 0;
}
