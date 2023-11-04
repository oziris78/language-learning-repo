

#include <stdio.h>
#include <math.h>
#include <string.h>

// \n

struct satir{
	int bir;
	int iki;
	int uc;
	int dort;
};

typedef struct satir str;

int main()
{
	int i;
	str matris[4];
	printf("4x4 boyutlu matrisinizi giriniz:\n");
	for(i=0;i<4;i++){
		printf("%d. satirin elemanlarini aralarinda bir bosluk birakarak sirayla giriniz:",i+1);
		scanf("%d %d %d %d",&matris[i].bir,&matris[i].iki,&matris[i].uc,&matris[i].dort);
		printf("\n");
	}
	
	int det1,det2,det3,det4,det5,det6,det7,det8,det9,det10,det11,det12;
	int det13,det14,det15,det16,det17,det18,det19,det20,det21,det22,det23,det24;
	
	det1=matris[1].bir*matris[2].iki*matris[3].uc*matris[4].dort;
	det2=matris[1].bir*matris[2].dort*matris[3].iki*matris[4].uc;
	det3=matris[1].bir*matris[2].uc*matris[3].dort*matris[4].iki;
	det4=matris[1].iki*matris[2].dort*matris[3].uc*matris[4].bir;
	det5=matris[1].iki*matris[2].bir*matris[3].dort*matris[4].uc;
	det6=matris[1].iki*matris[2].uc*matris[3].bir*matris[4].dort;
	det7=matris[1].uc*matris[2].bir*matris[3].iki*matris[4].dort;
	det8=matris[1].uc*matris[2].dort*matris[3].bir*matris[4].iki;	
	det9=matris[1].uc*matris[2].iki*matris[3].dort*matris[4].bir;
	det10=matris[1].dort*matris[2].uc*matris[3].iki*matris[4].bir;
	det11=matris[1].dort*matris[2].bir*matris[3].uc*matris[4].iki;
	det12=matris[1].uc*matris[2].dort*matris[3].bir*matris[4].iki;
	
	det13=matris[1].bir*matris[2].dort*matris[3].uc*matris[4].iki;
	det14=matris[1].bir*matris[2].iki*matris[3].dort*matris[4].uc;
	det15=matris[1].bir*matris[2].uc*matris[3].iki*matris[4].dort;
	det16=matris[1].iki*matris[2].bir*matris[3].uc*matris[4].dort;
	det17=matris[1].iki*matris[2].dort*matris[3].bir*matris[4].uc;
	det18=matris[1].iki*matris[2].uc*matris[3].dort*matris[4].bir;
	det19=matris[1].uc*matris[2].dort*matris[3].iki*matris[4].bir;
	det20=matris[1].uc*matris[2].bir*matris[3].dort*matris[4].iki;
	det21=matris[1].uc*matris[2].iki*matris[3].bir*matris[4].dort;
	det22=matris[1].dort*matris[2].bir*matris[3].iki*matris[4].uc;
	det23=matris[1].dort*matris[2].uc*matris[3].bir*matris[4].iki;
	det24=matris[1].dort*matris[2].iki*matris[3].uc*matris[4].bir;
	
	int determinant;
	determinant=det1+det2+det3+det4+det5+det6+det7+det8+det9+det10+det11+det12-det13-det14-det15-det16-det17-det18-det19-det20-det21-det22-det23-det24;
	
	if(matris[1].bir==matris[1].iki && matris[1].iki==matris[1].uc && matris[1].uc==matris[1].dort){determinant=0;}
	if(matris[2].bir==matris[2].iki && matris[2].iki==matris[2].uc && matris[2].uc==matris[2].dort){determinant=0;}
	if(matris[3].bir==matris[3].iki && matris[3].iki==matris[3].uc && matris[3].uc==matris[3].dort){determinant=0;}
	if(matris[4].bir==matris[4].iki && matris[4].iki==matris[4].uc && matris[4].uc==matris[4].dort){determinant=0;}
	
	
	printf("MATRISIN DETERMINANTI= %d\n\n",determinant);
	
	printf("MATRISINIZ:\n");
	
	int j;
	for(j=0;j<4;j++){
	printf("|%4d  %4d  %4d  %4d|\n",matris[j].bir,matris[j].iki,matris[j].uc,matris[j].dort);
	}
	
	printf("\n\nNot: Matrisin herhangi bir elemani +5 basamakli ise gorsel kotu gozukebilir\n\n");
	
	
	
	return 0;
}
