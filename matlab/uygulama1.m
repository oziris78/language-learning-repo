
%{
Yarıçapları 1’den 5’e kadar değişen 
kürelerin hacimlerini 
hesaplayan programı while döngüsü
kullanarak yazınız.
%}

clear all
clc

% V = (4/3) * PI * R^3

i = 1;
while i <= 5
    V = (4/3) * pi * i^3;  % PI değil "pi"
    disp([i V]);

    i = i + 1;
end


