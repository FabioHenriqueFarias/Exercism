#include "isogram.h"
#include <stddef.h>
#include <ctype.h>

bool is_isogram(const char phrase[]);

bool is_isogram(const char phrase[]){

    int cont = 0;
    char caracther;

    if(phrase == NULL){
        return false;
    }

     while (phrase[cont] != '\0'){
        cont ++;
    }

    if(cont == 0){
        return true;
    }

    
     for(int i=0; i < cont; i++){

        caracther = phrase[i];
        for(int j=0; j < cont; j++){

          if(j == i){
            continue;
          }

           if(caracther == ' ' || caracther == '-'){
            continue;
          }

          if(caracther == phrase[j] || toupper(caracther) == phrase[j]){
            return false;
          }
        }
    }
    
    return true;
}

