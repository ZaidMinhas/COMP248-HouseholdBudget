public class Fund {
	
	// ---------------------------------------------------------
	// Assignment 4
	// Written by: Zaid Minhas 40243097
	// For COMP 248 Section R 2222 – Fall 2022
	// ---------------------------------------------------------

	//The value of each fund type is set to public static constant 
	public static final int oneVal = 1, twoVal =2, fiveVal = 5, tenVal = 10, twentyVal = 20;
	
	//Fund amount of each type
	private int one, two, five, ten, twenty;
	
	//Default constructor leads to all fund types being 0
	public Fund() {}
	
	//Initialize all fund values
	public Fund(int one, int two,int five, int ten, int twenty) {
		setOne(one);
		setTwo(two);
		setFive(five);
		setTen(ten);
		setTwenty(twenty);
	}
	
	//Copy constructor	
	public Fund(Fund f) {
		setOne(f.one);
		setTwo(f.two);
		setFive(f.five);
		setTen(f.ten);
		setTwenty(f.twenty);
	}
	
	//Mutator
	public void setOne(int one) {
		this.one = one;
	}
	public void setTwo(int two) {
		this.two = two;
	}
	public void setFive(int five) {
		this.five= five;
	}
	public void setTen(int ten) {
		this.ten= ten;
	}
	public void setTwenty(int twenty) {
		this.twenty= twenty;
	}
	
	//Accessor
	public int getOne() {
		return this.one;
	}
	public int getTwo() {
		return this.two;
	}
	public int getFive() {
		return this.five;
	}
	public int getTen() {
		return this.ten;
	}
	public int getTwenty() {
		return this.twenty;
	}
	
	//Add more funds to existing fund
	public void AddFund(int oneAdd, int twoAdd, int fiveAdd,int  tenAdd,int  twentyAdd) {
		this.one += 	oneAdd;
		this.two += 	twoAdd;
		this.five += 	fiveAdd;
		this.ten += 	tenAdd;
		this.twenty += 	twentyAdd;
	}
	//Output total fund by multplying each fund type to its amount
	public int fundTotal() {
		int total = this.one*oneVal + this.two*twoVal + this.five*fiveVal + this.ten*tenVal + this.twenty*twentyVal;
		return total;
	}
	
	//Output the funds denominations as string 
	public String toString() {
		return "(" + this.one+ " x $" +  Fund.oneVal + ") + "
				+ "(" + this.two+ " x $" +  Fund.twoVal + ") + "
				+ "(" + this.five + " x $" + Fund.fiveVal + ") + "
				+ "(" + this.ten + " x $" + Fund.tenVal + ") + "
				+ "(" + this.twenty + " x $" +  Fund.twentyVal + ")";
	}

	//Compare the fund distribution to another fund object
	public boolean equals(Fund f) {
		boolean output = this.one == f.one && this.two == f.two  && this.five == f.five  && this.ten == f.ten  && this.twenty == f.twenty;
		return output;
		}
	
}
