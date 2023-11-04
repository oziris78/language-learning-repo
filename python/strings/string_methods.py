




def freq(s):
    sz = {}
    for n in s:
        keys = sz.keys()
        if n in keys:
            sz[n] += 1
        else:
            sz[n] = 1
    return sz
        
def first_and_last_two_letter(s):
    return s[0:2] + s[(len(s)-2):len(s)]

def add_inverse(s1, s2):
    return s2+" "+s1

def add(s1, s2):
    return s1+" "+s2

def longest(dz):
    h = -9999
    k = -999
    for i in range(0,len(dz)):
        if len(dz[i]) > h:
            h = len(dz[i])
            k = i
    return dz[k]


def change(s):
    new_str = s[len(s)-1] + s[1:-1] + s[0]
    return  new_str


def remove_odd_ones(s):
    new_str = str()
    odd = -1
    for i in s:
        odd = odd + 1
        if odd%2==0:
            new_str += s[odd]
        else:
            continue
    return new_str


def letter_frequency(s):
    s = str(s)
    sz = dict()
    dz = s.split()
    for n in dz:
        if n in sz:
            sz[n] += 1
        else:
            sz[n] = 1
    return sz


def upper_and_lower():
    s = str(input("Dizgi giriniz: "))
    print(s.upper())
    print(s.lower())


def insert(s1,s2):
    s3 = s1[0:int(len(s1)/2)] + s2 + s1[int(len(s2)/2) + 1 : ]
    return s3


def four_times_last_two(s):
    return 4*str(s[len(s)-2:])


def upper_lower_counts(s):
    up = 0
    low = 0
    for i in range(0,len(s)):
        if s[i].upper() == s[i]:
            up = up +1
        else:
            low = low +1
    return f"Upper count : {up}\n Lower count : {low}"
            
    

    
# isogram : theres no repeating letter
def isogram(s):
    dz = list()
    for i in range(0,len(s)):
        dz.append(str(s[i]))
    dz2 = list(set(dz))
    if len(dz2)!=len(dz):
        return False
    return True




def str_mountain(s):
    t= str()
    for i in range(0, len(s)+1):
        t += s[0:i] + "\n"
        
    for i in range(1, len(s)):
        t += s[:-i] + "\n"
    return t


def make_numeric(s):
    t = str()
    for i in range(0, len(s)):
        if s[i] == "a" or s[i] == "A":
            t += "4"
        elif s[i] == "e" or s[i] == "E":
            t += "3"
        elif s[i] == "o" or s[i] == "O":
            t += "0"
        elif s[i] == "i" or s[i] == "I" or s[i] == "ı" or s[i] == "İ":
            t += "1"
        else:
            t += s[i]
    return t
    
    
def alternate_str(s):
    t = str()
    for i in range(0, len(s)):
        if i%2==0:
            t += s[i].upper()
        if i%2==1:
            t += s[i].lower()
    return t    
    
    
def multiply_letters(s, n):
    t = str()
    for i in range(0, len(s)):
        t += s[i] * n
    return t
    

def multiply_letters_both_sides(s, n):
    t = str()
    t = s[0]*n + s[1:len(s)-1] + s[-1]*n 
    return t
