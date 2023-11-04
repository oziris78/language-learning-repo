
clear all
clc

%{
ax^2 + bx + c = 0 şeklindeki ikinci derece 
denklemin çözümünü yapan MATLAB programını yazın.
%}

a = input('a sayisini giriniz: ');
b = input('b sayisini giriniz: ');
c = input('c sayisini giriniz: ');




% (x-2)(x-2) = x^2 - 4x + 4
% disc = b^2 - 4ac
disc = b * b - 4 * a * c;

results = [];

if disc > 0 || disc < 0
    sqrtDisc = sqrt(disc);
    x1 = (-b + sqrtDisc) / (2 * a);
    x2 = (-b - sqrtDisc) / (2 * a);
    results = [x1 x2];

elseif disc == 0
    x12 = -b / (2 * a);
    results = [x12];
end

disp(results);


% bütün soru polinomları kullanarak şöyle de yapılabilirdi
% disp(roots([a b c]));










