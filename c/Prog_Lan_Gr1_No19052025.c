

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

// Oguzhan Topaloglu YTU Matematik muhendisligi 19052025 prog. dilleri 2 hulya hocanin grubu arasinav 1 odev calismasi
// NOTLARI KODUN BASINA (BURAYA) YAZIYORUM:
// not 1: size mail atarak fonksiyon adlarini Turkcelestirip prototip birakmak yerine dogrudan basta tanimlayabilir miyim diye sormustum ve evet demistiniz
// not 2: ing. adlari birakip ustlerine Turkce aciklama yaziyorum
// not 3: convert_2_orthogonal_basis fonksiyonunda gostergelere hakim olmadigim icin cok kod yazdim ancak fonksiyon sorunsuz calisiyor :D
// not 4: fonksiyonlar pdf'de verildikleri siraya gore yazilmamistir ancak hepsi kodda bulunmaktadir


typedef struct{
double x;
double y;
double z;
} Vector;


// vektorleri v1=(1. bilesen, 2. bil., 3. bil.) diye yazdirma fonksiyonu
void print_vector(const Vector v) {
	printf("(%.2lf, %.2lf, %.2lf)\n", v.x, v.y, v.z);
}

// iki vektorun toplamini dondurme fonksiyonu
Vector sum(const Vector v1, const Vector v2) {
	Vector v3;
	v3.x=v1.x+v2.x;
	v3.y=v1.y+v2.y;
	v3.z=v1.z+v2.z;
	return v3;
}

// iki vektorun farkini dondurur, sirayla v1,v2 verilirse v1-v2 doner
Vector diff(const Vector v1, const Vector v2) {
	Vector v3;
	v3.x=v1.x-v2.x;
	v3.y=v1.y-v2.y;
	v3.z=v1.z-v2.z;
	return v3;
}

// iki vektorun nokta carpimini dondurur
double dot_product(const Vector v1, const Vector v2) {
	double dondur;
	dondur= (v1.x*v2.x)+(v1.y*v2.y)+(v1.z*v2.z);
	return dondur;
}

// verilen vektoru bir gercek sayi ile carpip dondurur
Vector multiplyby_scalar(const Vector v1, const double c) {
	Vector v3;
	v3.x = v1.x*c;
	v3.y = v1.y*c;
	v3.z = v1.z*c;
	return v3;
}

// iki vektorun capraz carpimini dondurur, sirayla v1,v2 verilirse v1xv2 doner
Vector cross_product(const Vector v1, const Vector v2) {
	Vector v3;
	v3.x = (v1.y*v2.z)-(v1.z*v2.y);
	v3.y = (v1.z*v2.x)-(v1.x*v2.z);
	v3.z = (v1.x*v2.y)-(v1.y*v2.x);
	return v3;
}

// bir vektorun uzunlugunu (norm) dondurur
double norm(const Vector v) {
	double dondur;
	dondur = sqrt(dot_product(v,v));
	return dondur;
}

// vektor birim vektorse 1, degilse 0 donduren fonksiyon (0 ve 1'i ben atadim)
int is_unitvector(const Vector v) {
	int dondur;
	if(norm(v)==1) {dondur=1;}
	else dondur=0;
	return dondur;
}

// verilen vektoru birim vektor yapip dondurur
Vector unit(const Vector v) {
	Vector v3;
	v3.x = v.x / norm(v); 
	v3.y = v.y / norm(v); 
	v3.z = v.z / norm(v); 
	return v3;
}

// iki vektor arasindaki aciyi verir
double angle(const Vector v1, const Vector v2) {
	double dondur;
	dondur = acos(dot_product(v1,v2)/(norm(v1)*norm(v2)));
	return dondur;
}

// iki vektor arasindaki uzakligi verir, mutlak(v1-v2) doner yani
double distance(const Vector v1, const Vector v2) {
	double dondur;
	dondur=norm(diff(v1,v2));
	return dondur;
}

// uc vektor dogrusal bagimsiz ise 1, degilse 0 veren fonksiyon
int are_linearly_independent(const Vector v1, const Vector v2, const Vector v3){
	int dondur;
	double det;
	det=(v1.x*v2.y*v3.z)+(v2.x*v3.y*v1.z)+(v3.x*v1.y*v2.z)-(v1.x*v3.y*v2.z)-(v2.x*v1.y*v3.z)-(v3.x*v2.y*v1.z);
	if(det!=0) {dondur=1;}
	else dondur=0;
	return dondur;
}

// uc vektor ortogonal ise 1, degilse 0 veren fonksiyon
int are_orthogonal(const Vector v1, const Vector v2, const Vector v3) {
	int dondur;
	if(dot_product(v1,v2)==0 && dot_product(v1,v3)==0 && dot_product(v2,v3)==0) {dondur=1;}
	else dondur=0;
	return dondur;
}

// uc vektor ortonormal ise 1, degilse 0 veren fonksiyon
int are_orthonormal(const Vector v1, const Vector v2, const Vector v3) {
	int dondur;
	if(are_orthogonal(v1,v2,v3)==1 && is_unitvector(v1)==1 && is_unitvector(v2)==1 && is_unitvector(v3)) {dondur=1;}
	else dondur=0;
	return dondur;
}

// v1'in v2 uzerine izdusumunu donduren fonksiyon
Vector projection(const Vector v1, const Vector v2) {
	Vector v3;
	double sayi1,sayi2,sayi3;
	sayi1=dot_product(v1,v2);
	sayi2=pow(norm(v2),2);
	sayi3=sayi1/sayi2;
	v3=multiplyby_scalar(v2,sayi3);
	return v3;
}

// v1'in ortogonal izdusum vektorunu v2 vektorune dondurur
Vector orthogonal_projection(const Vector v1, const Vector v2) {
	Vector v3;
	v3=diff(v1,projection(v1,v2));
	return v3;
}

// uc dogrusal bagimsiz vektoru gram schmidt ile ortogonal baza donusturur, vektorler dgr. bagimsiz ise 1
// degilse 0 dondurur ayrica
int convert_2_orthogonal_basis(Vector *v1, Vector *v2, Vector *v3){
	int dondur;
	Vector v4,v5,v6,d1,d2,d3;
	
	v4.x=v1->x;
	v4.y=v1->y;
	v4.z=v1->z;
	
	v5.x=v2->x;
	v5.y=v2->y;
	v5.z=v2->z;
	
	v6.x=v3->x;
	v6.y=v3->y;
	v6.z=v3->z;
	
	if(are_linearly_independent(v4,v5,v6)==0) {dondur=0; return dondur;};
	
	d1=v4;
	d2=diff(v5,projection(v5,d1));
	d3=diff(diff(v6,projection(v6,d1)),projection(v6,d2));
	
	v1->x=d1.x;
	v1->y=d1.y;
	v1->z=d1.z;
	
	v2->x=d2.x;
	v2->y=d2.y;
	v2->z=d2.z;
	
	v3->x=d3.x;
	v3->y=d3.y;
	v3->z=d3.z;
	
	dondur=1;
	return dondur;
}

// bir vektoru dizgiye donusturup dizgiyi donduren fonksiyon
// ornek: v1=(1.00,2.00,4.00) ise dizgi "(1.00,2.00,4.00)/0" olur
char* vector2str(const Vector v) {
	char *dizgi;
	dizgi = (char *)malloc(17*sizeof(char));
	sprintf(dizgi, "(%.2lf,%.2lf,%.2lf)", v.x, v.y, v.z);
	return dizgi;
}

// INT MAIN FONKSIYONU:
// INT MAIN FONKSIYONU:
// INT MAIN FONKSIYONU:

int main () {
	
	Vector v1 = {1, 2, 2}, v2 = {-1, 0, 2}, v3 = {0, 0, 1};
	double k = 2;

	printf("v1 = ");
	print_vector(v1);
	printf("v2 = ");
	print_vector(v2);
	printf("v3 = ");
	print_vector(v3);

	printf("v1 + v2 = ");
	print_vector(sum(v1, v2));

	printf("v1 - v2 = ");
	print_vector(diff(v1, v2));

	printf("k * v1 = ");
	print_vector(multiplyby_scalar(v1, k));

	printf("v1 . v2 = %.2lf\n", dot_product(v1, v2));

	printf("v1 x v2 = ");
	print_vector(cross_product(v1, v2));

	printf("| v1 | = %.2lf\n", norm(v1));

	if(is_unitvector(v1)==1) {printf("v1 is a unit vector.\n");}
	else printf("v1 is not unit vector.\n");

	printf("unit( v1 ) = ");
	print_vector(unit(v1));

	printf("angle(v1, v2) = %.2lf\n", angle(v1, v2));

	printf("distance(v1, v2) = %.2lf\n", distance(v1, v2));

	if(are_linearly_independent(v1, v2, v3)==1) {printf("Vectors are linearly independent.\n");}
	else printf("Vectors are not linearly independent.\n");

	if(are_orthogonal(v1, v2, v3)==1) {printf("Vectors are orthogonal.\n");}
	else printf("Vectors are not orthogonal.\n");

	if(are_orthonormal(v1, v2, v3)==1) {printf("Vectors are orthonormal.\n");}
	else printf("Vectors are not orthonormal.\n");

	printf("Projection of v1 onto v2 is = ");
	print_vector(projection(v1, v2));

	printf("Orthogonal projection of v1 onto v2 is = ");
	print_vector(orthogonal_projection(v1, v2));

	if(convert_2_orthogonal_basis(&v1, &v2, &v3)==1){
	printf("Orthogonalization of vectors:\n");
	printf("v1 = ");
	print_vector(v1);
	printf("v2 = ");
	print_vector(v2);
	printf("v3 = ");
	print_vector(v3);
	}

	puts(vector2str(v1));

	return 0;
}


