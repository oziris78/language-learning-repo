%x-3y = 2
%x+5y = 18
%4x-6y=20


clear all
clc

emptyZ = 1;
A = [1 -3 1; 1 5 1; 4 -6 1];
B = [ 2+emptyZ; 18+emptyZ; 20+emptyZ ];

% AX = B  <=>  X = inv(A) * B

disp( inv(A) * B );

