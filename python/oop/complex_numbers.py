

class ComplexNumber:
    def __init__(self, real = 0, imaginary = 0):
        self.real = real
        self.imaginary = imaginary

    def __repr__(self):
        if self.imaginary == 0:
            return str(self.real)
        if self.real == 0:
            return str(self.imaginary) + "i"
        return f'{self.real} + {self.imaginary}i'


######################################################


def add(a1, a2):
    a3= ComplexNumber()
    a3.real = a1.real + a2.real
    a3.imaginary = a1.imaginary + a2.imaginary
    return a3


def multiply(a1, a2):
    a3 = ComplexNumber()
    a3.real = a1.real * a2.real - a1.imaginary * a2.imaginary
    a3.imaginary = a1.real * a2.imaginary + a1.imaginary * a2.real
    return a3


######################################################

a1, a2  = ComplexNumber(5, 1), ComplexNumber(5, -1)

print(f'({a1}) + ({a2}) = ({add(a1, a2)})')
print(f'({a1}) * ({a2}) = ({multiply(a1, a2)})')

print()

a1, a2  = ComplexNumber(55, 1), ComplexNumber(5, -6)

print(f'({a1}) + ({a2}) = ({add(a1, a2)})')
print(f'({a1}) * ({a2}) = ({multiply(a1, a2)})')



