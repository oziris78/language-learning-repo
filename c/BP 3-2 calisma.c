

#include <stdio.h>
#include <math.h>

int main()
{
	
	/*  SORU 1 : Aþaðýdaki seçenekleri görüntüleyecek ve seçeneklere göre aþaðýda tanýmlanan seçeneðin alanýný bulacak bir C programý yazýnýz.
1. Kare
2. Daire
3. Bitti
Seceneginizi belirtiniz (1, 2, 3):*/
	
	float pi, karekenar, daireyaricap;
	int islemsayisi;
	pi=3.1415;
	printf("Kare ve daire alani hesaplayiciya hos geldiniz!\n");
	printf("Lutfen isleminizi seciniz:\n1.Kare\n2.Daire\n3.Bitti\n");
	scanf("%d", &islemsayisi);
	
		
	printf("\n");
		
	switch (islemsayisi) {
	
	case 1:
		printf("Karenizin bir kenarinin uzunlugunu giriniz:");
		scanf("%f", &karekenar);
		printf("\n");
		printf("Karenizin alani=%.3f", karekenar*karekenar);
		break;
		
	case 2:
		printf("Dairenizin yaricap uzunlugunu giriniz:");
		scanf("%f", &daireyaricap);
		printf("\n");
		printf("Dairenizin alani=%.3f", pi*daireyaricap*daireyaricap);
		break;
		
	case 3:
		printf("Yiv sonlandiriliyor");
		break;
		
	default:
		printf("Gecersiz islem girdiginiz yuzunden yiv sonlandiriliyor");
		break;
		
	
	}
	
	
	
	printf("\n");
	printf("\n");
	printf("\n");
	
	
	
	

	
	
	
	
	return 0;
}
