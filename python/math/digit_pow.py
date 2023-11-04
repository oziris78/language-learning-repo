

from math import pow

def digit_pow(limit, h, n):
    digit_sum = int(0)
    l = list()
    for i in range(limit, limit+h+1):
        i = str(i)
    
        for j in i:
            j = int(j)
            digit_sum += pow(j, n)
            
        if(int(i) == digit_sum):
            l.append(i)
            
        digit_sum = 0
    
    return l


with open("digit_pow.txt", "a+") as f:
    for i in range(1,11):
        f.write(f"{i}: " + str(digit_pow(1000000,1000000,i)) + "\n")
   
    