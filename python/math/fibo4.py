
def fibo4(n):
    dfibo = [1,1,1,1]
    for i in range(0,n+5):
        dfibo.append(int(dfibo[i]+dfibo[i+1]+dfibo[i+2]+dfibo[i+3]))
    return dfibo[n]


print(fibo4(15))