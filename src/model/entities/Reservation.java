package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exception.DomainException;

public class Reservation {

	private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private LocalDate checkIn;
	private LocalDate checkOut;
	private Integer roomNumber;
	
	public Reservation() {
		
	}
	
	public Reservation(LocalDate checkIn, LocalDate checkOut, Integer roomNumber) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public Integer duration() {
		return (int) ChronoUnit.DAYS.between(checkIn, checkOut);
	}
	
	public void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException {
		LocalDate dateLocal = LocalDate.now();
		if(checkIn.isBefore(dateLocal) || (checkOut.isBefore(this.checkOut) || checkOut.isBefore(dateLocal))) {
			throw new DomainException("Reservation dates for updates must be future dates");
		}
		if(checkOut.isBefore(checkIn)) {
			throw new DomainException("Check-out date must be adter check-in date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room: " + getRoomNumber() + "; Check-in: " + fmt.format(getCheckIn()) + "; Check-out: "
				+ fmt.format(getCheckOut()) + "; Duration: " + duration();
	}
	
}
