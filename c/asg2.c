/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <stdio.h>

void Insert(int A[])
{
    int complete=0,ID,i;
    printf("Enter the ID you wish to insert: ");
    scanf("%d", &ID);
    for(i=ID%100; i<100; i++)
    {
        if(A[i]==-1) 
        {
            A[i] = ID;
            complete=1;
            break;
        }
        else continue;
    }
    if(complete==0)
    {
        for(i=0; i<ID%100; i++)
        {
            if(A[i]==-1)
            {
                A[i] = ID;
                complete=1;
                break;
            }
            else continue;
        }
    }
    if(complete==0) 
    {
        printf("Could not assign: Memory full.\n"); 
        return;
    }
    else
    {
        printf("Assigned to index %d.\n",i);
        return;
    }
}

void Search(int A[])
{
    int ID,complete=0,i;
    printf("Enter the ID you wish to search for: ");
    scanf("%d",&ID);
    for(i=0; i<100; i++)
    {
        if(A[i]==ID) 
        {
            complete=1;
            break;
        }
        else continue;
    }
    if(complete==1) printf("ID found at index %d.\n", i);
    else printf("ID not found.\n");
    return;
}

void Show(int A[])
{
    int i;
    for(i=0; i<100; i++)
    {
        if(A[i]!=-1) printf("%d --> %d\n",i,A[i]);
    }
    return;
}

int main()
{
    int menu,A[100],i;
    for(i=0; i<100; i++) A[i]=-1;
    do
    {
        printf("Welcome to Indexr. Please select an operation.\n");
        printf("1. Insert a new ID\n");
        printf("2. Find an ID\n");
        printf("3. Show all IDs\n");
        printf("4. Exit\n");
        scanf("%d",&menu);
        
        switch(menu)
        {
            case 1: Insert(A); break;
            case 2: Search(A); break;
            case 3: Show(A); break;
            case 4: printf("Thanks for using Indexr!"); break;
        }
    }while(menu!=4);
}
