

from math import sqrt

print("Enter a,b,c values for ax^2+bx+c=0 equation:")
a = float(input("a= "))
b = float(input("b= "))
c = float(input("c= "))

discriminant = b * b - 4 * a * c

print("\n\n")

if a == 0:
    print("Value of a can't be zero")
elif discriminant < 0:
    print(f"The equation {a}x^2 + {b}x + {c} has no real roots.")
elif discriminant == 0:
    root = str(-b / 2 * a)
    print(f"The equation {a}x^2 + {b}x + {c} has two equal roots: \n x1 = x2 = {root}")
elif discriminant > 0:
    x1 = ((-b + sqrt(discriminant)) / (2 * a))
    x2 = ((-b - sqrt(discriminant)) / (2 * a))
    print(f"The equation {a}x^2 + {b}x + {c} has two unequal real roots: \n x1 = {x1} \n x2 = {x2}")
    
print("\n\n")




