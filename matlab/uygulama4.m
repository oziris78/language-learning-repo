
clear all
clc

%{
4.
Bir öğrencinin üç tane sınav notunun ortalamasını 
alıp aşağıdaki şarta uygun olarak olarak notun
harfsel karşılığını veren programı yazınız.

ortalama>=90 ------------>A
80<=ortalama<90 -------------->B
70<=ortalama<80 ---------------->C
60<=ortalama<70 ---------------->D
ortalama<60 ---------------->F

%}

midterm1 = input('vize1 notunu giriniz: ');
midterm2 = input('vize2 notunu giriniz: ');
final = input('final notunu giriniz: ');

% average = median([midterm1, midterm2, final]);
average = (midterm1+midterm2+final) / 3;

if average >= 90
    disp(["ortalaman: ", average, " notun: A"]);
elseif 80 <= average && average < 90
    disp(["ortalaman: ", average, " notun: B"]);
elseif 70 <= average && average < 80
    disp(["ortalaman: ", average, " notun: C"]);
elseif 60 <= average && average < 70
    disp(["ortalaman: ", average, " notun: D"]);
elseif average < 60
    disp(["ortalaman: ", average, " notun: F"]);
end









