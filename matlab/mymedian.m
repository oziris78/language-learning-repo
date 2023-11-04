function m=mymedian(v,n)%alt fonksiyon
    w=sort(v);
    if rem(n,2)==1
        m=w((n+1)/2);
    else
       m= (w(n/2)+w(n/2+1))/2;
    end
end