

#include <stdio.h>
#include <math.h>
#include <string.h>



typedef struct ttt{
	int a, b, c;
} Point3D;


int main() {
	int N;
	printf("Enter N value: ");
	scanf("%d", &N);
	Point3D points[2*N];
	
	int big, small;
	int a, b, c, i;
	
	i = 0;
	for(c = 3; c <= N; c++){
		for(a = 1; a < N; a++){
			for(b = 1; b < N; b++){
				if(a*a + b*b == c*c){
					points[i].a = a;
					points[i].b = b;
					points[i].c = c;
					points[i + 1].a = 0;
					points[i + 1].b = 0;
					points[i + 1].c = 0;
					i++;
				}
			}
		}
	}
	
	printf("Triplets:\n");
	int printedSmall = 0;
	for(i = 0; i < N; i++){
		if(points[i].a == 0 || points[i].b == 0 || points[i].c == 0)
			continue;
		
		if(points[i].a == points[i+1].b && points[i+1].a == points[i].b)
			continue;

		big = points[i].a > points[i].b ? points[i].a : points[i].b;
		small = big == points[i].b ? points[i].a : points[i].b;
		
		printf("%d %d %d\n", small, big, points[i].c);
	}
	
	return 0;
}
