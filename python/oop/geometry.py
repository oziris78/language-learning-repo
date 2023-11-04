

from math import pi




class Circle():
    def __init__(self,r):
        self.r = r
        
    def print_area(self):
        print(pi * self.r * self.r)
       

class Rect2D():
    def __init__(self,a,b):
        self.a = a
        self.b = b
        
    def is_square(self):
        if self.a == self.b:
            print("This is a square.")
        else:
            print("This is NOT a square.")
            
    def print_area(self):
        print(self.a*self.b)



circle = Circle(4)
rect1 = Rect2D(2,5)
rect2 = Rect2D(3,3)

print()

circle.print_area()
rect1.is_square()
rect2.is_square()
rect1.print_area()
rect2.print_area()

print()
