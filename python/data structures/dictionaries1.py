

print()
print()

d1 = {1:10, 2:20}
d2 = {3:30, 4:40}
d3 = {5:50, 6:60}
d4 = {}

def add_dicts(sz1, sz2):
    for key, value in sz2.items():
        sz1[key] = value
    return sz1

def add_dicts2(sz1, sz2):
    sz1.update(sz2)
    return sz1

def print_dict(sz):
    for i in sz.items():
        print(i)


sozluk = {"obj1":10.2 ,"obj2":301.2 ,"obj3":4.941 ,"obj4":31.415926, "obj5": 99}

def Enbbulur(dicct):
    max = -99999999
    for j, i in dicct.items():
        if i > max:
            max = i
            acar = j
    print(str(acar)+ " = "+ str(max))
    del dicct[acar]




print()
print()