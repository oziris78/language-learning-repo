

#include <stdio.h>
#include <math.h>
#include <string.h>

#define N 300                                // butun yiv buna gore calisir, degistirip yivi calistirabilirsin

typedef struct uclu{
	int a;
	int b;
	int c;
}uclucozum;

int main()
{
	int a,b,c;
	uclucozum tam[2*N];
	int i=0;
	
	for(c=3; c<=N; c++){
		for(a=1; a<N; a++){
			for(b=1; b<N; b++){
				if(a*a+b*b==c*c){
					tam[i].a=a;
					tam[i].b=b;
					tam[i].c=c;
					i++;
					tam[i].a=0;
					tam[i].b=0;
					tam[i].c=0;
				}
			}
		}
	}
	
	printf("N'ye (%d) dek Pisagor ucluleri:\n", N);
	for(i=0; i<N; i++){
		if(tam[i].a==0 || tam[i].b==0 || tam[i].c==0) {continue;}
		
		if(tam[i].a==tam[i+1].b && tam[i+1].a==tam[i].b) {continue;}
		else if(tam[i].a>tam[i].b) {printf("%d %d %d\n",tam[i].b,tam[i].a,tam[i].c);}
		else printf("%d %d %d\n",tam[i].a,tam[i].b,tam[i].c);
	}
	
	return 0;
}
