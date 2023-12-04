#include "hamming.h"

int compute(const char *lhs, const char *rhs);

int compute(const char *lhs, const char *rhs){

    int contLhs = 0;
    int contRhs = 0;
    int erros = 0;

    while (lhs[contLhs] != '\0'){
        contLhs ++;
    }

    while (rhs[contRhs] != '\0'){
        contRhs ++;
    }

    if(contLhs != contRhs) return -1;

    for (int i = 0; i < contLhs; i++)
    {
       if(lhs[i] == rhs[i]) continue;;

       erros++;
    }
    

    return erros;
}