package tester;

import java.util.List;
import java.util.Scanner;
import controller.pepBandHelper;
import model.Band;
import model.pepBand;

public class OtherPepBandTesterAskeland {

	static Scanner in = new Scanner(System.in);
	static pepBandHelper pbh = new pepBandHelper();
	
	//ADD WORKS!
	private static void addPepBand() {
		// TODO Auto-generated method stub
				
		//pepBand toAdd = new pepBand(1, "girls basketball", "standing", 53, "Eagles", "Philly", 23.50, 1);
		//pbh.insertPepBand(toAdd);
		
		//pepBand toAdd = new pepBand(1, "boys basketball", "standing", 38, "Steelers", "Pittsburg", 89.50, 2);
		//pbh.insertPepBand(toAdd);
		
		//pepBand toAdd = new pepBand(2, "powder puff", "sitting", 93, "Raiders", "St Louis", 78.50, 1);
		//pbh.insertPepBand(toAdd);
		
		pepBand toAdd = new pepBand(2, "state final", "standing", 89, "Pelicans", "Newport", 93.50, 1);
		pbh.insertPepBand(toAdd);
	}
	
	private static void deletePepBand() {
		// TODO Auto-generated method stub
		System.out.print("Please enter the band id to delete: ");
		Integer bandId = in.nextInt();
				
		pepBand toDelete = new pepBand(bandId);
		pbh.delete(toDelete);

	}
	
	private static void viewPepBand() {
		// TODO Auto-generated method stub
		List<pepBand> allItems = pbh.showAllBands();
		for (pepBand li: allItems) {
			System.out.println(li);
		}
	}
	
	private static void editPepBand() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to look up a pep band? ");
		System.out.println("1 : Search by Playing Position");
		
		int searchBy = in.nextInt();
		in.nextLine();
		List<pepBand> foundItems = null;
		if (searchBy == 1) {
			System.out.print("Enter the Playing Position: ");
			String PlayingPosition = in.nextLine();
			foundItems = pbh.searchForPlayingPosition(PlayingPosition);
		}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (Band l : foundItems) {
				System.out.println(l.getPlayingPosition() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			pepBand toEdit = pbh.searchForPlayingPosition(idToEdit);
			System.out.println("Retrieved " + toEdit.getPlayingPosition() + " from " + toEdit.getPlayingPosition());
			System.out.println("1 : Update Playing Position");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Playing Position: ");
				String newPlayingPosition = in.nextLine();
				toEdit.setPlayingPosition(newPlayingPosition);
			} 

			pbh.updatePlayingPosition(toEdit);

		} else {
			System.out.println("---- No results found");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();
	}
	
	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to the Pep Band menu ---");
		while (goAgain) {
			System.out.println("*  Select a method for Pep Band:");
			System.out.println("*  1 -- Add a new Pep Band");
			System.out.println("*  2 -- Edit an existing Pep Band");
			System.out.println("*  3 -- Delete a Pep Band");
			System.out.println("*  4 -- View a Pep Band");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addPepBand();
			} else if (selection == 2) {
				editPepBand();
			} else if (selection == 3) {
				deletePepBand();
			} else if (selection == 4) {
				viewPepBand();
			} else {
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

}


