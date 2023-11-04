//assignment_2

#include <stdio.h>

#define	N 100
#define	FAIL    -2
#define	EMPTY   -1

int Show_Menu();
int Insert(int A[], int ID);
int Find_ID(int A[], int ID);
void Show_All_IDs(int A[]);

main()
{
	int A[N], i, ID, opt, index;
	
	for(i=0; i<N; i++)
		A[i] = -1;
	
	do{
		opt = Show_Menu();  
		
        if (opt == 1) Insert(A, ID);
        if (opt == 2) Find_ID(A, ID);
        if (opt == 3) Show_All_IDs(A);
        if (opt == 4) break;
	
	
		
	}while(opt!=4);
	      	
	return 0;
}

int Show_Menu()
{
    int opt;
    printf("============== MENU ==============\n1--> Insert a new ID\n2--> Find an ID\n3--> Show all IDs\n4--> Exit\nSelect an option (1,2,3,4)\n");
    scanf("%d", &opt);
    return opt;
}

int Insert(int A[], int ID)
{
    int index, i;
    printf("Enter the ID to be stored: ");
    scanf("%d", &ID);
    index = ID % 100;

    for (i = index; i < N; i++)
    {
        if (A[i] == -1)
            {
                A[i] = ID;
                index = i;
                printf("The ID is inserted into the array.\n");
                return index;
            }
    }
    if (A[index] == -1)
    {
        for (i = 0; i < index; i++)
        {
            if (A[i] == -1)
            {
                A[i] = ID;
                index = i;
                printf("The ID is inserted into the array.\n");
                return index;
            }
        }
    }
    if (A[index] == -1)
    {
        printf("The array is full.\n");
        return -2;
    }

}

int Find_ID(int A[], int ID)
{
    int i , index;
    printf("Enter the ID to be found: ");
    scanf("%d", &ID);
    index = ID % 100;

    for (i = index; i < N; i++)
    {
        if (A[i] == ID)
        {
            printf("ID %d has been found in index %d.\n", ID, i);
            index = i;
            return index;
        }
    }
    for (i = 0; i < index; i++)
    {
        if (A[i] == ID)
        {
            printf("ID %d has been found in index %d.\n", ID, i);
            index = i;
            return index;
        }
    }
    printf("The ID %d cannot be found in the array.\n", ID);
    return -2;
}

void Show_All_IDs(int A[])
{
    int i;
    for (i = 0; i < N; i++)
    {
        if (A[i] != -1)
        {
            printf("A[%d] = %d\n", i, A[i]);
        }
    }
}