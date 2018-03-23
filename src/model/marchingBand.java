 package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@PrimaryKeyJoinColumn(name = "band_id", referencedColumnName = "band_id")
@DiscriminatorValue(value="1")
@Table(name = "marching_band")

public class marchingBand extends Band {
	@Transient
	final int MINIMUM_NUMBER_BUSES = 1;
	
	@Transient
	private boolean hasProps;
	@Column(name = "types_of_props")
	private String typesOfProps;
	@Column(name = "number_of_buses")
	private int numberOfBuses;
	@Column(name = "has_color_guard")
	private boolean hasColorGuard;
	
	public marchingBand() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public marchingBand(int bandId) {
		super(bandId);
		// TODO Auto-generated constructor stub
	}

	public marchingBand(int bandId, String typesOfProps, int numberOfBuses, boolean hasColorGuard) {
		super();
		this.bandId = bandId;
		this.typesOfProps = typesOfProps;
		this.numberOfBuses = numberOfBuses;
		this.hasColorGuard = hasColorGuard;
	}
	
	public marchingBand(boolean hasProps, String typesOfProps, boolean hasColorGuard) {
		super();
		setHasProps(hasProps);
		this.typesOfProps = typesOfProps;
		setHasColorGuard(hasColorGuard);
	}

	public marchingBand(int numberOfMembers, String nameOfBand, String locationOfBand, String levelOfBand,
			boolean hasProps, String typesOfProps, boolean hasColorGuard) {
		super(nameOfBand, numberOfMembers, locationOfBand, levelOfBand);
		setHasProps(hasProps);
		this.typesOfProps = typesOfProps;
		setHasColorGuard(hasColorGuard);
	}

	public marchingBand(String typesOfProps, int numberOfBuses, boolean hasColorGuard) {
		super();
		this.typesOfProps = typesOfProps;
		this.numberOfBuses = numberOfBuses;
		this.hasColorGuard = hasColorGuard;
	}

	public marchingBand(int numberOfMembers, String nameOfBand, String locationOfBand, int levelBandId,
			 String typesOfProps, boolean hasColorGuard) {
		super(numberOfMembers, nameOfBand, locationOfBand, levelBandId);		
		this.typesOfProps = typesOfProps;
		setHasColorGuard(hasColorGuard);
	}

	public marchingBand(int numberOfMembers, String nameOfBand, String locationOfBand, double costOfParticipation,
			int levelBandId, String typesOfProps, int numberOfBuses, boolean hasColorGuard) {
		super(numberOfMembers, nameOfBand, locationOfBand, costOfParticipation, levelBandId);
		this.typesOfProps = typesOfProps;
		this.numberOfBuses = numberOfBuses;
		this.hasColorGuard = hasColorGuard;
	}

	public boolean isHasProps() {
		return hasProps;
	}
    //If there are props, another bus is required
	public void setHasProps(boolean hasProps) {
		this.hasProps = hasProps;
		if (hasProps) {
			this.numberOfBuses = MINIMUM_NUMBER_BUSES + 1;
		} else {
			this.numberOfBuses = MINIMUM_NUMBER_BUSES;
		}
	}

	public String getTypesOfProps() {
		return typesOfProps;
	}

	public void setTypesOfProps(String typesOfProps) {
		this.typesOfProps = typesOfProps;
	}

	public int getNumberOfBuses() {
		return numberOfBuses;
	}

	public boolean isHasColorGuard() {
		return hasColorGuard;
	}
    //If there is color guard, another bus will be needed
	public void setHasColorGuard(boolean hasColorGuard) {
		this.hasColorGuard = hasColorGuard;
		if (hasColorGuard) {
			this.numberOfBuses = this.numberOfBuses + 2;
		}
	}

	@Override
	public String toString() {
		return "MarchingBand: \n- hasProps = " + hasProps + ", \n- typesOfProps = " + typesOfProps + ", \n- numberOfBuses = "
				+ numberOfBuses + ", \n- hasColorGuard = " + hasColorGuard + ", " + super.toString() + " ";
	}
	
	@Override
	public String bandReport() {
		// TODO Auto-generated method stub
		if (hasProps) {
			if (numberOfBuses > 1) {
				return super.bandReport() + "Your band will be bringing " + typesOfProps + " and will be taking "
						+ numberOfBuses + " buses.\n";
			} else {
				return super.bandReport() + "Your band will be bringing " + typesOfProps + " and will be taking "
						+ numberOfBuses + " bus.\n";
			}
		} else {
			if (numberOfBuses > 1) {
				return super.bandReport() + "Your band will be taking " + numberOfBuses + " buses.\n";
			} else {
				return super.bandReport() + "Your band will be taking " + numberOfBuses + " bus.\n";
			}

		}
	}

}