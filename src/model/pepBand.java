package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@PrimaryKeyJoinColumn(name = "band_id", referencedColumnName = "band_id")
@DiscriminatorValue(value = "2")
@Table(name = "pep_band")

public class pepBand extends Band {
	@Column(name = "event_id")
	private int eventId;
	@Transient
	private String event;
	@Transient
	private String eventName;
	@Column(name = "playing_Position")
	private String playingPosition;

	public pepBand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public pepBand(int bandId) {
		super(bandId);
		// TODO Auto-generated constructor stub
	}
	
	public pepBand(String event, String eventName) {
		super(); 
		setEvent(event);
		this.eventName = eventName; 
	}
		
	public pepBand(int bandId, int eventId, String playingPosition) {
		super();
		this.bandId = bandId;
		this.eventId = eventId;
		this.playingPosition = playingPosition;
	}

	public pepBand(int eventId, String playingPosition, String event, String eventName) {
		super();
		this.eventId = eventId;
		this.playingPosition = playingPosition;
		this.event = event;
		this.eventName = eventName;
	}
	
	public pepBand(int numberOfMembers, String nameOfBand, String locationOfBand, 
			int levelOfBand, int eventId, String playingPosition) {
		super(numberOfMembers, nameOfBand, locationOfBand,  levelOfBand);
		this.eventId = eventId;
		this.playingPosition = playingPosition;
	}
	
	public pepBand(int numberOfMembers, String nameOfBand, String locationOfBand, String levelOfBand, String event,
			String eventName) {
		super(nameOfBand, numberOfMembers, locationOfBand, levelOfBand); 
		setEvent(event);
		this.eventName = eventName; 
	}

	public pepBand(int eventId, String eventName, String playingPosition, int numberOfMembers, String nameOfBand, String locationOfBand, Double costOfParticipation, int levelOfBand) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.playingPosition = playingPosition;
		this.numberOfMembers = numberOfMembers;
		this.nameOfBand = nameOfBand;
		this.locationOfBand = locationOfBand;
		this.costOfParticipation = costOfParticipation;
		this.levelBandId = levelOfBand;
	}
	
	public pepBand(String playingPosition) {
		super();
		this.playingPosition = playingPosition;
	}
	
	public pepBand(int numberOfMembers, String nameOfBand, String locationOfBand, int levelBandId, int eventId) {
		super(numberOfMembers, nameOfBand, locationOfBand, levelBandId);
		//setEvent(event); 
		setEventId(eventId);
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
		if (this.event.equalsIgnoreCase("assembly")) {
			this.playingPosition = "standing";
		} else if (this.event.equalsIgnoreCase("sports")) {
			this.playingPosition = "sitting";
		} else {
			throw new IllegalStateException("Invalid event type");
		}
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getPlayingPosition() {
		return playingPosition;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
		//making assumption based on current domain table
		if (this.eventId < 5) {
			this.playingPosition = "standing"; 
		} else  {
			this.playingPosition = "sitting"; 
		} 
		
	}
	
	@Override
	public String toString() {
		return "PepBand: \n- event = " + event + ", \n- eventName = " + eventName + ", \n- playingPosition = " + playingPosition
				+ ", toString()=" + super.toString() + "\n ";
	}

	@Override
	public String bandReport() {
		// TODO Auto-generated method stub
		return super.bandReport() + " You will be " + playingPosition + " while playing at the " + eventName + " "
				+ event + " event.\n";

	}

	public void setPlayingPosition(String newPlayingPosition) {
		// TODO Auto-generated method stub
		
	}

}