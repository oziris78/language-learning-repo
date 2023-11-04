

#include <stdio.h>
#include <math.h>
#include <string.h>


typedef struct sayi{
	int s1;
	int s2;
	int s3;
	int s4;
	int s5;
	int s6;
	int s7;
	int s8;
	int s9;
	int s10;
}oyun;

int main()
{
	int sayac;
	oyun a;
	int i, n, sayi;
	
	a.s1=0;
	a.s2=0;
	a.s3=0;
	a.s4=0;
	a.s5=0;
	a.s6=0;
	a.s7=0;
	a.s8=0;
	a.s9=0;
	a.s10=0;
	
	for(n=0; n<999999999; n++){
		
		printf("Su anki durum:\n\t1 2 3 4 5 6 7 8 9 10\n\t%d %d %d %d %d %d %d %d %d %d\n\n", a.s1, a.s2, a.s3, a.s4, a.s5, a.s6, a.s7, a.s8, a.s9, a.s10);
		printf("Degismesini istedigin numara:");
		scanf("%d", &i);
		sayac++;
		printf("\n\n");
		
		if(i==1){
			if(a.s1==0) a.s1=1;
			else a.s1=0;
			
			if(a.s10==0) a.s10=1;
			else a.s10=0;
			
			if(a.s2==0) a.s2=1;
			else a.s2=0;
		}
		
		if(i==2){
			if(a.s2==0) a.s2=1;
			else a.s2=0;
			
			if(a.s1==0) a.s1=1;
			else a.s1=0;
			
			if(a.s3==0) a.s3=1;
			else a.s3=0;
		}
		
		if(i==3){
			if(a.s3==0) a.s3=1;
			else a.s3=0;
			
			if(a.s2==0) a.s2=1;
			else a.s2=0;
			
			if(a.s4==0) a.s4=1;
			else a.s4=0;
		}
		
		if(i==4){
			if(a.s4==0) a.s4=1;
			else a.s4=0;
			
			if(a.s3==0) a.s3=1;
			else a.s3=0;
			
			if(a.s5==0) a.s5=1;
			else a.s5=0;
		}
		
		if(i==5){
			if(a.s5==0) a.s5=1;
			else a.s5=0;
			
			if(a.s4==0) a.s4=1;
			else a.s4=0;
			
			if(a.s6==0) a.s6=1;
			else a.s6=0;
		}
		
		if(i==6){
			if(a.s6==0) a.s6=1;
			else a.s6=0;
			
			if(a.s5==0) a.s5=1;
			else a.s5=0;
			
			if(a.s7==0) a.s7=1;
			else a.s7=0;
		}
		
		if(i==7){
			if(a.s7==0) a.s7=1;
			else a.s7=0;
			
			if(a.s6==0) a.s6=1;
			else a.s6=0;
			
			if(a.s8==0) a.s8=1;
			else a.s8=0;
		}
		
		if(i==8){
			if(a.s8==0) a.s8=1;
			else a.s8=0;
			
			if(a.s7==0) a.s7=1;
			else a.s7=0;
			
			if(a.s9==0) a.s9=1;
			else a.s9=0;
		}
		
		if(i==9){
			if(a.s9==0) a.s9=1;
			else a.s9=0;
			
			if(a.s8==0) a.s8=1;
			else a.s8=0;
			
			if(a.s10==0) a.s10=1;
			else a.s10=0;
		}
		
		if(i==10){
			if(a.s10==0) a.s10=1;
			else a.s10=0;
			
			if(a.s9==0) a.s9=1;
			else a.s9=0;
			
			if(a.s1==0) a.s1=1;
			else a.s1=0;
		}
		
		if(a.s1==1 && a.s2==1 && a.s3==1 && a.s4==1 && a.s5==1 && a.s6==1 && a.s7==1 && a.s8==1 && a.s9==1 && a.s10==1) {
			printf("\n\n\t1 1 1 1 1 1 1 1 1 1\n\nKAZANDINIZ!\n\nToplam hamle sayisi=%d\n\n",sayac);
			break;
		}
		
		if(i<1 || i>10) sayac=sayac-1;
		
	}
	
	return 0;
}
