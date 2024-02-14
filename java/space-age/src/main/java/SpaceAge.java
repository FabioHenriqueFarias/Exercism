import java.text.DecimalFormat;

class SpaceAge {

    double seconds;
    DecimalFormat decimalFormat;

    SpaceAge(double seconds) {
        this.seconds = seconds;
        this.decimalFormat = new DecimalFormat("#.##");
    }

    double getDays() {
        return seconds / 60 / 60 / 24;
    }

    double getSeconds() {
        return seconds;
    }

    double onEarth() {
        double onEarth = getDays()/365.25;

        return Double.parseDouble(decimalFormat.format(onEarth));
    }

    double onMercury() {
        double onMercury = onEarth()/0.2408467;

        return Double.parseDouble(decimalFormat.format(onMercury));
    }

    double onVenus() {
        double onVenus = onEarth()/0.61519726;

        return Double.parseDouble(decimalFormat.format(onVenus));
    }

    double onMars() {
        double onMars = onEarth()/1.8808158;

        return Double.parseDouble(decimalFormat.format(onMars));    }

    double onJupiter() {
        double onVenus = onEarth()/11.862615;

        return Double.parseDouble(decimalFormat.format(onVenus));

    }

    double onSaturn() {
        double onSaturn = onEarth()/29.447498;

        return Double.parseDouble(decimalFormat.format(onSaturn));
    }

    double onUranus() {
        double onUranus = onEarth()/84.016846;

        return Double.parseDouble(decimalFormat.format(onUranus));
    }

    double onNeptune() {
        double onNeptune = onEarth()/164.79132;

        return Double.parseDouble(decimalFormat.format(onNeptune));
    }

}
