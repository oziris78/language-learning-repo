

clc
clear all

age = input('Yasinizi giriniz: ');

if age >= 120 || age < 0
    disp('Kapsam disi')
elseif 120 > age && age >= 60
    disp('Yasli')
elseif 60 > age && age >= 18
    disp('Yetiskin')
elseif 18 > age && age >= 13
    disp('Genc')
elseif 13 > age && age >= 1
    disp('Cocuk')
elseif 1 > age && age >= 0
    disp('Bebek')
end

