
#include <stdio.h>
#include <stdlib.h>

typedef struct node {
  int data;
  struct node* next;
} Stack;


void printStack(Stack* r){
	while(r != NULL){
		printf("Data: %d\n", r->data);
		r = r->next;
	}
	printf("\n");
}


Stack* push(Stack* r, int d){
	if(r == NULL){
		r = (Stack*) malloc(sizeof(Stack));
		r->data = d;
		r->next = NULL;
	} 
	else {
		Stack* iter = r;
		while(iter->next != NULL){
			iter = iter->next;
		}
		Stack* temp = (Stack*) malloc(sizeof(Stack));
		temp->data = d;
		temp->next = NULL;
		iter->next = temp;
	}
	return r;
}


int pop(Stack* r){
	if(r==NULL){
		printf("Stack de eleman yok\n");
		return -1;
	} 
	else if(r->next==NULL){
		int res = r->data;
		free(r);
		return res;
	} 
	else{
		Stack* iter = r;
		while(iter->next->next != NULL){
			iter = iter->next;
		}
		Stack* temp = iter->next;
		int res = temp->data;
		iter->next = NULL;
		free(temp);
		return res;
	}
}



int main(){
	Stack* stack = NULL;
	stack = push(stack, 10);
	stack = push(stack, 12);
	stack = push(stack, 16);
	stack = push(stack, 20);
	printStack(stack);
	printf("Deleted: %d\n", pop(stack));
	printStack(stack);
	printf("Deleted: %d\n", pop(stack));
	printStack(stack);

	return 0;
}
