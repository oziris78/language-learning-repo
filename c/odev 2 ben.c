

#include <stdio.h>
#define N 100
#define FAIL -2
#define EMPTY -1



int Show_Menu(){
	int opt;
	printf("\n\nMenu:\n1. ID kaydet\n2.ID bul\n3.Tum ID'leri goster'\n4.Cikis\nSecenekler=(1,2,3,4):");
	scanf("%d",&opt);
	return (opt);
}



int Insert(int A[], int ID){
	int indis, i;
	printf("Kaydedilmesini istediginiz ID'yi giriniz:");
	scanf("%d", &ID);
	indis=ID%100;
	
	for (i=indis; i<100; i++){
		if(A[i]==EMPTY){
			A[i]=ID;
			indis=i;
			printf("%d ID'niz %d'ye yerlestirildi.\n", ID,i);
			return (indis);
		}
	}
	
	if(A[indis]==EMPTY){
		for (i=0; i<indis; i++){
			A[i]=ID;
			indis=i;
			printf("%d ID'niz %d'ye yerlestirildi.\n", ID,i);
			return (indis);	
		}
	}
	if (A[indis] == EMPTY)
    {
        printf("Dizi dopdolu.\n");
        return (FAIL);
    }
}



int Find_ID(int A[], int ID){
	int i, indis;
	printf("Bulmak istediginiz ID'yi giriniz:");
	scanf("%d", &ID);
	for (i=indis; i<100; i++){
		if (A[i]==ID) {printf("%d numarali ID %d. yerde bulunmaktadir.\n",ID,i);
		return (indis);
		}
	}
	for (i=0; i<indis; i++) {
		if (A[i]==ID) {printf("%d numarali ID %d. yerde bulunmaktadir.\n", ID, i);
		return (indis);
		}
	}
	printf("Girdiginiz ID bulunamadi.\n");
	return (FAIL);
}



void Show_All_IDs(int A[]){
	int i;
	for (i=0; i<100; i++){
		if(A[i]!=EMPTY) {printf("A[%d]=%d\n",i,A[i]);}
	}
}



int main()
{
	int A[100], secim, ID, i;
	
	for(i=0; i<100; i++){
		A[i]=-1;
	}
	
	do{
		secim=Show_Menu();
		if (secim==1) Insert(A,ID);
        if (secim == 2) Find_ID(A, ID);
        if (secim == 3) Show_All_IDs(A);
        if (secim == 4) break;
	}
	while(secim!=4);
	
	return 0;
}
