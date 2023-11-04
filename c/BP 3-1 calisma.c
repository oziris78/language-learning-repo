

#include <stdio.h>

int main()
{
	
	//soru1: faktoriyel hesabi//
	
	int n_1,n_2, fakto;
	
	fakto=1;
	printf("Faktoriyelini ogrenmek istediginiz sayiyi giriniz:");
	scanf("%d", &n_1);
	n_2=n_1;
	
	while(n_1!=0) {
		fakto=fakto*n_1;
		n_1--;
	}
	
	printf("%d!=%d",n_2,fakto);
	
	
	printf("\n\n");
	printf("\n\n");
	
	//soru1.5: faktoriyel hesabi//
	
	int n4,n3,fakto1;
	
	fakto1=1;
	printf("Faktoriyelini ogrenmek istediginiz sayiyi giriniz:");
	scanf("%d", &n4);
	
	for(n3=n4; n3>0; n3--) {
		fakto1=fakto1*n3;
	}
	printf("%d!=%d",n4,fakto1);
	
	
	printf("\n\n");
	printf("\n\n");
	
	
	//soru2: Pozitif sayýlarýn girildiði ve girilen bu pozitif 
	// sayýlarýn en büyüðünün bulunduðu programý yazýnýz. //
	// Programda sayý girme iþlemi negatif bir sayý girilinceye kadar devam etmelidir. //
	
	
	int a,enb;
	
	enb=0;
	printf("Lutfen bir sayi giriniz:");
	scanf("%d", &a);
	
	while (a>0) {
		if(a>enb)
			enb=a;
			printf("Lutfen bir sayi giriniz:");
			scanf("%d", &a);
	
	}
	
	printf("En buyuk sayi=%d", enb);
	
	
	printf("\n\n");
	printf("\n\n");
	
	
	//soru 3: alt alta sayilar yazdirma //
	
	int k;
	printf("Bir k degeri giriniz:");
	scanf("%d", &k);
	
	while(k>0) {
		printf("%d\n",k);
		k--;	
	}
	
	
	printf("\n\n");
	printf("\n\n");
	
	
	
	// soru 4: Pozitif bir n sayýsýný ve bu n sayýsý kadar da tamsayýyý girdi olarak alan 
	//programý yazýnýz. Ayrýca, bu programda girilmiþ olan n tane tamsayýnýn kaçýnýn negatif, //
	//pozitif ve sýfýr olduðunu hesaplayýp ekranda gösteriniz. //
	
	int pos=0,neg=0,sifir=0,n,sayi,in;
	printf("Kac tane sayi gireceksiniz:");
	scanf("%d",&n);
	
	
		for(in=1;in<=n; in=in+1)
	{
	printf("%d. sayi: ",in);
	scanf("%d",&sayi);
	if(sayi>0)
	pos++;
	else if(sayi<0)
	neg++;
	else sifir++;
	}
	
	printf("\n%d adet pozitif sayi.\n",pos);
	printf("%d adet negatif sayi.\n",neg);
	printf("%d adet sifir sayisi.\n",sifir);
	
	
	
	printf("\n\n");
	printf("\n\n");
	
	
	
	
	
	return 0;
}
