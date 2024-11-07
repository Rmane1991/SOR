package SOR_resources;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateDifference 
{
	public static void main(String[] args) 
	{
		LocalDate startDate = LocalDate.now();
		LocalDate endDate = LocalDate.of(2025, 1, 10);

		long daysDifference = ChronoUnit.DAYS.between(startDate, endDate);

		System.out.println("The difference in days is: " + daysDifference);
	}
}