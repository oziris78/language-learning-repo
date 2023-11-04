

clc 
clear all

fib = [1, 1];
%index = input('Index: ');
index = 50;
while length(fib) < index
    nextIndex = length(fib)+1;
    fib(nextIndex) = fib(nextIndex-1) + fib(nextIndex-2);
end

fib(index)
