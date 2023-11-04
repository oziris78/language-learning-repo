

clc
clear all

i = 1;
while i < 16
    x(i) = i;
    y(i) = 1 / i^2;
    i = i+1;
end

% plot(x, y);
plot(y);