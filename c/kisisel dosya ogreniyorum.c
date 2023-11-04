

#include <stdio.h>
#include <math.h>
#include <string.h>

#define N 100

// \n


int main()
{

	// dosyalar gostergelerle tutulur, o yuzden file gostergesi tanimlanir
	// modlar: 
	// 1- "w" yoksa acar ve degistirmemizi saglar ancak varsa silip yerine bombos bir sey acar (write)
	// 2- "r" verilen adda dosya varsa acip okumamizi saglar ancak yoksa gosterge null degeri alir (read)
	// 3- "a" var olan bir dosyanin icindeki bilgileri yitirmeden degistirebilirsin (add)
	// 4- sonlarina + gelirse hem okuma hem yazmaya yarar ancak kucuk farkliliklar var
	// ornek:
	// FILE *dosyag = fopen("dosya_adi", "mod")
	
	FILE *dosyag = fopen("denemeaga.txt", "w");
	
	if (dosyag==NULL) {printf("Dosya olusturulamadi.");}
	else {printf("Dosya olusturuldu.");}
	
	printf("\n\n");
	
	FILE *dosyagg = fopen("denemeaga2.txt", "r");
	
	if (dosyagg==NULL) {printf("Oyle bir dosya yok.");}
	else {printf("Dosya var");}
	
	printf("\n\n");
	
	
	// bununla istedigin yerde olusturabilirsin, \ yerine \\ koyman gerekli dikkat et!
	
	FILE *dosyaggg = fopen("C:\\Users\\oguzh\\Desktop\\denemeaga3.txt", "w");
	
	if (dosyaggg==NULL) {printf("Dosya olusturulamadi.");}
	else {printf("Dosya olusturuldu.");}
	
	printf("\n\n");
	
	
	// dosyalara bir sey yazma putc('karakter', gosterge_adi) ile yapilir
	
	putc('B', dosyaggg);
	putc('A', dosyaggg);
	putc('\n', dosyaggg);
	putc('N', dosyaggg);
	putc('E', dosyaggg);
	
	// bir metin yazdiracaksak dizgileri kullaniriz
	FILE *belgeg = fopen("C:\\Users\\oguzh\\Desktop\\bilgi.txt", "w");
	
	if (belgeg==NULL) {printf("Dosya olusturulamadi.");}
	else {printf("Dosya olusturuldu.");}
	
	char veri[N] = "merhaba ben oguzhan topaloglu";
	int uzunluk = strlen(veri);
	int i;
	
	for (i=0; i<=uzunluk; i++){
		putc(veri[i], belgeg);
	}
	
	// metin belgelerini okuma EOF = end of file onislemcisi ile yapilir do while yazilir
	// metinlere ekleme yapma
	
	FILE *dos = fopen("C:\\Users\\oguzh\\Desktop\\eklemeli.txt", "a");
	char yazi[256];
	
	if (dos==NULL) {printf("Dosya olusturulamadi.");}
	else {
		printf("Bir sey yaziniz:");
		fgets(yazi, 256, stdin);
		fputs(yazi, dos);
	}
	
	
	return 0;
}
