package SOR_resources;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateDifference 
{
	public static void main(String[] args) 
	{
		//LocalDate startDate = LocalDate.of(2024, 11, 25);
		LocalDate startDate = LocalDate.now();
		LocalDate endDate = LocalDate.of(2025, 1, 9);

		long daysDifference = ChronoUnit.DAYS.between(startDate, endDate);

		System.out.println("The difference in days is: " + daysDifference);
	}
}
