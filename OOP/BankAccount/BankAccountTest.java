public class BankAccountTest {
	public static void main(String[] args) {
		BankAccount Bob = new BankAccount();
		BankAccount Joe = new BankAccount();
		
		Bob.deposit("savings", 25);
		Joe.deposit("checking", 250);
		Bob.AccountBal();
		Joe.AccountBal();
		System.out.println(Bob.withdraw("savings", 10));
		System.out.println(Joe.withdraw("checking", 100));
		Bob.AccountBal();
		Joe.AccountBal();
	}
}