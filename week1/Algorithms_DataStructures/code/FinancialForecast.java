import java.util.Scanner;
public class FinancialForecast {
    public static double predictFutureValue(double currentValue, double rate, int years) {
        if (years == 0) {
            return currentValue;
        } else {
            return predictFutureValue(currentValue, rate, years - 1) * (1 + rate);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter current value: ");
        double currentValue = sc.nextDouble();
        System.out.print("Enter annual growth rate : ");
        double growthRate = sc.nextDouble();
        System.out.print("Enter number of years: ");
        int years = sc.nextInt();
        double futureValue = predictFutureValue(currentValue, growthRate, years);
        System.out.printf("Predicted future value after %d years: %.2f\n", years, futureValue);
        sc.close();
    }
}
