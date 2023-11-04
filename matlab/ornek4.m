

exam1 = input('Vize1 : ');
exam2 = input('Vize2 : ');
exam3 = input('Final : ');

average = (exam1 + exam2 + exam3) / 3;

disp('Ortalamaniz: ');
disp(average);

if average >= 90
    disp('Harf notunuz A')
elseif 90 > average && average >= 80
    disp('Harf notunuz B')
elseif 80 > average && average >= 70
    disp('Harf notunuz C')
elseif 70 > average && average >= 60
    disp('Harf notunuz D')
elseif 60 > average
    disp('Harf notunuz F')
end