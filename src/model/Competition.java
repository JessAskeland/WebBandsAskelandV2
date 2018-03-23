package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "participating_bands")

public class Competition {
	@Id
	@Column(name = "competition_id")
	protected int competitionId;
	@Column(name = "band_id")
	private int bandId;
	@Transient
	String competitionName;
	@Transient
	String bandName;
	
	public Competition() {
		super();
	}

	public Competition(int competitionId, int bandId) {
		super();
		this.competitionId = competitionId;
		this.bandId = bandId;
	}
	
	public int getCompetitionId() {
		return competitionId;
	}

	public void setCompetitionId(int competitionId) {
		this.competitionId = competitionId;
	}

	public int getBandId() {
		return bandId;
	}

	public void setBandId(int bandId) {
		this.bandId = bandId;
	}

	public String displayCompetitions() {
		// TODO Auto-generated method stub
		String competitionDesc;
		switch (competitionId) {
		case 1:
			competitionDesc = "State Competition";
			break;
		case 2:
			competitionDesc = "Waukee Festival";
			break;
		case 3:
			competitionDesc = "New Years Design Competition";
			break;
		default:
			competitionDesc = "None";
		}

		String displayCompetitions = "Competition:  Band_id " + bandId + "  | Name of Band: " + getNameOfBand()
				+ " | Location of Band: " + getLocationOfBand()

				+ " | Competition:= " + competitionDesc;
		return displayCompetitions;

	}
	
	
	private String getNameOfBand() {
		// TODO Auto-generated method stub
		return bandName;
	}
	
	public String getCompetitionName() {
		if (this.competitionId == 1) {
			this.competitionName = "State Competition";
		}else if (this.competitionId == 2) {
			this.competitionName = "Waukee Festival";
		}else if (this.competitionId == 3) {
			this.competitionName = "New Years Disney Competition";
		}
		return competitionName;
	}

	private String getLocationOfBand() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String returnCompetitionDetails() {
		// TODO Auto-generated method stub
		String competitionDescription;
		if (competitionId == 1) {
			competitionDescription = "State Competition";
		}else {
			competitionDescription = "Waukee Festival";
		} 
		
		return "Attending " + competitionDescription  + " is band id " + bandId + ".";
	}
}
