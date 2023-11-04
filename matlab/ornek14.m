
clc
clear all

x = input('Pozitif bir sayi giriniz: ');

while x <= 0
    disp('Sayiniz pozitif olmali!');
    x = input('Pozitif bir sayi giriniz: ');
end

if rem(x, 2) == 0  % cift ise
    x = x / 2;
    x = x^2;
else % tek ise
    x = x + 1;
    x = x / 2;
    x = x^2;
end

disp(x)