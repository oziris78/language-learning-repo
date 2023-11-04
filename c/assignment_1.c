//assignment_1

#include <stdio.h>

void Numeric2Char(char A[], int numeric)
{
    int i, d = 10000000, m;
    
    printf("Enter the numerical value with 8 digits: ");
    scanf("%d", &numeric);
    for (i = 0; i < 8; i++)
    {
        m = numeric/d;
        A[i] = m + '0';
        numeric -= m * d;
        d /= 10;
    }
}

int Char2Numeric(char A[])
{
    //char /*cha,*/ A[9];
    int i, numeric = 0, d = 10000000, n, m; 
    //printf("Enter the string representation with 8 characters: ");
    //scanf("%s", A);
    for (i = 0; i < 8; i++)
    {
        n = A[i] - '0';
        m = n * d;
        numeric += m;
        d /= 10;
    }
    return numeric;
}

int main()
{
    char A[9];
    int numeric, input;
    printf("To convert integer to char, enter 1.\nTo convert char to integer, enter 2.\n");
    scanf("%d", &input);
    if (input == 1)
    {
        A[8] = '\0';
        Numeric2Char(A, numeric);
        printf("Char: %s", A);
        return 0;
    }
    else if (input == 2)
    {
        printf("Enter the string representation with 8 characters: ");
        scanf("%s", A);
        A[9] = '\0';
        printf("The integer representation: %d", Char2Numeric(A));
        return 0;
    }
    return 0;
}