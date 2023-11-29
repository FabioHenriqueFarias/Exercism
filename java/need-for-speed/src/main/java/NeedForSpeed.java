class NeedForSpeed {

    public int speed;

    public int travelledDistance;

    public int batteryDrain;

    private int battery;
    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
        this.travelledDistance = 0;
        this.battery = 100;
    }

    public boolean batteryDrained() {

        return this.battery <= 0;
    }

    public int distanceDriven() {

        return this.travelledDistance;
    }

    public void drive() {

        if(!this.batteryDrained()){
            this.battery -= this.batteryDrain;
            this.travelledDistance += this.speed;
        }

    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {

    private int distance;
    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean tryFinishTrack(NeedForSpeed car) {

        double distanceSpent = (double) this.distance/car.speed;

        return (distanceSpent * car.batteryDrain) <= 100.0;
    }
}
