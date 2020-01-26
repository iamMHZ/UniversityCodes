package application.model;

import java.time.LocalDate;
import java.util.Date;

public class Ticket {

	private String origin;
	private String destination;

	private LocalDate depart;

	private int price;

	//private boolean isExpired;
	
	//for delete ticket
	private String id;

	public Ticket(String origin, String destination, LocalDate depart, int price, String id) {
		this.origin = origin;
		this.destination = destination;
		this.depart = depart;
		this.price = price;
		this.id = id;

	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getDepart() {
		return depart;
	}

	public void setDepart(LocalDate depart) {
		this.depart = depart;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
//
//	public boolean isExpired() {
//		return isExpired;
//	}
//
//	public void setExpired(boolean isExpired) {
//		this.isExpired = isExpired;
//	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		
		return id.trim() + " " + origin.trim() + " " + destination.trim() + " " + depart.toString().trim() + " " + price + "$";
	}

}
