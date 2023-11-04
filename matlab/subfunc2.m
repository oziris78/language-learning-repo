function [avg,med] = subfunc2(u)
    n = length(u);
    avg = mean(u,n);
    med = mymedian(u,n);
end

function a=mean(v,n)%alt fonksiyon
    a = sum(v) / n;
end

