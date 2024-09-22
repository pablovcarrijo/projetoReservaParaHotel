package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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
	
	public Integer updateDates(LocalDate checkIn, LocalDate checkOut) {
		int okCheckUpdate = 1;
		if(checkIn.isBefore(this.checkIn) || checkOut.isBefore(this.checkOut) || checkOut.isBefore(checkIn)) {
			okCheckUpdate = 0;
			return okCheckUpdate;
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return okCheckUpdate;
	}
	
	@Override
	public String toString() {
		return "Room: " + getRoomNumber() + "; Check-in: " + fmt.format(getCheckIn()) + "; Check-out: "
				+ fmt.format(getCheckOut()) + "; Duration: " + duration();
	}
	
}
