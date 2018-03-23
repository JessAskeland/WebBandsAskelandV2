package tester;

//import java.awt.List;
import java.util.Scanner;
import controller.competitionHelper;
import model.Competition;
import java.util.List;

public class CompetitionTesterAskeland {

	static competitionHelper ch = new competitionHelper();
	static Scanner in = new Scanner(System.in);
	
	//ADD WORKS!!
		private static void addNewCompetition() {
			// TODO Auto-generated method stub

	        Competition toAdd = new Competition(1, 33);
			ch.insertCompetition(toAdd);
		}
	//VIEW WORKS!!	
		private static void viewCompetition() {
			// TODO Auto-generated method stub
			List<Competition> allCompetitions = ch.showAllCompetitions();
			for (Competition ph : allCompetitions) {
				System.out.println(ph.displayCompetitions());
			}
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();
	}

	private static void runMenu() {
		// TODO Auto-generated method stub
		boolean goAgain = true;
		System.out.println("--- This is the Competition Menu ---");
		while (goAgain) {
			System.out.println("*  Select a method for Competition Bands:");
			System.out.println("*  1 -- Add a Competition Band");
			//System.out.println("*  2 -- Edit a comp Band");
			//System.out.println("*  3 -- Delete a comp Band");
			System.out.println("*  4 -- View Competition Bands");
			System.out.println("*  5 -- Exit the program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addNewCompetition();
//			} else if (selection == 2) {
//				editACompetition();
//			} else if (selection == 3) {
//				deleteACompetition();
			} else if (selection == 4) {
				viewCompetition();
			} else {
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}
		}
	}
}