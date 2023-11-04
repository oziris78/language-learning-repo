
def find_pow(a,n):
    return a**n

def give_one(a):
    return 1

def identity_func(a):
    return a

def find_pow2(a):
    return find_pow(a,2)

def find_pow3(a):
    return find_pow(a,3)

def find_pow4(a):
    return find_pow(a,4)

find_pow_of = (give_one, identity_func, find_pow2, find_pow3, find_pow4)

for i in range(5):
    print( "2 ^ " + str(i) + " = "  + str(find_pow_of[i](2)) )