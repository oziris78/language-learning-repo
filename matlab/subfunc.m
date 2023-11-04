function [avg,med] = subfunc(u)
    n = length(u);
    avg = mean(u,n);
    med = median(u,n);
end

function a=mean(v,n)%alt fonksiyon
    a = sum(v) / n;
end

function m=median(v,n)%alt fonksiyon
    w=sort(v);
    if rem(n,2)==1
        m=w((n+1)/2);
    else
       m= (w(n/2)+w(n/2+1))/2;
    end
end