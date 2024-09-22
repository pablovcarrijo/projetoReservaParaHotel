package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class App {

	public static void main(String[] args) {
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		
		System.out.print("Room number: ");
		Integer roomNumber = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Check-in date (dd/MM/yyyy): ");
		String stringDate1 = sc.next();
		
		System.out.print("Check-out date (dd/MM/yyyy): ");
		String stringDate2 = sc.next();
		
		LocalDate date1 = LocalDate.parse(stringDate1, fmt);
		LocalDate date2 = LocalDate.parse(stringDate2, fmt);
		
		Reservation reserv = new Reservation(date1, date2, roomNumber);
		System.out.println(reserv);
		
		System.out.println();
		
		System.out.println("Enter data to update the reservation: ");
		System.out.print("Check-in date (dd/MM/yyyy): ");
		stringDate1 = sc.next();
		System.out.print("Check-out date (dd/MM/yyyy): ");
		stringDate2 = sc.next();
		
		date1 = LocalDate.parse(stringDate1, fmt);
		date2 = LocalDate.parse(stringDate2, fmt);
		
		Integer verify = reserv.updateDates(date1, date2);
		if(verify == 0) {
			System.out.println("Error in reservation");
		}
		else {
			System.out.println(reserv);
		}
		
	}

}
