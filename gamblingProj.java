package gamblingProj;

import java.util.Random;

public class gamblingProj {
	
	private static int winnings;
	private static int Winnings;
	private boolean isGambling;
	private String name;
	private String choice;
	private String highorlow;
	private int dealersNumber;
	private int budget;
	private int betAmount;
	private int betNumber;
	
	
	public void isGambling() {
		System.out.println("\nCongrats on choosing to gamble today " + name.toUpperCase());
		isGambling = true;	
	}
	
	public gamblingProj(String name, String choice) {
		this.name = name;
		this.choice = choice;
		winnings++;
	}
	
	public gamblingProj() {
		isGambling = true;
	}
		
	public int getWinnings() {
		return winnings;
	}
	
	public int amountWon() {
		return Winnings;
	}
	
	public void gamblersBudget(int budget) {
		this.budget = budget;
	}
	
	public int getBudget() {
		return budget;
	}
	
	public void youLost() {
		if (winnings == 1) {
			System.out.println(name + " you lost and now I have all of your " + budget + " dollars.\nHAHAHAHAHAHA!\nYou shouldn't have gambled today buddy!!!!!");
		}
		else {
			System.out.println(name + " you lost and now I have all of your " + Winnings + " dollars.\nHAHAHAHAHAHA!\nYou shouldn't have gambled today buddy!!!!!");
		}
		System.exit(0);
	}
	
	public int houseNumber() {
		Random rando = new Random();
		dealersNumber = rando.nextInt(0, budget);
		return dealersNumber;
	}
	
	public void setHighorLow(String highorlow) {
		this.highorlow = highorlow;
	}
	
	public void setBetAmount(int betAmount) {
		this.betAmount = betAmount;
	}
	
	public void setBetNumber(int betNumber) {
		this.betNumber = betNumber;
	}
	
	public int getBetNumber() {
		return betNumber;
	}
	
	public void Comparison() {
		if ((dealersNumber < betNumber) && highorlow.equals("Lower")) {
			Winnings = betAmount + Winnings;
			System.out.println("You have won this time surprisingly...\nCongratulations\n\nThis is your " + winnings + " win and you have now won $" + Winnings + " , don't get too excited though...");
		}
		else if ((dealersNumber > betNumber) && highorlow.equals("Higher")) {
			Winnings = betAmount + Winnings;
			System.out.println("You have won this time surprisingly...\n\nCongratulations\n\nThis is your " + winnings + " win and you won $" + Winnings + " , don't get too excited though...");
		}
		else {
			youLost();
		}
	}
}

