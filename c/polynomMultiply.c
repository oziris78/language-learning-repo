#include <stdio.h>
#include <stdlib.h>

typedef struct n{
	int coefficient;
	int power;
	struct n* nextNode;
} Node;

Node* createPolynomNode(Node* startingNode,int rank,int coefficient){
	Node* newNode= (Node*) malloc(sizeof(Node)); 
	newNode->coefficient=coefficient;
	newNode->power=rank;
	newNode->nextNode=NULL;

	if(startingNode==NULL){
		
		// eðer linked list boþsa ilk elemaný manuel sekilde olustururuz
		
		return newNode;
	}
	Node* pointer = startingNode;
	while(pointer->nextNode!=NULL){
	
		pointer=pointer->nextNode;
		//bu kýsýmda null olmayan son linked list elemanina gideriz
	}
	pointer->nextNode=newNode;
	return startingNode;
	
}

Node* multiplyPolynoms(Node* node1, Node* node2,Node* node3){
	Node *pointer1, *pointer2;
	pointer1=node1;
	pointer2=node2;
	while(pointer1!=NULL){
		while(pointer2!=NULL){
			node3=createPolynomNode(node3,pointer1->power+pointer2->power,pointer1->coefficient*pointer2->coefficient);
			pointer2 = pointer2->nextNode;
		}
		pointer2=node2;
		// ilk polinomun ilk elemanýný 2. polinomun her elemaniyla carptik simdi 2. polinomu basa alip 
		pointer1=pointer1->nextNode;
		//1. polinomu 1 sira ilerletip isleme devam edilir
	}

	return node3;
}


void displayNodes(Node* node){
	while(node!=NULL){
		if(node->power==0){
			printf("%d",node->coefficient);
		}
		else{
			printf("%dx^%d+",node->coefficient,node->power);
		}
		
		node=node->nextNode;
		
	}
	printf("\n\n\n");
}


int main(){
	//poly1
	
	int rankOf1,rankOf2;
	Node* multiplyNodeStarting  = NULL;
	Node* startingNodeForPoly1=NULL;
	Node* startingNodeForPoly2=NULL;
	printf("please enter rank of your first polynom: ");
	scanf("%d",&rankOf1);
	
	int z;
	for(z = 0; z<=rankOf1;z++){
		int coefficientOfNode;
		int degree = rankOf1;
		printf("please enter coefficient for term x^%d: ",degree-z);
		scanf("%d",&coefficientOfNode);
		startingNodeForPoly1=createPolynomNode(startingNodeForPoly1,degree-z,coefficientOfNode);
	}
	printf("\n\n");	
	printf("please enter rank of your second polynom: ");
	scanf("%d",&rankOf1);
	
	for(z = 0; z<=rankOf1;z++){
		int coefficientOfNode;
		int degree = rankOf1;
		printf("please enter coefficient for term x^%d: ",degree-z);
		scanf("%d",&coefficientOfNode);
		startingNodeForPoly2=createPolynomNode(startingNodeForPoly2,degree-z,coefficientOfNode);
	}
	printf("\n\n");
	multiplyNodeStarting= multiplyPolynoms(startingNodeForPoly1,startingNodeForPoly2,multiplyNodeStarting);
	displayNodes(startingNodeForPoly1);
	displayNodes(startingNodeForPoly2);
	displayNodes(multiplyNodeStarting);
	
	

	

}
