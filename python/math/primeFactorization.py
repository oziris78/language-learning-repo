

def prime_factor(num):
    if num == 1:
        return {1 : 1}
    factors = {}
    while num != 1:
        for i in range(2, int(num)+1):
            if ( num % i == 0):
            
                if list(factors.keys()).count(i) == 0: # yok ise 1 olarak ekle
                    factors.update({i : 1})
                else: # var ise bulunan deger bir arttirilacak
                    occurence_count = list(factors.keys()).count(i)
                    occurence_count += 1
                    factors.update({i : occurence_count})
                
                num /= i
                break
    return factors
            
            
def print_prime_factors(factors):
    s = ""
    for i in range(0, len(factors)):
        s += str(list(factors.keys())[i]) + "^" + str(list(factors.values())[i]) + " "
    s = s[:len(s)-1]
    print(s)
            
            
            
print_prime_factors(prime_factor(1918))