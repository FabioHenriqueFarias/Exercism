public class ElonsToyCar {

    private int battery = 100;
    private int metters = 0;
    public static ElonsToyCar buy() {
        ElonsToyCar elonsToyCar = new ElonsToyCar();
        return elonsToyCar;
    }

    public String distanceDisplay() {
        return "Driven %d meters".formatted(metters);
    }

    public String batteryDisplay() {

        if(this.battery <= 0){
            return "Battery empty";
        }

        return "Battery at %d%%".formatted(battery);

    }

    public void drive() {

        if(this.battery <= 0){
            batteryDisplay();
            return;
        }
        this.metters += 20;
        this.battery -= 1;
    }
}
