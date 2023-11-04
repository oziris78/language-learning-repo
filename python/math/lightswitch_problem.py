
# The Lightswitch Problem
# https://www.youtube.com/watch?v=-UBDRX6bk-A

lights = [False for _ in range(100)]

for person in range(100):
    for index in range(person, 100, person+1):
        lights[index] = not lights[index]

indexes = [i+1 for i, val in enumerate(lights) if val]
print(indexes)  # [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]
