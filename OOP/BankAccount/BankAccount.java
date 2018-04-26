import java.util.*;
import java.util.Random;

public class BankAccount {
	private String accountNum;
	private double checkingBal;
	private double savingsBal;
	private static int createdAccounts = 0;
	private static double totalBal = 0;
	
	public BankAccount() {
		accountNum = generateAccount();
		checkingBal = 0;
		savingsBal = 0;
		createdAccounts++;
	}
	private String generateAccount() {
		Random rand = new Random();
		String num = "0123456789";
		String account = "";
		for (int i=0; i<10; i++) {
			int randNum = (int)rand.nextInt(10);
			account += num.charAt(randNum);
		}
		return account;
	}
	public double getCheckingBal() {
		return checkingBal;
	}
	public double getSavingsBal() {
		return savingsBal;
	}
	public void deposit (String account, double amount) {
		if (account == "checking") {
			checkingBal += amount;
			totalBal += amount;
		} else if (account == "savings") {
			savingsBal += amount;
			totalBal += amount;
		} else {
			System.out.println("Select the account type you'd like to deposit into");
		}
	public boolean withdraw (String accoung, double amount) {
		if (account == "checking") {
			if (checkingBal < amount) {
				System.out.println("Insufficient funds");
				return false;
			}
			checkingBal -= amount;
			totalBal -= amount;
			return true;
		} else if (account == "savings") {
			if (savingsBal < amount) {
				System.out.println("Insufficient funds");
				return false;
			}
			savingsBal -= amount;
			totalBal -= amount;
			return true;
		} else {
			System.out.println("Select the account type you'd like to withdraw from");
			return false;
		}
	}
	public void AccountBal() {
		System.out.println("Your checking account balance is: " + checkingBal + "and your savings account balance is: " + savingsBal);
	}
	}
}	