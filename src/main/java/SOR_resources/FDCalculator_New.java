
package SOR_resources;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.testng.annotations.Test;

public class FDCalculator_New 

{

	@Test
	public static void calculator() {
		double principal = 600000;
		double rate = 7.4 / 100;
		int compoundsPerYear = 4;
		LocalDate startDate = LocalDate.of(2025, 01, 12);
		int totalDays = 399;
		LocalDate maturityDate = LocalDate.of(2026, 2, 15);

		LocalDate currentDate = LocalDate.now();
		long elapsedDays = ChronoUnit.DAYS.between(startDate, currentDate);
		long remainingDays = ChronoUnit.DAYS.between(currentDate, maturityDate);

		double dailyRate = Math.pow(1 + (rate / compoundsPerYear), compoundsPerYear / 365.0) - 1;
		double perDayInterest = principal * dailyRate;

		if (remainingDays < 0) {
			System.out.println("The investment has already matured.");
			remainingDays = 0;
		}

		double elapsedTimeInYears = Math.max(elapsedDays / 365.0, 0);
		double totalTimeInYears = totalDays / 365.0;

		double currentMaturityAmount = principal
				* Math.pow(1 + (rate / compoundsPerYear), compoundsPerYear * elapsedTimeInYears);

		double totalMaturityAmount = principal
				* Math.pow(1 + (rate / compoundsPerYear), compoundsPerYear * totalTimeInYears);

		double currentExtraAmount = currentMaturityAmount - principal;
		double totalExtraAmount = totalMaturityAmount - principal;

		System.out.println("Investment Start Date: " + startDate);
		System.out.println("Maturity Date: " + maturityDate);
		System.out.println("Today's Date: " + currentDate);
		System.out.println("Elapsed Days: " + elapsedDays);
		System.out.println("Remaining Days: " + remainingDays);
		System.out.println("Current Maturity Amount: ₹" + String.format("%.2f", currentMaturityAmount));
		System.out.println("Extra Amount Earned So Far (Interest): ₹" + String.format("%.2f", currentExtraAmount));
		System.out.println(
				"Total Maturity Amount (on " + maturityDate + "): ₹" + String.format("%.2f", totalMaturityAmount));
		System.out.println("Total Extra Amount (Interest by end): ₹" + String.format("%.2f", totalExtraAmount));
		System.out.println("Per Day Interest: ₹" + String.format("%.2f", perDayInterest));
	}
}
