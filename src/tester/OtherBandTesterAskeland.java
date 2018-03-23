package tester;

import java.util.List;
import java.util.Scanner;
import controller.bandsHelper;
import model.Band;

public class OtherBandTesterAskeland {

	static Scanner in = new Scanner(System.in);
	static bandsHelper bh = new bandsHelper();
	
	//ADD WORKS
	private static void addBands() {
		// TODO Auto-generated method stub
		System.out.print("Please enter a name of band: ");
		String nameOfBand = in.nextLine();
		System.out.print("Please enter a number of members: ");
		int numberOfMembers = in.nextInt();
		System.out.print("Please enter a location of band: ");
		String locationOfBand = in.nextLine();
		in.nextLine();
		System.out.print("Please enter a cost of partipation: ");
		Double costOfParticipation = in.nextDouble();
		in.nextLine();
		System.out.println("Please enter the level of band: ");
		Integer levelOfBand = in.nextInt();
		in.nextLine();
		
		Band toAdd = new Band(nameOfBand, numberOfMembers, locationOfBand, costOfParticipation, levelOfBand);
		bh.insertBands(toAdd);
	}
	//DELETE WORKS!	
	private static void deleteBands() {
		// TODO Auto-generated method stub
		System.out.print("Please enter the band id to delete: ");
		Integer bandId = in.nextInt();
		System.out.print("Please enter the name of band to delete: ");
		String nameOfBand = in.nextLine();
		in.nextLine();
				
		Band toDelete = new Band(bandId, nameOfBand);
		bh.delete(toDelete);

	}
	//VIEW WORKS
	private static void viewBands() {
		// TODO Auto-generated method stub
		List<Band> allItems = bh.showAllBands();
		for (Band li: allItems) {
			System.out.println(li);
		}
	}
	//EDIT WORKS!
	private static void editBands() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to look up a band? ");
		System.out.println("1 : Search by Name of Band");
		System.out.println("2 : Search by Location of Band");
		
		int searchBy = in.nextInt();
		in.nextLine();
		List<Band> foundItems;
		if (searchBy == 1) {
			System.out.print("Enter the name of band: ");
			String nameOfBand = in.nextLine();
			foundItems = bh.searchForNameOfBand(nameOfBand);
			
		} else {
			System.out.print("Enter the Location of Band: ");
			String locationOfBand = in.nextLine();
			foundItems = bh.searchForLocationOfBand(locationOfBand);
		}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (Band l : foundItems) {
				System.out.println(l.getNameOfBand() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			Band toEdit = bh.searchForItemById(idToEdit);
			System.out.println("Retrieved " + toEdit.getNameOfBand() + " from " + toEdit.getNameOfBand());
			System.out.println("1 : Update Name of Band");
			System.out.println("2 : Update Location of Band");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Name of Band: ");
				String newNameOfBand = in.nextLine();
				toEdit.setNameOfBand(newNameOfBand);
			} else if (update == 2) {
				System.out.print("New Location of Band: ");
				String newLocationOfBand = in.nextLine();
				toEdit.setLocationOfBand(newLocationOfBand);
			} 

			bh.updateNameOfBand(toEdit);

		} else {
			System.out.println("---- No results found");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//addBands();
		//deleteBands();
		//viewBands();
		runMenu();
	}
	
	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to the Bands menu ---");
		while (goAgain) {
			System.out.println("*  Select a method for Bands:");
			System.out.println("*  1 -- Add a new Band");
			System.out.println("*  2 -- Edit an existing Band");
			System.out.println("*  3 -- Delete a Band");
			System.out.println("*  4 -- View Bands");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addBands();
			} else if (selection == 2) {
				editBands();
			} else if (selection == 3) {
				deleteBands();
			} else if (selection == 4) {
				viewBands();
			} else {
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}
	

}
