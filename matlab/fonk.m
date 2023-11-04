
function [y] = fonk(x)
    part1 = 1 / ( (x-0.3)^2 + 0.01  );
    part2 = 1 / ( (x-0.9)^2 + 0.04  );
    part3 = -6;
    y = part1 + part2 + part3;
end
