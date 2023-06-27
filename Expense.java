public class Expense {
	    // ---------------------------------------------------------
		// Assignment 4
		// Written by: Zaid Minhas 40243097
		// For COMP 248 Section R 2222 – Fall 2022
		// ---------------------------------------------------------
	
	private String expenseType;
	private float amount;
	private String name;
	private int dueMonth;
	private int dueDay;
	
	//Default constructor
	public Expense() {}
	
	//Initialize object with an expense type, amount, bussiness name, due month and date
	public Expense(String expenseType, float amount, String name, int dueMonth, int dueDay) {
		setExpenseType(expenseType);
		setAmount(amount);
		setName(name);
		setDueMonth(dueMonth);
		setDueDay(dueDay);
	}
	
	//Copy constructor
	public Expense( Expense e) {
		this.expenseType = e.expenseType;
		this.amount = e.amount;
		this.name = e.name;
		this.dueMonth = e.dueMonth;
		this.dueDay = e.dueDay;	
	}
	
	//accessors
	public String getExpenseType() {
		 return this.expenseType;
		 }
	
	public float getAmount() {
		 return this.amount;
		 }
	
	public String getName() {
		 return this.name;
		 }
	
	public int getDueMonth() {
		 return this.dueMonth;
		 }
	
	public int getDueDay() {
		 return this.dueDay;
		 }
	
	//Mutators
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	//if due day or month is outside of range then it will set it to 0
	public void setDueMonth(int dueMonth) {

		if (dueMonth >= 1 && dueMonth <= 12)
			this.dueMonth = dueMonth;
		else
			this.dueMonth = 0;
	}
	
	public void setDueDay(int dueDay) {
		if (dueDay >= 1 && dueDay <= 31)
			this.dueDay = dueDay;
		else
			this.dueDay = 0;
	}
	
	//Output the expense in the format """ ExpenseType - $amount - Business name - dueDay/dueMonth""" 
	public String toString() {
		String output;
		output = this.expenseType + " - $" + this.amount + " - " + this.name + " - ";
		//adding 0 before day or month if they are single digit integers
		if (this.dueDay < 10)
			output += "0";
		output += dueDay + "/";
		if (this.dueMonth < 10) 
			output += "0";
		output += dueMonth + ".";
		return output;
	}
	
	//Compare each attribute of 2 expenses
	public boolean equals(Expense e) {
		return this.expenseType == e.expenseType && this.amount == e.amount && this.name == e.name && this.dueMonth == e.dueMonth && this.dueDay == e.dueDay;
	}
	
}
