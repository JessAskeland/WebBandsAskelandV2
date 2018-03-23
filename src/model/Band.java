package model;
import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "band_type",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value="band")
@Table(name="band")

public class Band {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "band_id")
	protected int bandId;
	@Column(name = "name_of_band")
	protected String nameOfBand;
	@Column(name = "num_of_members")
	protected int numberOfMembers;
	@Column(name = "location_of_band")
	protected String locationOfBand;
	@Column(name = "cost_of_participation")
	protected double costOfParticipation;
	@Column(name = "band_type")
	protected String band_type;
	@Column(name = "level_of_band")
	protected int levelBandId;
	@Transient
	protected String levelOfBand;
	@Transient
	final double JUNIOR_HIGH_COST = 25.50;
	@Transient
	final double HIGH_SCHOOL_COST = 45.00;
	@Transient
	final double ELEMENTARY_COST = 15.50;
	@Transient
	double quantityDiscount;
	@Transient
	DecimalFormat df = new DecimalFormat("$###0.00");
	@Transient
	final int ELEMENTARY_LEVEL_ID = 1;
	@Transient
	final int JUNIOR_HIGH_LEVEL_ID = 2;
	@Transient
	final int HIGH_SCHOOL_LEVEL_ID = 3;

	public Band() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Band(int bandId) {
		super();
		this.bandId = bandId;
	}
	
	//public Band(int numberOfMembers, String nameOfBand, String locationOfBand, int levelBandId) {
		//super();
		//setNumberOfMembers(numberOfMembers);
		//this.nameOfBand = nameOfBand;
		//this.locationOfBand = locationOfBand;
		//setLevelBandId(levelBandId);
	//}
	
	public Band(int numberOfMembers, String nameOfBand, String locationOfBand, int levelBandId) {
		super();
		setNumberOfMembers(numberOfMembers);
		this.nameOfBand = nameOfBand;
		this.locationOfBand = locationOfBand;
		setLevelBandId(levelBandId);
		this.costOfParticipation = calcCostOfParticipation(numberOfMembers,levelBandId);
	}

	public Band(int bandId, String nameOfBand, int numberOfMembers, String locationOfBand, double costOfParticipation,
			String levelOfBand) {
		super();
		this.bandId = bandId;
		this.nameOfBand = nameOfBand;
		this.numberOfMembers = numberOfMembers;
		this.locationOfBand = locationOfBand;
		this.costOfParticipation = costOfParticipation;
		this.levelOfBand = levelOfBand;
	}
	
	//Needed in marching band
	public Band(int numberOfMembers, String nameOfBand, String locationOfBand, double costOfParticipation,
		int levelBandId) {
		super();
		this.numberOfMembers = numberOfMembers;
		this.nameOfBand = nameOfBand;
		this.locationOfBand = locationOfBand;
		this.costOfParticipation = costOfParticipation;
		this.levelBandId = levelBandId;
	}
	
	public Band(String nameOfBand, int numberOfMembers, String locationOfBand, double costOfParticipation,
			String levelOfBand) {
		super();
		this.nameOfBand = nameOfBand;
		this.numberOfMembers = numberOfMembers;
		this.locationOfBand = locationOfBand;
		this.costOfParticipation = costOfParticipation;
		this.levelOfBand = levelOfBand;
	}

	public Band(String nameOfBand, int numberOfMembers, String locationOfBand, double costOfParticipation,
			int levelBandId) {
		super();
		this.nameOfBand = nameOfBand;
		this.numberOfMembers = numberOfMembers;
		this.locationOfBand = locationOfBand;
		this.costOfParticipation = costOfParticipation;
		this.levelBandId = levelBandId;
	}
	
	//Needed in marching bands
	public Band(int numberOfMembers, String nameOfBand, String locationOfBand, double costOfParticipation) {
		super();
		this.numberOfMembers = numberOfMembers;
		this.nameOfBand = nameOfBand;
		this.locationOfBand = locationOfBand;
		this.costOfParticipation = costOfParticipation;
	}
	
	//Used for delete	
	public Band(int bandId, String nameOfBand) {
		super();
		this.bandId = bandId;
		this.nameOfBand = nameOfBand;
	}

	//Used in BandsTesterAskeland
	public Band(String nameOfBand, int numberOfMembers, String locationOfBand, String levelOfBand) {
		super();
		this.nameOfBand = nameOfBand;
		this.numberOfMembers = numberOfMembers;
		this.locationOfBand = locationOfBand;
		this.levelOfBand = levelOfBand;
	}
	
	public int getNumberOfMembers() {
		return numberOfMembers;
	}

	public void setNumberOfMembers(int numberOfMembers) {
		this.numberOfMembers = numberOfMembers;
		if (this.numberOfMembers < 20) {
			quantityDiscount = 0;
		} else if (this.numberOfMembers > 40) {
			quantityDiscount = 7.75;
		} else if (this.numberOfMembers > 60) {
			quantityDiscount = 10.50;
		} else {
			quantityDiscount = 13.50;
		}

	}

	public int getBandId() {
		return bandId;
	}
	
	public int getLevelBandId() {
		return levelBandId;
	}

	public void setLevelBandId(int levelBandId) {
		this.levelBandId = levelBandId;
	}

	public String getNameOfBand() {
		return nameOfBand;
	}

	public void setNameOfBand(String nameOfBand) {
		this.nameOfBand = nameOfBand;
	}

	public String getLocationOfBand() {
		return locationOfBand;
	}

	public void setLocationOfBand(String locationOfBand) {
		this.locationOfBand = locationOfBand;
	}

	public double getCostOfParticipation() {
		return costOfParticipation;
	}
	
	public void setCostOfParticipation(int numberOfMembers, int levelOfBand) {
		this.costOfParticipation = calcCostOfParticipation(numberOfMembers,levelBandId);
	}

	public String getLevelOfBand() {
		return levelOfBand;
	}
	
	public String getBand_type() {
		return band_type;
	}

	public void setBand_type(String band_type) {
		this.band_type = band_type;
	}

	public void setLevelOfBand(String levelOfBand) {
		this.levelOfBand = levelOfBand;
		if (this.levelOfBand.equalsIgnoreCase("JH")) {
			this.costOfParticipation = JUNIOR_HIGH_COST - quantityDiscount;
		} else if (this.levelOfBand.equalsIgnoreCase("HS")) {
			this.costOfParticipation = HIGH_SCHOOL_COST - quantityDiscount;
		} else {
			throw new IllegalStateException("Please enter a valid band level");
		}
	}

	private double calcCostOfParticipation(int numberOfMembers2, int levelOfBand2) {
		// TODO Auto-generated method stub
		System.out.println("members " + numberOfMembers);
		if (numberOfMembers < 30) {
			quantityDiscount = 0;
		} else if (numberOfMembers > 100) {
			quantityDiscount = 15.00;
		} else {
			quantityDiscount = 5.50;
		} 
		
		System.out.println("level " + levelBandId);
		if (levelBandId == JUNIOR_HIGH_LEVEL_ID) {
			this.costOfParticipation = JUNIOR_HIGH_COST - quantityDiscount;
		} else if (levelBandId == HIGH_SCHOOL_LEVEL_ID) {
			this.costOfParticipation = HIGH_SCHOOL_COST - quantityDiscount;
		} else if (levelBandId == ELEMENTARY_LEVEL_ID) {
			this.costOfParticipation = ELEMENTARY_COST - quantityDiscount;
		} else {
			throw new IllegalStateException("Invalid band level id - " + levelBandId);
		}
		System.out.println(costOfParticipation);
		return costOfParticipation;
	}
	@Override
	public String toString() {
		return "Bands: \n- numberOfMembers = " + numberOfMembers + ", \n- nameOfBand = " + nameOfBand + ", \n- locationOfBand = "
				+ locationOfBand + ", \n- costOfParticipation = " + costOfParticipation + ", \n- levelOfBand = " + levelOfBand
				+ " ";
	}
	
	public String bandReport() {
		return "The " + this.nameOfBand + " band is located in the city of " + this.locationOfBand + ". It will cost "
				+ df.format(costOfParticipation) + " for this band to join.\n";

	}

	public String getTypesOfProps() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPlayingPosition() {
		// TODO Auto-generated method stub
		return null;
	}

}
