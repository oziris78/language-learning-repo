#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>
#include <assert.h>


typedef struct strview {
	const char* str;
	size_t total_len;
	int begin, end;
} StrView;


StrView* strview_init(const char* str) {
	StrView* sv = (StrView*) malloc(sizeof(StrView));
	sv->str = str;
	sv->begin = 0;
	sv->total_len = strlen(str) - 1;
	sv->end = sv->total_len - 1;
	return sv;
}


char* strview_extract_cur_range(StrView* sv) {
	size_t len = (sv->end - sv->begin + 1);
	char* s = (char*) malloc(sizeof(char) * len);
	for(int i = 0; i < len; i++) {
		s[i] = sv->str[sv->begin + i];
	}
	return s;
}


char* strview_extract_new_range(StrView* sv, int begin, int end) {
	assert(end >= begin);
	sv->begin = begin;
	sv->end = end;
	return strview_extract_cur_range(sv);
}



int main() {
	StrView* sv = strview_init("hello world");
	char* s;

	s = strview_extract_new_range(sv, 0, 4);
	printf("String is {%s}\n", s);

	s = strview_extract_new_range(sv, 6, sv->total_len);
	printf("String is {%s}\n", s);

	s = strview_extract_new_range(sv, 4, 2); // assertion
	printf("String is {%s}\n", s);

	free(sv);
	free(s);
	
	return 0;
}

