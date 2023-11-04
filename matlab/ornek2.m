
clc
clear all

a = input('a: ');
b = input('b: ');
c = input('c: ');

det = b*b - 4 * a * c;

if det == 0
    x = -b / (2 * a);
    disp('Iki es cozum vardir:');
    disp([x x]);
else
    x1 = (-b + sqrt(det)) / (2*a);
    x2 = (-b - sqrt(det)) / (2*a);
    disp([x1 x2]);
end
    

