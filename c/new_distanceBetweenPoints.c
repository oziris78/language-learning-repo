

#include <math.h>
#include <stdio.h>


int main() {
	int times, i;
	float x1, x2, y1, y2;
	float dist;

	printf("How many times do you want to use this code: ");
	scanf("%d", &times);
	printf("\n");
	
	for(i = 0; i < times; i++){
		printf("Enter (x1, y1): ");
		scanf("%f %f", &x1, &y1);
		printf("\n");
		
		printf("Enter (x2, y2): ");
		scanf("%f %f", &x2, &y2);
		printf("\n");
		
		dist = pow(pow(x1 - x2, 2) + pow(y1 - y2, 2), 0.5);
		printf("The distance between (%.2f, %.2f) and B(%.2f, %.2f) is %f\n\n", x1, y1, x2, y2, dist);
	}
	
	
	return 0;
}
