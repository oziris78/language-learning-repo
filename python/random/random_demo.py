
import random

l = list()

for i in range(0,10):
    l.append( random.randint(1,11) )
    
print("ana dizelge:", l)
l2 = random.choices(l, weights=(1000,1,1,1,1,1,1,1,1,1), k=500)
print(l2)