
print()
print()


def add(dz):
    s = 0
    for i in range(0,len(dz)):
        s += dz[i]
    
    return s

def mul(dz):
    m = 1
    for i in range(0,len(dz)):
        m *= dz[i]
    
    return m

def my_max(dz):
    return max(dz)

def my_min(dz):
    return min(dz)

def two_or_same(dz):
    sayac = 0
    for i in range(0,len(dz)):
        s = str(dz[i])
        if (s[len(s)-1] is s[0]) and len(s)>=2:
            sayac += 1
    
    return sayac
            
def is_unique(dz):
    return list(set(dz))

def is_empty(dz):
    if len(dz)==0:
        return True

    return False

def longs(dz, n):
    dz2 = list()
    for i in range(0, len(dz)):
        s = str(dz[i])
        if len(s)>n:
            dz2.append(s)
    
    return dz2

def has_common(dz1,dz2):
    for i in dz1:
        for j in dz2:
            if i == j:
                return True

    return False

def print_odds(dz):
    dz2 = list()
    for i in range(0, len(dz)):
        if dz[i]%2==1:
            dz2.append(str(dz[i]))
        
    print(dz2)

def list_diff(dz1,dz2):
    dz3 = set(dz1)
    dz4 = set(dz2)
    dz5 = dz3.difference(dz4)
    return list(dz5)

def list_to_str(dz):
    s = str()
    for i in range(0,len(dz)):
        s += str(dz[i])
        
    return s

def append_list_to_end(dz1,dz2):
    dz3 = dz1
    for i in range(0,len(dz2)):
        dz3.append(dz2[i])
    
    return dz3

def frequency(dz,s):
    counter = 0
    for i in range(0,len(dz)):
        if str(s) == str(dz[i]):
            counter += 1
            
    return counter

def has_list(dz):
    for i in range(0,len(dz)):
        if type(dz[i]) is list:
            return True
        
    return False

def has_the_same_term(dz):
    counter = 0
    for i in range(0,len(dz)-1):
        if str(dz[i]) == str(dz[i+1]):
            counter = counter + 1 
    
    if counter == len(dz)-1:
        return True
    else:
        return False

def max_of_list(dz):
    index = 0
    my_sum = 0
    mmax = -99999999999999999
    for i in range(0,len(dz)):
        for j in range(0,len(dz[i])):
            my_sum += dz[i][j]
            
        if my_sum>mmax:
            mmax = my_sum
            my_sum = 0
            index = i
            
    return dz[index]
         

def get_bigger_than(dz,c):
    dz2 = list()
    for i in range(0,len(dz)):
        if int(dz[i])>c:
            dz2.append(dz[i])
    
    return dz2
    
def flatten(dz):
    dz2 = list()
    for i in range(0,len(dz)):
        if (type(dz[i]) is str) or (type(dz[i]) is int):
            dz2.append(dz[i])
        elif type(dz[i]) is list:
            for j in range(0,len(dz[i])):
                dz2.append(  dz[i][j]  )
        
    return dz2        
   
   







print()
print()

