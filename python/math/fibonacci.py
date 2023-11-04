
length = 350

fibo = list([0,1,1,2])

for i in range(length):
    fibo.append(int(fibo[len(fibo)-1]) + int(fibo[len(fibo)-2]))


for i in range(0, len(fibo)):
    print(str(i) + " " + str(fibo[i]))


