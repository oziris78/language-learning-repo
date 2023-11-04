

from math import sqrt


# abundant sayı : it's factors' (except itself) sum is greater than itself
# ex: 12 => 1,2,3,4,6
# 1 + 2 + 3 + 4 + 6 > 12  =>  12 is abundant
def abundant(n):
    s = 1
    for i in range(2,n):
        if n%i==0:
            s = s + int(i)
    
    if s>n:
        return True
    else:
        return False
    

def abundant_up_until_n(n):
    dz = []
    for i in range(2,n):
        if abundant(i) == True:
            dz.append(int(i))
            
    return dz


def exact_squares(n):
    dz = list()
    for i in range(1,n):
        if int(sqrt(i)) == float(sqrt(i)):
            dz.append(i)
    
    return dz
    

def exact_squares2(a,b):
    km1 = set(exact_squares(a))
    km2 = set(exact_squares(b))
    
    if len(km1)>len(km2):
        km3 = km1.union(km2)
        km4 = km3.difference(km2)
        return list(sorted(km4))
    
    if len(km2)>len(km1):
        km3 = km1.union(km2)
        km4 = km3.difference(km1)
        return list(sorted(km4))
        

def harmonic(n):
    tp = 0
    for i in range(1,n+1):
        tp += 1/i

    return tp


    

print()
print()

# try them here

print()
print()

