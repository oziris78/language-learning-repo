


#include <stdio.h>

int enk(int a, int b, int c) {
	int enkucuk;
	if (a<b){
		if(a<c) { enkucuk=a;}
		else enkucuk=c;
	}
	else if (b<c) { enkucuk=b;}
	else enkucuk=c;
	
	return (enkucuk);
}

int main()
{
	
	printf("Uc adet sayi giriniz:\n");
	int x,y,z;
	printf("1. sayi:");
	scanf("%d",&x);
	printf("2. sayi:");
	scanf("%d",&y);
	printf("3. sayi:");
	scanf("%d",&z);
	
	printf("Bu uc sayinin en kucugu %d 'dir.",enk(x,y,z));
	
	
	
	
	return 0;
}
