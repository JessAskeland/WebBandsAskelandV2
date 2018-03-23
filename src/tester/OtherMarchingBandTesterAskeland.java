package tester;

import java.util.List;
import java.util.Scanner;
import controller.marchingBandHelper;
import model.Band;
import model.marchingBand;

public class OtherMarchingBandTesterAskeland {

	static Scanner in = new Scanner(System.in);
	static marchingBandHelper mbh = new marchingBandHelper();
	
	//ADD WORKS!
	private static void addMarchingBand() {
		// TODO Auto-generated method stub
				
		//Elementary
		//marchingBand toAdd = new marchingBand(25, "Buffalo Bills", "Buffalo", 25.25, 1, "pom poms", 1, true);
		//mbh.insertMarchingBand(toAdd);
		
		//Junior High
		//marchingBand toAddv2 = new marchingBand(21, "Vikings", "Minneapolis", 37.50, 2, "batons", 2, false);
		//mbh.insertMarchingBand(toAddv2);
		
		//High School
		marchingBand toAddv3 = new marchingBand(34, "Eagles", "Philly", 26, 3, "flags", 3, true);
		mbh.insertMarchingBand(toAddv3);
		
	}
	//DELETE WORKS!!
	private static void deleteMarchingBand() {
		// TODO Auto-generated method stub
		System.out.print("Please enter the band id to delete: ");
		Integer bandId = in.nextInt();
						
		marchingBand toDelete = new marchingBand(bandId);
		mbh.delete(toDelete);

	}
	//VIEW WORKS!!
	private static void viewMarchingBand() {
		// TODO Auto-generated method stub
		List<marchingBand> allItems = mbh.showAllBands();
		for (marchingBand li: allItems) {
			System.out.println(li);
		}
	}
	
	private static void editMarchingBand() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to look up a band? ");
		System.out.println("1 : Search by Types of Props");
		
		int searchBy = in.nextInt();
		in.nextLine();
		List<marchingBand> foundItems = null;
		if (searchBy == 1) {
			System.out.print("Enter the Types of Props: ");
			String TypesOfProps = in.nextLine();
			foundItems = mbh.searchForTypesOfProps(TypesOfProps);
		}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (Band l : foundItems) {
				System.out.println(l.getTypesOfProps() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			marchingBand toEdit = mbh.searchForTypesOfProps(idToEdit);
			System.out.println("Retrieved " + toEdit.getTypesOfProps() + " from " + toEdit.getTypesOfProps());
			System.out.println("1 : Update Types of Props");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Types of Props: ");
				String newTypesOfProps = in.nextLine();
				toEdit.setTypesOfProps(newTypesOfProps);
			} 

			mbh.updateTypesOfProps(toEdit);

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
		System.out.println("--- Welcome to the Marching Band menu ---");
		while (goAgain) {
			System.out.println("*  Select a method for Marching Band:");
			System.out.println("*  1 -- Add a new Marching Band");
			System.out.println("*  2 -- Edit an existing Marching Band");
			System.out.println("*  3 -- Delete a Marching Band");
			System.out.println("*  4 -- View Marching Band");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addMarchingBand();
			} else if (selection == 2) {
				editMarchingBand();
			} else if (selection == 3) {
				deleteMarchingBand();
			} else if (selection == 4) {
				viewMarchingBand();
			} else {
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}
	


}
