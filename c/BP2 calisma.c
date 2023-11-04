

#include <stdio.h>
#include <math.h>

int main()
{
	
	//Soru1 : özel f(x) fonksiyonu//
	
	float a,b;
	printf("f(x,y) fonksiyonuna girmek istediginiz x ve y degerlerini sirasiyla giriniz:");
	scanf("%f %f", &a,&b);
	float d1,d2,d3;
	d1=a*b;
	d2=a+b;
	d3=b-a;
	
	printf("\n \n");
	if (a>=0 && b>=00) printf("Sonucunuz= %.3f", d1);
	if (a>=0 && b<0) printf("Sonucunuz= %.3f", d2);
	if (a<0 && b>=0) printf("Sonucunuz= %.3f", d3);

	printf("\n \n");
	printf("\n \n");
	
	// Soru 2: DYD'de nerede oldugunu bulma //
	
	float k1,k2;
	printf("DYD'de yerini ogrenmek istediginiz kertigin x ve y yerlemlerini sirasiyla giriniz:");
	scanf("%f %f", &k1, &k2);
	
	if (k1==0 && k2==0) printf("Kertiginiz orijin kertigidir.");
		else if (k1>0 && k2>0) printf("Kertiginiz 1. bolgededir.");
			else  if (k1>0 && k2<0) printf("Kertiginiz 4. bolgededir.");
				 else if (k1<0 && k2>0) printf("Kertiginiz 2. bolgededir.");
					else if (k1<0 && k2<0) printf("Kertiginiz 3. bolgededir.");
						else if (k1=0 && k2!=0) printf("Kertiginiz y ekseni uzerindedir.");
							else if (k2=0 && k1!=0) printf("Kertiginiz x ekseni uzerindedir.");
	
	printf("\n \n");
	printf("\n \n");
	
	// Soru 3: sayinin bilmem nelerini bulma alistirmasi //
	
	float s;
	float skare,skup,seksik,sfazla,skok;
	int islem;
	
	printf("Makineyi uzerinde kullanacaginiz sayiyi giriniz:");
	scanf("%f", &s);
	
	skare=s*s;
	skup=s*s*s;
	seksik=s-1;
	sfazla=s+1;
	skok=pow(s,0.5);
	
	printf("Islemler:\n1.Karesini alma\n2.Kubunu alma\n3.Bir eksigini bulma\n4.Bir fazlasini bulma\n5.Karekokunu bulma\n");
	printf("Uygulamak istediginiz islemi seciniz:");
	scanf("%d", &islem);
	
	switch(islem) {
	case 1:
		printf("Sayinizin karesi=%.3f", skare);
		break;
	case 2:
		printf("Sayinizin kubu=%.3f", skup);
		break;
	case 3:
		printf("Sayinizin bir eksigi=%.3f", seksik);
		break;
	case 4:
		printf("Sayinizin bir fazlasi=%.3f", sfazla);
		break;
	case 5:
		if(s>=0) printf("Sayinizin karekoku=%.3f", skok);
		else printf("Sayiniz sifirdan kucuk oldugu icin sayinizin karekoku alinamaz.");
		break;
	default:
		printf("Tanimlanmamis islem girildi, yivleme sonlandiriliyor.");
		break;
	}
	
	
	return 0;
}
