package SOR_resources;

public class EMICalculator {

    public static void main(String[] args) {
        // Given data
        double loanAmount = 2210000;  // Principal loan amount in INR
        double annualRate = 8.35;  // Annual interest rate in percentage
        int tenureInYears = 30;  // Loan tenure in years

        // Calculate EMI
        double emi = calculateEMI(loanAmount, annualRate, tenureInYears);
        
        // Output the result
        System.out.println("EMI Amount: ₹" + String.format("%.2f", emi));
    }

    public static double calculateEMI(double principal, double annualRate, int tenureInYears) {
        // Convert annual rate to monthly rate (percentage to decimal)
        double monthlyRate = annualRate / 12 / 100;
        
        // Convert loan tenure from years to months
        int tenureInMonths = tenureInYears * 12;
        
        // Apply the EMI formula
        double emi = (principal * monthlyRate * Math.pow(1 + monthlyRate, tenureInMonths)) /
                     (Math.pow(1 + monthlyRate, tenureInMonths) - 1);
        
        return emi;
    }
}

