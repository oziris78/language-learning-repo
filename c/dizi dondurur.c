

#include <stdio.h>

int main()
{
	
	int n, i, j, k, e;
	int don;
	printf("Kac eleman olmasini istersiniz:");
	scanf("%d",&n);
	int dizi[n];
	int tutacak;
	
		printf("\n");
		
		
	for(k=0; k<n; k++){
		printf("dizinin %d. terimini giriniz=",k);
		scanf("%d", &dizi[k]);
		printf("\n");
	}
	
	
		printf("\n");
		
		printf("Diziniz:");
		for(j=0; j<n; j++){
		printf("%d ",dizi[j]);
		}
	
	
		printf("\n");
		
		printf("\nKac kez dondurulmesini istersiniz:");
		scanf("%d",&don);
		
		for(i=1; i<=don; i++){
			tutacak=dizi[n-1];
			for(e=n-2; e>=0; e--) {
				dizi[e+1]=dizi[e];
			}
			dizi[0]=tutacak;
		}
			
		int j1;
		printf("%d kez donen diziniz:",don);
		for(j1=0; j1<n; j1++){
		printf("%d ",dizi[j1]);
		}
		
			
	
		
		
	
	
	
	
	
	
	
	
	
	
	
	return 0;
}
