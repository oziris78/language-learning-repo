
import random

ITER_COUNT = 1000000000
T = 0


for _ in range(ITER_COUNT):
    x = random.random()
    y = random.random()
    if x*x + y*y <= 1:
        T += 1

print(4.000000000000001 * T / ITER_COUNT)


