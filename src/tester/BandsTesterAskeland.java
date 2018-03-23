package tester;

import java.util.Scanner;
import controller.bandsParticipating;
import model.Band;
import model.marchingBand;
import model.pepBand;

public class BandsTesterAskeland {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		Band bandOne = new Band("Comets",20,"Las Vegas","JH");
		System.out.println(bandOne);
		System.out.println(bandOne.bandReport());

		////marchingBand marchingBandOne = new marchingBand(false, "pompoms", false);
		////System.out.println(marchingBandOne);
		////System.out.println(marchingBandOne.bandReport());

		marchingBand marchingBandTwo = new marchingBand(14, "Raiders", "LA", "HS", true, "pompom", true);
		System.out.println(marchingBandTwo);
		System.out.println(marchingBandTwo.bandReport());

		pepBand bandThree = new pepBand("sports", "basketball");
		System.out.println(bandThree);
		////System.out.println(bandThree.bandReport());

		pepBand bandFour = new pepBand(12, "Bulldogs", "Des Moines", "JH", "assembly", "homecoming");
		System.out.println(bandFour);
		System.out.println(bandFour.bandReport());

		bandsParticipating state = new bandsParticipating("State"); 
		state.addToEvent(marchingBandTwo);
		state.addToEvent(marchingBandTwo);
		System.out.println(state.displayEvent());
		
		//User question and entry section:
		String bandName = inputBandName();
		String bandLevel = inputBandLevel();
		int numberMembers = inputNumberMembers();
		String bandLocation = inputBandLocation();
		 
		System.out.println("Is this a marching band? Y or N");
		String marchingBand = in.nextLine();
		if (marchingBand.equalsIgnoreCase("y")) { 
			System.out.println("Is your marching band bringing props? Y or N");
			String props = in.nextLine();
			
			String propType = null;
			boolean hasProps = false;
			if (props.equalsIgnoreCase("y")) {
				System.out.println("What props is your marching band bringing?");
				propType = in.nextLine();
				hasProps = true; 
			}
			
			System.out.println("Will your band color guard be attending? Y or N");
			String colorGuard = in.nextLine(); 
			boolean hasColorGuard = false;
			if (colorGuard.equalsIgnoreCase("y")) {
				hasColorGuard = true;
			}
			Band enteredBand = new marchingBand(numberMembers, bandName, bandLocation, bandLevel, hasProps, propType, hasColorGuard);
			System.out.println(enteredBand.bandReport());
			
		} else {
			System.out.println("Is this a pep band? Y or N");
			String pepBand = in.nextLine();
			if (pepBand.equalsIgnoreCase("y")) { 
				System.out.println("What type of event is your pep band playing at? Select assembly or sports.");
				String eventType = in.nextLine();
				
				String eventDetail = null;
				if (eventType.equalsIgnoreCase("sports")) {
					System.out.println("What sports event is your pep band playing at?");
					eventDetail = in.nextLine();
					System.out.println("TEST - Sports event type " + eventDetail); 
				} else if(eventType.equalsIgnoreCase("assembly")) {
					System.out.println("What assembly is your pep band playing at?");
					eventDetail = in.nextLine(); 
				}else {
					System.out.println("Invalid event type - you must enter 'assembly' or 'sports'");
				}
				//Same here, what is the difference in pepBands. The constructor doesn't match
				Band enteredBand = new pepBand(numberMembers, bandName, bandLocation, bandLevel, eventType,
						eventDetail);
				System.out.println(enteredBand.bandReport());
				
			} else { 
				Band enteredBand = new Band(bandName, numberMembers, bandLocation, bandLevel);
				System.out.println(enteredBand.bandReport());
			}
		}

		in.close();
	}
	public static int inputNumberMembers() {
		System.out.println("How many members are in your band?");
		int numberMembers = in.nextInt();
		in.nextLine();
		return numberMembers;
	}
	
	public static String inputBandName() {
		System.out.println("What is the name of your band?");
		String bandName = in.nextLine();
		return bandName;
	}
	
	public static String inputBandLevel() {
		System.out.println("What is the level of your band? JH or HS?");
		String bandLevel = in.nextLine();
		return bandLevel;
	}
	
	public static String inputBandLocation() {
		System.out.println("What city is your band located in?");
		String bandLocation = in.nextLine();
		return bandLocation;
	}
	 
}