public class Lasagna {

    // TODO: define the 'expectedMinutesInOven()' method
    public int expectedMinutesInOven(){
        return 40;
    }

    // TODO: define the 'remainingMinutesInOven()' method
    public int remainingMinutesInOven(int lasagna){
        return this.expectedMinutesInOven() - lasagna;
    }

    // TODO: define the 'preparationTimeInMinutes()' method
    public int preparationTimeInMinutes(int camadas){
        return camadas * 2;
    }

    // TODO: define the 'totalTimeInMinutes()' method
    public int totalTimeInMinutes(int numberOfCamadas, int minutesInForno){
        return this.preparationTimeInMinutes(numberOfCamadas) + minutesInForno;
    }
}
