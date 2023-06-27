import java.util.Scanner;
public class BudgetDemo {
		// ---------------------------------------------------------
		// Assignment 4
		// Written by: Zaid Minhas 40243097
		// For COMP 248 Section R 2222 – Fall 2022
		// ---------------------------------------------------------
	
	public static void main(String[] args) {
		//Hard coded Household budgets put into an array hb
		Fund f1 = new Fund(1,2,3,4,5);
		Fund f2 = new Fund(f1);
		Fund f3 = new Fund(5,0,3,4,5);
		Fund f4 = new Fund();

		Expense e1 = new Expense("Bill", 99.99f, "Gigatron", 1,23);
		Expense e2 = new Expense("Loan", 1000000f, "Mafia", 12,10);
		Expense e3 = new Expense("Fine", 50f, "Police", 6,9);
		Expense e4 = new Expense("Bill", 100f, "Housing Services", 1,1);
		
		Expense[] ex1 = {e1,e2,e3,e4};
		Expense[] ex2 = {e3,e2,e1};
		Expense[] ex3 = {e1,e3,e4};

		
		HouseholdBudget h0 = new HouseholdBudget(f1,ex3);
		HouseholdBudget h1 = new HouseholdBudget(f2,ex2);
		HouseholdBudget h2 = new HouseholdBudget(f3,ex1);
		HouseholdBudget h3 = new HouseholdBudget(f4);
		HouseholdBudget h4 = new HouseholdBudget(f4);
		HouseholdBudget[] hb = {h0,h1,h2,h3,h4};
		//-----------------------------------------------------------------------------------------------------
		//userInput is the Scanner object
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n"
				+ "Welcome to COMP248 Geek's HouseholdBudget_2022 Application\n\n"
				+ "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
		String menu = "What would you like to do?\r\n"
				+ "  1. See the possessions of all householdBudgets\r\n"
				+ "  2. See the possessions of one householdBudget\r\n"
				+ "  3. List householdBudgets with same total amount of fund\r\n"
				+ "  4. List householdBudgets with same fund denomination(s)\r\n"
				+ "  5. List householdBudgets with same total amount of fund and same number of expenses\r\n"
				+ "  6. Add an expense to an existing householdBudget\r\n"
				+ "  7. Remove an existing expense from a householdBudget\r\n"
				+ "  8. Update the payment due date of an existing expense\r\n"
				+ "  9. Add fund to a householdBudget\r\n"
				+ "  0. To quit\r\n\n"
				+"Please enter your choice and press <Enter>:";
		
		
		//run loop that only stops once option 0 is chosen
		do {
		//Print out menu initialized above
		System.out.print(menu);
		//Input user choice as string to avoid error if non-numeric character(s) are entered
		String choice = userInput.nextLine();
		switch (choice){
		//Goodbye message, close Scanner object and close program
		case "0":
			System.out.println("Thank you for using COMP248 Geek's HouseholdBudget application!");
			userInput.close();
			System.exit(0);
			break;
			
		//Output each households Expenses (if any) and fund distribution
		case "1":
			System.out.println("Content of each HouseholdBudget");
			System.out.println("---------------------------------");
			//Loop through the hb array
			for (int i = 0; i < hb.length; i++) {
				System.out.println("HouseholdBudget #" + i + ":");
				System.out.println(hb[i].toString());
			}
			break;
			
		//Output a specific households Expenses (if any) and fund distribution by letting user choose house number
		case "2":
			System.out.print("Which HouseholdBudget you want to see the possessions of? (Enter number 0 to " + (hb.length-1) + "): ");
			int house = userInput.nextInt();
			while (house >= hb.length || house < 0) {
				System.out.println("Sorry but there is no HouseholdBudget number " + house);
				System.out.print("--> Try again: (Enter number 0 to " + (hb.length-1) +"):");
				house = userInput.nextInt();
			}
			System.out.println(hb[house]);
			userInput.nextLine();
			break;
			
		//Case 3 to 5 use same 2 for loops, the 2nd loops iterator is always greater than first loops to avoid repeated comparison ex (1 and 2) and (2 and 1)
			
		//Finds every pair of households that share same total fund
		case "3":
			System.out.println("List of HouseholdBudgets with the same fund total:\n");
			for (int i = 0; i < hb.length-1; i++) 
				for (int j = i+1; j < hb.length; j++) 
					if (hb[i].equalFundTotal(hb[j])) 
						System.out.println("\tHouseholdBudget " + i + " and " + j + " both have " +  hb[i].fundTotal() + ".0");
			break;
		
		//Finds every pair of households with same fund distribution
		case "4":
			System.out.println("List of HouseholdBudgets with the same Fund:\n");
			for (int i = 0; i < hb.length-1; i++) 
				for (int j = i+1; j < hb.length; j++) 
					if (hb[i].equalFundDist(hb[j]))
						System.out.println("\tHouseholdBudegt " + i + " and " + j + " both have " + hb[i].breakdown());
			break;
		
		//Find every pair of households with same amount of funds and number of expenses
		case "5":
			System.out.println("List of HouseholdBudgets with the same amount of money and same number of expenses:\n");
			for (int i = 0; i < hb.length-1; i++)
				for (int j = i+1; j < hb.length; j++)
					if (hb[i].equals(hb[j]))
						System.out.println("\tHouseholdBudget " + i + " and " + j );
			break;
		
		//Adds new expense to a household
		case "6":
			System.out.print("Which HouseholdBudget to you want to add an Expense to? (Enter number 0 to " + (hb.length-1)+") ");
			int house1 = userInput.nextInt();
			//validation check to see if household entered exists
			while (house1 >= hb.length || house1 < 0) {
				System.out.println("Sorry but there is no HouseholdBudget number " + house1);
				System.out.print("--> Try again: (Enter number 0 to " + (hb.length-1) +"):");
				house1 = userInput.nextInt();
			}
			System.out.println("Please enter the following information so that we may complete the expense-");
			System.out.print("--> Type of expense (Bill, Purchases, etc ...): ");
			userInput.nextLine();
			String type = userInput.nextLine();
			
			System.out.print("--> Amount of the expense: ");
			float amount = userInput.nextFloat();
			
			System.out.print("--> Name of the business: ");
			userInput.nextLine();
			String name = userInput.nextLine();
			
			System.out.print("--> Payment due day number and month (seperate by a space): ");
			int day = userInput.nextInt();
			int month = userInput.nextInt();
			userInput.nextLine();
			
			Expense newExp = new Expense(type, amount, name, month, day);
			int num = hb[house1].addExpense(newExp);
			//add an s to expense if more than 1 expense
			System.out.println("You now have " + num + " expense" + ((num == 1) ? "" : "s"));
			break;
			
		case "7":
			System.out.print("Which HouseholdBudget to you want to remove an expense from? (Enter number 0 to " + (hb.length-1)+"): ");
			int house2 = userInput.nextInt();
			while (house2 >= hb.length || house2 < 0) {
				System.out.println("Sorry but there is no HouseholdBudget number " + house2);
				System.out.print("--> Try again: (Enter number 0 to " + (hb.length-1) +"):");
				house2 = userInput.nextInt();
			}
			if (hb[house2].numExpenses() == 0) {
				System.out.println("Sorry that HouseholdBudget has no expenses");
			}
			else {
				System.out.println("(Enter number from 0 to " + (hb[house2].numExpenses()- 1) + "):");
				int pos = userInput.nextInt();
				boolean change = hb[house2].popExpense(pos);
				if (change) {
					System.out.println("Expense was removed successfully");
				}
				else {
					System.out.println("No expense was removed");
				}
			}
			userInput.nextLine();
			break;
			
		case "8":
			System.out.print("Which HouseholdBudget to you want to update an expense from? (Enter number 0 to " + (hb.length-1)+"): ");
			int house3 = userInput.nextInt();
			while (house3 >= hb.length || house3 < 0) {
				System.out.println("Sorry but there is no HouseholdBudget number " + house3);
				System.out.print("--> Try again: (Enter number 0 to " + (hb.length-1) +"):");
				house3 = userInput.nextInt();
			}
			if (hb[house3].numExpenses() == 0) {
					System.out.println("Sorry that HouseholdBudget has no expenses");
					userInput.nextLine();
				}
			else {
				System.out.println("(Enter number from 0 to " + (hb[house3].numExpenses()- 1) + "):");
				int pos1 = userInput.nextInt();
				while (pos1  < 0 || pos1 >= hb[house3].numExpenses()) {
					System.out.println("Sorry but there is no expense number " + pos1);
					System.out.println("--> Try again:");
					System.out.println("(Enter a number 0 to " + (hb[house3].numExpenses()- 1) + "):");
					pos1 = userInput.nextInt();
				}
				System.out.print("Enter new payment due day number and month (seperate by a space): ");
				int newDay = userInput.nextInt();
				int newMonth = userInput.nextInt();
				hb[house3].updateDue(newDay, newMonth, pos1);
				System.out.println("Due Date updated.");
				userInput.nextLine();
			}
			break;
			
		case "9":
			System.out.println("Which HouseholdBudget do you want to add Fund to? (Enter number 0 to " + (hb.length-1)+"): ");
			int house4 = userInput.nextInt();
			while (house4 >= hb.length || house4 < 0) {
				System.out.println("Sorry but there is no HouseholdBudget number " + house4);
				System.out.print("--> Try again: (Enter number 0 to " + (hb.length-1) +"):");
				house4 = userInput.nextInt();
			}
			System.out.println("How many loonies, toonies, $5, $10, and $20 bill do you want to add?");
			System.out.print("(Enter 5 numbers seperated by a space): ");
			int one = userInput.nextInt(); 
			int two = userInput.nextInt();
			int five = userInput.nextInt();
			int ten  = userInput.nextInt();
			int twenty = userInput.nextInt();
			hb[house4].AddFund(one, two, five, ten, twenty);
			System.out.println("You know have $" + hb[house4].fundTotal() + ".00");
			userInput.nextLine();
			break;
			
		default:
			System.out.println("Sorry that is not a valid choice. Try again.\n");
		}
		System.out.println();
		} while (true);

	}

}