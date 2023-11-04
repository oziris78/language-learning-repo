

import math

def is_prime(n):
    if(n%2==0):
        print(f"{n} is NOT a prime number")
        return
    
    for i in range(3, int(math.sqrt(n))+1, 2):
        if(n%i==0):
            print(f"{n} is NOT a prime number")
            return
            
    print(f"{n} is a prime number")


for i in range(2147483000, 2147483000+1000):
    is_prime(i)