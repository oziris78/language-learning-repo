
clear all
clc

%{
3.
Bir fabrika yarıçapları 0.2 cm’ den 1 cm’ye kadar 0.1 cm 
artarak değişen dairesel çelik plakalar üretmekte ve
bunları da birim çevre fiyatı 50 TL’ den satmaktadır.
Buna göre çelik plakaların yarıçaplarını çevrelerini ve toplam 
fiyatlarını veren, tablonun sonuna en büyük ve en
küçük plakanın fiyatları ile en büyük ve en küçük 
fiyat arasındaki farkı da ekleyen MATLAB programını döngü
kullanmadan yazınız.
%}

radiusValues = 0.2 : 0.1 : 1;
circumValues = 2 * pi * radiusValues;  %2*pi*r
priceValues = circumValues * 50;

disp(["radius", "circumfrence", "price"]);
disp([ radiusValues', circumValues', priceValues' ])

minPlateIndex = 1;
maxPlateIndex = length(radiusValues);

minPlatePrice = priceValues(minPlateIndex);
maxPlatePrice = priceValues(maxPlateIndex);

disp([ "minPlatePrice", minPlatePrice ]);
disp([ "maxPlatePrice", maxPlatePrice ]);
disp([ "difference", maxPlatePrice - minPlatePrice ]);


