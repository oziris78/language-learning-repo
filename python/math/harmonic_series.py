
import os
os.chdir(os.path.dirname(__file__))



def harmonic_series(n):
    sum = int(0)
    for i in range(1,n+1):
        sum += 1/i
    return sum


def harmonic_series2(n,k):
    sum = int(0)
    for i in range(n,k+1):
        sum += 1/i
    return sum

# ------------------------------- # 

n = int(100)

with open(f"harmonic_series.txt", "a+") as file:
    for i in range(1,n+1):
        if i == n:
            file.write( str(i) + " : " + str(harmonic_series(i))) 
        else:
            file.write( str(i) + " : " +  str(harmonic_series(i)) + "\n" ) 
        
