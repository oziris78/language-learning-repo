

#include <stdio.h>
#define N 1

int main()
{
	struct krmsayi{
		int gercek;
		int sanal;
	};
	
	struct krmsayi s1,s2,s3;
	printf("Birinci sayiyi gercek ve sanal kismi ile giriniz:");
	scanf("%d",&s1.gercek);
	scanf("%d",&s1.sanal);
	printf("Ikinci sayiyi gercek ve sanal kismi ile giriniz:");
	scanf("%d",&s2.gercek);
	scanf("%d",&s2.sanal);
	
	s3.gercek=(s1.gercek*s2.gercek)-(s1.sanal*s2.sanal);
	s3.sanal=(s1.gercek*s2.sanal)+(s1.sanal*s2.gercek);
	
	
	printf("(%di+%d)x(%di+%d)=%di+%d",s1.sanal,s1.gercek,s2.sanal,s2.gercek,s3.sanal,s3.gercek);
	
	
	return 0;
}
