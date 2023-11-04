
clear all
clc

%{
5. Her bir elemanı satır ve sütun sayılarının 
karelerinin toplamından 1 eksik olacak şekilde 5 satır ve 5
sütundan oluşan kare matrisi for döngüsü kullanarak oluşturunuz.
%}

for row = 1:5
    for col = 1:5
        mat(row, col) = row^2 + col^2 - 1;
    end
end

disp(mat);




