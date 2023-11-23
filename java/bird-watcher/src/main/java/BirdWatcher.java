
class BirdWatcher {
    private final int[] birdsPerDay;

    private int[] birdsLasWeek = {0, 2, 5, 3, 7, 8, 4};

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return this.birdsLasWeek;
    }

    public int getToday() {
        return this.birdsPerDay[this.birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        this.birdsPerDay[this.birdsPerDay.length - 1] += 1;
    }

    public boolean hasDayWithoutBirds() {
        for (int j : this.birdsPerDay) {
            if (j == 0) {
                return true;
            }
        }

        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {

        int count = 0;

        if(numberOfDays > 6){
            numberOfDays = this.birdsPerDay.length;
        }

        for (int i = 0; i < numberOfDays; i++) {
            count += this.birdsPerDay[i];
        }

        return count;
    }

    public int getBusyDays() {

        int count = 0;
        for (int j : this.birdsPerDay) {
            if(j >= 5){
                count++;
            }
        }

        return count;
    }
}
