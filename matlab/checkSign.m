
function [] = checkSign(x)
    if x < 0
        disp("x is negative")
    elseif x == 1
        disp("x is one!!! easter egg!!!")
    elseif x > 0
        disp("x is positive")
    else
        disp("x is zero")
    end
end
