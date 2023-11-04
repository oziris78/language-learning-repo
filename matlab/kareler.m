

clear all
clc

n = input('sayi giriniz: ');

dosya = fopen('kareler.txt', 'w+');

for i = 1:n
    fprintf(dosya, 'i: %d, i^2: %d', i, i^2);
    fprintf(dosya, '\n');
end
fclose(dosya);











