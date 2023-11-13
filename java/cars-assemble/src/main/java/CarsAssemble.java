public class CarsAssemble {
    int carsPerHours = 221;
    public double productionRatePerHour(int speed) {

        double count = 0;
        if((speed >= 1) && (speed <= 4)){
            count = carsPerHours * speed;
        } else if (speed <= 8) {
            count = (carsPerHours * speed) * 0.90;
        } else if( speed == 9){
            count = (carsPerHours * speed) * 0.80;
        }else{
            count = (carsPerHours * speed) * 0.77;
        }

        return count;
    }

    public int workingItemsPerMinute(int speed) {
        double productionPerHour = productionRatePerHour(speed);
        return (int) (productionPerHour/60);
    }
}