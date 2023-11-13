#include "isogram.h"
#include <stddef.h>

bool is_isogram(const char phrase[]);

bool is_isogram(const char phrase[]){

    int cont = 0;
    char caracther;

    if(phrase == NULL){
        return false;
    }

     while (phrase[cont] != '\0')
    {
        cont ++;
    }

    
     for(int i=0; i < cont; i++){

        caracther = phrase[i];
        for(int j=i+1; j < cont; j++){

          if(caracther == phrase[j]){
            return true;
          }
        }
    }
    
    return false;
}

