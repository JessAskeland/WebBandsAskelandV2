package controller;

import java.util.ArrayList;

import model.Band;

public class bandsParticipating {
	private String eventName; 
	private ArrayList<Band> bandlist;
	
	
	public bandsParticipating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public bandsParticipating(String eventName, ArrayList<Band> bandlist) {
		super();
		this.eventName = eventName;
		this.bandlist = bandlist;
	}

	public bandsParticipating(String eventName) {
		super();
		this.eventName = eventName;
		bandlist = new ArrayList<Band>();
	}
	
	 
	public void addToEvent(Band newBand) {
		bandlist.add(newBand);
	}

	private String event;
	public String displayEvent() {
		event = "Roster for " + eventName + ": " + bandlist;
		return event;
	}
	@Override
	public String toString() {
		return "BandsParticipating: eventName=" + eventName + ", bandlist=" + bandlist + " ";
	}



}