


rValues = 0.2:0.1:1;
circumValues = 2 * pi * rValues;
costValues = circumValues * 50;

disp([rValues' circumValues' costValues'])

maxCost = max(costValues);
minCost = min(costValues);

disp(['Max cost: ', num2str(maxCost)])
disp(['Min cost: ', num2str(minCost)])
disp(['Max-min cost: ', num2str(maxCost - minCost)])
disp(' ')
