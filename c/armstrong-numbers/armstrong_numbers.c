#include "armstrong_numbers.h"
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#include <string.h>



bool is_armstrong_number(int candidate);



bool is_armstrong_number(int candidate){

    int soma;
    int digit;
    int counter = 0;

    char numberString[10];
    itoa(candidate, numberString, 10);

    for(int i=0; i < strlen(numberString); i++){
        if(isdigit(numberString[i])){
            counter ++;
        }
    }

    for(int i=0; i < strlen(numberString); i++){
        digit = numberString[i] - '0';

        soma += (int)round(pow(digit, counter)); 
    }

    if(candidate == soma){
        return true;
    }

    return false;

}

