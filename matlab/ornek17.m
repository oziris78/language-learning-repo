

clc
clear all

K=[1 3 5;2 5 7;4 9 -1];

if K(1,1) == K(3,3)
    K(2,:) = K(2,:) * 2
else
    K(2,:) = K(2,:) + 3
end

