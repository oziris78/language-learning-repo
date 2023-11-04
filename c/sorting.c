#include <stdio.h>


void printArray(int arr[], int n){
	int i;
	printf("Array: ");
	for (i = 0; i < n; i++){
		printf("%d ", arr[i]);
	}
	printf("\n");
}


int getMax(int arr[], int n){
	int max = arr[0];
	int i;
	for (i = 1; i < n; i++) {
		if (arr[i] > max)
			max = arr[i];
	}
	return max;
}


void selectionSort(int arr[], int n){
	int tmp;
	int min;

	int i, j;
	for(i=0; i<n-1; i++){
		min=i;
		for(j=i; j<n; j++){
			if (arr[j] < arr[min]){
				min=j;
			}
		}
		tmp=arr[i];
		arr[i]=arr[min];
		arr[min]=tmp;
	}
}


void insertionSort(int arr[], int n){
   int i, value, j;
   for (i = 1; i < n; i++){
       value = arr[i];
       j = i-1;
       while (j >= 0 && arr[j] > value){
           arr[j+1] = arr[j];
           j = j-1;
       }
       arr[j+1] = value;
   }
}


void bubbleSort(int arr[], int n){
   int i, j;
   for (i = 0; i < n-1; i++){     
       for (j = 0; j < n-i-1; j++){ 
           if (arr[j] > arr[j+1]){
		   		int tmp = arr[j+1];
        		arr[j+1] = arr[j];
        		arr[j] = tmp;
    		}
		}
	}     
}


void countingSort(int arr[], int n) {
	int output[8];
	int max = getMax(arr,n);
	int count[max+1];
  
	int i;
	for (i = 0; i <= max; ++i) {
		count[i] = 0;
	}
	for (i = 0; i < n; i++) {
		count[arr[i]]++;
	}
	for (i = 1; i <= max; i++) {
		count[i] += count[i - 1];
	}
	for (i = n - 1; i >= 0; i--) {
		output[count[arr[i]] - 1] = arr[i];
		count[arr[i]]--;
	}
	for (i = 0; i < n; i++) {
		arr[i] = output[i];
	}
}


void merge(int arr[], int l, int m, int r){
    int i, j, k;
    int n1 = m - l + 1;
    int n2 =  r - m;
    int L[n1], R[n2];
    for (i = 0; i < n1; i++)
        L[i] = arr[l + i];
    for (j = 0; j < n2; j++)
        R[j] = arr[m + 1+ j];
    i = 0;
    j = 0;
    k = l;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }
    while (i < n1){
        arr[k] = L[i];
        i++;
        k++;
    }
    while (j < n2){
        arr[k] = R[j];
        j++;
        k++;
    }
}


void mergeSort(int arr[], int l, int r){
	if (l < r){
		int m = l + (r - l) /2;
		mergeSort(arr, l, m);
		mergeSort(arr, m + 1, r);
		merge(arr, l, m, r);
	}
}


void shellSort(int arr[], int n){
	int i, j, k, temp;
	for (k = n; k > 1; ) {
		k = (k < 5) ? 1 : ((k * 5 - 1) / 11);
		for (i = k - 1; ++i < n; ) {
			temp = arr[i];
			for (j = i; arr[j - k] > temp; ) {
				arr[j] = arr[j - k];
				if ((j -= k) < k)
					break;
			}
			arr[j] = temp;
		}
	}	
}


void quickSort(int arr[], int l, int r){
    int i, j, pivot, tmp;

    pivot = l;
    if(r>l){
        pivot = l;
        i = l;
        j = r;
        while (i < j){
            while (arr[i] <= arr[pivot] && i < r && j > i){
                i++;
            }
            while (arr[j] >= arr[pivot] && j >= l && j >= i){
                j--;
            }
            if (j > i){
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        tmp = arr[j];
        arr[j] = arr[pivot];
        arr[pivot] = tmp;
        quickSort(arr, l, j - 1);
        quickSort(arr, j + 1 ,r);
    }
}

int main(){
	int arr[8] = { 15, 40, 867, 5, 298, 73, 45, 23 };
	printArray(arr,8);
	
	selectionSort(arr, 8);
	//insertionSort(arr, 8);
	//bubbleSort(arr, 8);
	//countingSort(arr, 8);
	//mergeSort(arr, 0, 7);
	//shellSort(arr, 8);
	//quickSort(arr, 0, 7);
	printArray(arr,8);
	
	return 0;
}
