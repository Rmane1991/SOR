package SOR_resources;
public class FDCalculator {

    public static void main(String[] args) 
    {
        // Given data
        double principal = 950000; // Principal amount in INR
        double rate = 7.25 / 100;  // Annual interest rate as a decimal (7.25%)
        int compoundsPerYear = 4; // Quarterly compounding
        int days = 777;  // Total time in days

        // Convert days to years
        double timeInYears = days / 365.0;

        // Calculate maturity amount using compound interest formula
        double maturityAmount = principal * Math.pow(1 + (rate / compoundsPerYear), compoundsPerYear * timeInYears);

        // Calculate extra amount earned
        double extraAmount = maturityAmount - principal;

        // Output the results
        System.out.println("Maturity Amount: ₹" + String.format("%.2f", maturityAmount));
        System.out.println("Extra Amount (Interest): ₹" + String.format("%.2f", extraAmount));
    }
}
