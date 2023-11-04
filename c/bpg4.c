

#include <stdio.h>

int main()
{
	
	
	
	// istedigim kadar sayiyi dizi ile yazdirma (ogrenme amacli kisisel)
	
	
	int n;
	printf("Kaca tek yazilmasini istiyorsaniz giriniz:");
	scanf("%d",&n);
	int dizi[n];
	int i=0,j=0;
	float k;
	
	
	while(j<=n-1) {
		printf("dizi[%d] elemanini giriniz:",j);
		scanf("%f", &k);
		dizi[j]=k;
		j++;	
	}
	
	while(i<=n-1) {
		printf("%d  ", dizi[i]);
		i++;
	}
	
	
	//ortalama buldurma: (nedense tam calismiyor?)
	
	int h=0;
	float sayiadedi, toplam=0, ortalama;
	while(h<=n-1) {
		
		toplam=toplam+dizi[h];
		
		sayiadedi++;
		h++;
	}
	
	ortalama=(toplam)/(sayiadedi);
	printf("\n");
	printf("Dizideki terimlerin ortalamasi %d dir.", ortalama);
	
	
	
	// 3x3 matris toplamasi:
	int a[3][3], b[3][3];
	int i1=0,i2=0,i3=0,i4=0,i5=0,i6=0, c;
	
	
	printf("A matrisini soldan saga ve yukaridan asagiya dogru teker teker giriniz:\n");
	while(i1<3) {
		printf("Deger giriniz:");
		scanf("%d", &c);
		printf("\n");
		a[0][i1]=c;
		i1++;
	}
	
	while(i2<3) {
		printf("Deger giriniz:");
		scanf("%d", &c);
		printf("\n");
		a[1][i2]=c;
		i2++;
	}
	
	while(i3<3) {
		printf("Deger giriniz:");
		scanf("%d", &c);
		printf("\n");
		a[2][i3]=c;
		i3++;
	}
	
	
	
	printf("B matrisini soldan saga ve yukaridan asagiya dogru teker teker giriniz:\n");
	while(i4<3) {
		printf("Deger giriniz:");
		scanf("%d", &c);
		printf("\n");
		b[0][i4]=c;
		i4++;
	}
	
	while(i5<3) {
		printf("Deger giriniz:");
		scanf("%d", &c);
		printf("\n");
		b[1][i5]=c;
		i5++;
	}
	
	while(i6<3) {
		printf("Deger giriniz:");
		scanf("%d", &c);
		printf("\n");
		b[2][i6]=c;
		i6++;
	}
	
	printf("\n");
	printf("%4d %4d %4d     %4d %4d %4d     %4d %4d %4d\n",a[0][0],a[0][1],a[0][2],b[0][0],b[0][1],b[0][2],a[0][0]+b[0][0],a[0][1]+b[0][1],a[0][2]+b[0][2]);
	printf("%4d %4d %4d  +  %4d %4d %4d  =  %4d %4d %4d\n",a[1][0],a[1][1],a[1][2],b[1][0],b[1][1],b[1][2],a[1][0]+b[1][0],a[1][1]+b[1][1],a[1][2]+b[1][2]);
	printf("%4d %4d %4d     %4d %4d %4d     %4d %4d %4d\n",a[2][0],a[2][1],a[2][2],b[2][0],b[2][1],b[2][2],a[2][0]+b[2][0],a[2][1]+b[2][1],a[2][2]+b[2][2]);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	return 0;
}
