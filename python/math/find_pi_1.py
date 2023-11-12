

import math
import time

LIMIT = 10_000_000


start = time.time()

pi, sign = 0, 1
for i in range(1, LIMIT, 2):
    pi += (1.0 / i) * sign
    sign *= -1

pi *= 4

end = time.time()

print(f"Pi is {pi}")
print(f"Error is {abs(math.pi - pi)}")
print(f"Time taken is {end - start} seconds.")





