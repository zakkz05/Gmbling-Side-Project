package gamblingProj;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class gamblersGame {
	public static void main(String[] args) {
		Scanner takeIn = new Scanner(System.in); 
		
		print("Enter Your Name Below to Play: ");
		String name = takeIn.nextLine();
		
		boolean devilstango = true;
		
		while (devilstango == true){
			
			print("\nThis is VERY dangerous do you still want to play..?\n\nYES or NO " + name.toUpperCase() + "?\n");
			String choice = takeIn.nextLine();
				
			gamblingProj gambler = new gamblingProj(name, choice);
			
			if (choice.equals("yes") || choice.equals("YES") || choice.equals("Yes")) {
				gambler.isGambling();
			}
			else {
				print("\nYou have chosen to live another day\nAlso your soul hasn't been taken\nCongratulations " + name + "!");
				takeIn.close();
				rollCredits();
			}
			
			print("\nHow much are you willing to risk "+ name +"?\n"); 			
			
			Timer time = new Timer();
			time.schedule(new TimerTask(){
				@Override
				public void run() {
					print("Your life?\n");
				}
			}, 1000);
			time.schedule(new TimerTask(){
				@Override
				public void run() {
					print("Your family?\n");
				}
			}, 2000);
			time.schedule(new TimerTask(){
				@Override
				public void run() {
					print("No No No We Want Your MONEY!!!\n");
				}
			}, 3000);
			time.schedule(new TimerTask(){
				@Override
				public void run() {
					print("Give us the number amount of money that you want to place a bet with!");
				}
			}, 4000);	
			
			int budget = takeIn.nextInt();
			takeIn.nextLine();
			
			while (budget < 1000000000) {
				if (budget < 10000) {
					break;
				}
				while (budget >= 10000) {
					print("We do not suggest using amount this large!!!! Please enter in an amount less than " + budget);
					
					budget = takeIn.nextInt();
					takeIn.nextLine();
					
					if (budget < 10000) {
						break;
					}
				}
			}
			
			if (gambler.getWinnings() > 1) {
				time.schedule(new TimerTask(){
					@Override
					public void run() {
						print("\nWait a minute.....");
						print("bEeP BoOp BeE BoO bOp\n\n");
					}
				}, 1000);
				time.schedule(new TimerTask(){
					@Override
					public void run() {
						print("Our record show you have more than one win!!!!\n");
					}
				}, 2000);
				time.schedule(new TimerTask(){
					@Override
					public void run() {
						print("Would you like to add the balance of $" + gambler.amountWon()+ " to your budget? (YES / NO)"); // figure out why the budget after a win comes out at 0
					}
				}, 3000);
				String addBalance = takeIn.nextLine();
				if (addBalance.equals("yes") || addBalance.equals("YES") || addBalance.equals("Yes")) {
					budget = budget + gambler.getBudget();
				}
			}
			
			gambler.gamblersBudget(budget);
			
			
			ArrayList<Integer> arr = new ArrayList<>();
			
			for(int i = 1; i <= budget; i++) {
				arr.add(i);
			}
			for(int i = 0; i < arr.size(); i++) {
				System.out.print(String.format("%-5d", arr.get(i)));
				if ((i + 1) % 10 == 0) {
					print("");
				}
			}			
			
			print("Pick a number shown above to be your amount to bet");
			gambler.setBetAmount((takeIn.nextInt())); 
			takeIn.nextLine();
			
			print("\nPick a random number from 0 to " + budget + "\nLike your life depends on it!!!!");
			gambler.setBetNumber(takeIn.nextInt()); 
			takeIn.nextLine();
			
			print("\nA number will be chosen " + name + "...\nThe question is whether it will be Higher or Lower than " + gambler.getBetNumber() + " " + name + "?");
			print("Think for a while, then make your move: (Higher / Lower)? ");
			gambler.setHighorLow(takeIn.nextLine());
				
			
			// edge case if bet amount is not in given range if (setBetAmount != ()){print("Invalid amount")};	
			
			print("\nThe house has now chosen a number and it was: " + gambler.houseNumber());
			
			gambler.Comparison();
			
		}		
	}
	
	
	public static void print(String x) {
		System.out.println(x);
	}
	
	public static void rollCredits() {
		print("\n\nGambling Your Life Away");
		print("Made by Zachary Kertesz");
		print("Thank you for trying!");
		System.exit(0);
	}
}
