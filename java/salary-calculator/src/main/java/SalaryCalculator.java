public class SalaryCalculator {
    public double multiplierPerDaysSkipped(int daysSkipped) {

        return (daysSkipped > 5) ? 0.85 : 1;
    }

    public int multiplierPerProductsSold(int productsSold) {

        return productsSold > 20 ? 13 : 10;
    }

    public double bonusForProductSold(int productsSold) {

        int unit = multiplierPerProductsSold(productsSold);
        return productsSold * unit;
    }

    public double finalSalary(int daysSkipped, int productsSold) {

        double result =  1000 * multiplierPerDaysSkipped(daysSkipped) + bonusForProductSold(productsSold);
        return (result > 2000) ? result = 2000 : result;

    }
}
