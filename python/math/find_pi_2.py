

import time
import math

LIMIT = 1500


start = time.time()

pi = 0
for k in range(LIMIT):
    pi += (2**k) * (math.factorial(k)**2) / (math.factorial(2*k+1))

pi *= 2

end = time.time()

print(f"Pi is {pi}")
print(f"Error is {abs(math.pi - pi)}")
print(f"Time taken is {end - start} seconds.")





