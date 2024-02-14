class NaturalNumber {

    int number; 
    
    NaturalNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        this.number = number;
    }

    Classification getClassification() {

        int sum = calculateNicomaco();

        if(this.number == sum){
            return Classification.PERFECT;
        }

        if(this.number > sum){
            return Classification.DEFICIENT;
        }

        return Classification.ABUNDANT;
    }

    int calculateNicomaco(){

    int sum = 0;
        
        for(int i = 1; i < this.number; i++){
            if(this.number%i == 0){
                sum += i;
            }
        }

        return sum;
    }
}
