

def factoriel(n):
    n = int(n)
    if n == 1:
        return 1
    else:
        return n * factoriel(n-1)
    
    
def addition(n):
    n = int(n)
    if n == 1:
        return 1
    else:
        return n + addition(n-1)
    
     
def double_sum(n):
    n = int(n)
    
    if(n % 2 == 1):
        return -1
    
    if n == 0:
        return 0
    else:
        return n+double_sum(n-2)
    
    
def odd_sum(n):
    n = int(n)
    
    if(n % 2 != 1):
        return -1
    
    return 1 if n == 1 else n + odd_sum(n-2) 
    

def even_square_sum(n):
    n = int(n)
    
    if(n % 2 == 1):
        return -1
    
    if n == 0:
        return 0
    else:
        return n*n + even_square_sum(n-2)
    
    
