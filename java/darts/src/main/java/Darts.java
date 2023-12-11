class Darts {
    int score(double xOfDart, double yOfDart) {
        double distance = Math.pow(xOfDart, 2) + Math.pow(yOfDart, 2);
        distance = Math.sqrt(distance);

        if(distance <= 1.0) {
            return 10;
        }else if(distance <= 5.0){
            return 5;
        }else if(distance <= 10.0){
            return 1;
        }

        return 0;
    }
}
