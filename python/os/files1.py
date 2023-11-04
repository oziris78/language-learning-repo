

print()
print()


def read_file(filepath):
    f = open(filepath,"r")
    print(f.read())
    f.close()
    


def read_n_rows(fpath, n):
    f = open(fpath,"r")
    for i in range(0,n):
        print(f.readlines(n))
    f.close()



def add_text_to_file(filepath, s):
    f = open(filepath,"a+")
    f.write("\n" + s)
    f.seek(0)
    print(f.read())
    f.close()



def length_of_file(fname):
        with open(fname) as f:
            for i, l in enumerate(f):
                    pass
        return i + 1
    

def file_to_list(file):
    f = open(file,"r")
    s = str()
    for i in range(0,length_of_file(file)):
        s += f.readline(i)
    dzl = s.split()
    f.close()
    return dzl



def write_list_to_file(dz, filepath):
    f = open(filepath,"a+")
    for i in dz:
        i = str(i)
        f.write(i)
        f.write("\n")
    f.close()
    return read_file(filepath)
    






print()
print()