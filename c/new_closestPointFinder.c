


#include <stdio.h>
#include <math.h>
#include <float.h>


int main() {
	
	int i, N, index;
	float minDistance = FLT_MAX;
	float originX, originY;

	printf("Enter the origin: ");
	scanf("%f %f", &originX, &originY);
	printf("\n");
	
	printf("How many points are you going to enter:\nN=");
	scanf("%d", &N);
	printf("\n");
	
	float X[N], Y[N], distances[N];
	
	for(i = 0; i < N; i++){
		printf("Enter %d. point: ", i);
		scanf("%f %f", &X[i], &Y[i]);
		printf("\n");
	}
	
	for(i = 0; i < N; i++){
		distances[i]= pow((pow((X[i]-originX),2)+pow((Y[i]-originY),2)),0.5);
		if (distances[i] < minDistance) {
			minDistance = distances[i];
			index = i;
		}
	}
	
	printf("Origin = (%.3f, %.3f)\n", originX, originY);
	printf("Closest point to the origin = (%.3f, %.3f)\n", X[index], Y[index]);
	printf("Index of the closest point = %d\n", index);
	printf("Distance between the origin and the closest point = %.3f\n", minDistance);

	return 0;
}
