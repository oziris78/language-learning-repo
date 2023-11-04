

# QUESTION:
# person #1 takes 0.01 of all remaining money
# person #2 takes 0.02 of all REMAINING money
# person #3 takes 0.03 of all REMAINING money
# person #4 takes 0.04 of all REMAINING money
# ...
# who takes the most money?


def gets_money(n: int, A: float):
    ratio = 1.00
    for i in range(1, n):
        ratio *= (1.0 - i / 100.0)
    this_ratio = n / 100.0
    total_money_taken = ratio * A * this_ratio
    return total_money_taken



A = 100**2

people = []

for i in range(1, 101):
    people.append(gets_money(i, A))

print("max amount of money taken: " + str(max(people)))
print("the person who took it: person #" + str(people.index(max(people)) + 1)) # +1 since python is 0-based

