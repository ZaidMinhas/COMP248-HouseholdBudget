public class HouseholdBudget {
		// ---------------------------------------------------------
		// Assignment 4
		// Written by: Zaid Minhas 40243097
		// For COMP 248 Section R 2222 – Fall 2022
		// ---------------------------------------------------------
	
	//Declare an object of class Fund and an array of objects of class Expense
	private Fund fund;
	private Expense[] expenses;
	
	//Constructor that takes in fund object and array of expenses 
	public HouseholdBudget(Fund fund, Expense[] expenses) {
		this.fund = fund;
		this.expenses = expenses;
	}
	
	//Constructor that takes in only fund object and  initializes expense array to size 0
	public HouseholdBudget(Fund fund) {
		this.fund = fund;
		this.expenses = new Expense[0];
	}
	
	//Checks if 2 household budgets have same total funds
	public boolean equalFundTotal(HouseholdBudget hb) {
		return this.fund.fundTotal() == hb.fund.fundTotal();
	}
	
	//Checks if 2 household budgets have same fund distribution
	public boolean equalFundDist(HouseholdBudget hb) {
		return this.fund.equals(hb.fund);
	}
	//Returns total fund of a household
	public int fundTotal() {
		return this.fund.fundTotal();
	}
	
	//Returns number of expenses in a household budget
	public int numExpenses() {
		return this.expenses.length;
	}
	
	//Add a new expense to a household budget 
	public int  addExpense(Expense e) {
		int len = this.numExpenses();
		Expense[] newE = new Expense[len+1];
		for (int i = 0; i < len; i++) {
			newE[i] = this.expenses[i];
		}
		newE[len] = e;
		this.expenses = newE;
		return this.numExpenses();
	}

	//Remove a specific expense to a household budget
	public boolean popExpense(int pos) {
		//pos is the position of the element you want to remove
		//new Expense array size will be one less than old
		int len = this.numExpenses()-1;
		if (len == -1 || (pos > len || pos <0))
			return false;
		else {
			Expense[] newExp = new Expense[len];
			for (int i = 0; i < len; i++) {
				if (i < pos) {
					newExp[i] = expenses[i];
				}
				else {
					//i+1 because we always want the next element now
					newExp[i] = expenses[i+1];
				}
			}
			expenses = newExp;
			return true;
		}
	}
	
	//Change the due day and month of an expense 
	public void updateDue(int dueDay, int dueMonth, int i) {
		this.expenses[i].setDueDay(dueDay);
		this.expenses[i].setDueMonth(dueMonth);
	}
	
	//Add more funds to a Household budget and returns the new fund total
	public int AddFund(int oneAdd, int twoAdd, int fiveAdd,int  tenAdd,int  twentyAdd) {
		this.fund.AddFund(oneAdd, twoAdd, fiveAdd, tenAdd, twentyAdd);
		return this.fundTotal();
	}
	
	//checks if 2 household budgets have same fund total and number of expenses
	public boolean equals(HouseholdBudget h) {
		return this.fundTotal() == h.fundTotal() && this.numExpenses() == h.numExpenses();
	}
	
	//Print out the funds and expenses of a household budget
	public String toString() {
		String output = this.breakdown();
		output += "\n";
		
		if (this.numExpenses() == 0)
			output += "No Expenses\n";
		else {
			for (int i = 0; i < this.numExpenses(); i++) {
				output += this.expenses[i].toString();
				output += "\n";
				}
		}
		return output;
	}
	
	//Prints out the breakdown of the funds distribution
	public String breakdown() {
		return fund.toString();
	}
}

